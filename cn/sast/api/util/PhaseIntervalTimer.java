package cn.sast.api.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class PhaseIntervalTimer {
    private static final Logger logger = Logger.getLogger(PhaseIntervalTimer.class.getName());
    
    private final AtomicInteger id = new AtomicInteger(0);
    private Long startTime;
    private Long endTime;
    private volatile Long elapsedTime;
    private final AtomicInteger phaseTimerActiveCount = new AtomicInteger(0);
    private final AtomicInteger phaseStartCount = new AtomicInteger(0);
    private List<TimeRange> ranges = new LinkedList<>();
    private final TreeMap<Integer, Snapshot> queue = new TreeMap<>();

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public String getPrefix() {
        return "";
    }

    public Long getElapsedTime() {
        if (phaseTimerActiveCount.get() != 0) {
            logger.severe(getPrefix() + "internal error: phaseTimerCount is not zero");
        }
        if (!ranges.isEmpty()) {
            logger.severe(getPrefix() + "internal error: ranges is not empty");
        }
        if (!queue.isEmpty()) {
            logger.severe(getPrefix() + "internal error: queue is not empty");
        }
        return elapsedTime;
    }

    public AtomicInteger getPhaseStartCount() {
        return phaseStartCount;
    }

    public Double getPhaseAverageElapsedTime() {
        int count = phaseStartCount.get();
        if (count <= 0) {
            return null;
        }
        
        Long elapsed = getElapsedTime();
        if (elapsed == null) {
            return null;
        }
        
        double average = elapsed.doubleValue() / count;
        return Double.isFinite(average) ? average : null;
    }

    public synchronized Snapshot start() {
        Snapshot result = new Snapshot(System.nanoTime(), id.getAndIncrement());
        if (startTime == null) {
            startTime = result.getStartTime();
        }
        
        queue.put(result.getId(), result);
        phaseTimerActiveCount.incrementAndGet();
        phaseStartCount.incrementAndGet();
        return result;
    }

    public synchronized void stop(Snapshot snapshot) {
        if (snapshot == null) {
            throw new IllegalArgumentException("snapshot cannot be null");
        }
        
        TimeRange timeRange = new TimeRange(snapshot.getStartTime(), System.nanoTime());
        long newEnd = Math.max(endTime != null ? endTime : timeRange.getMax(), timeRange.getMax());
        endTime = newEnd;

        int cur = phaseTimerActiveCount.decrementAndGet();
        ranges.add(timeRange);
        ranges = TimeRange.sortAndMerge(ranges);

        if (cur < 0) {
            logger.severe("internal error: phaseTimerCount is negative");
            return;
        }

        Integer lower = queue.lowerKey(snapshot.getId());
        if (lower == null) {
            long currentElapsed = elapsedTime != null ? elapsedTime : 0L;
            Map.Entry<Integer, Snapshot> higher = queue.higherEntry(snapshot.getId());
            
            long cutoff = higher == null 
                ? ranges.get(ranges.size() - 1).getMax()
                : (timeRange.getMax() <= higher.getValue().getStartTime() 
                    ? timeRange.getMax() 
                    : timeRange.getMin());

            for (int i = 0; i < ranges.size() && ranges.get(i).getMax() <= cutoff; i++) {
                TimeRange e = ranges.remove(i--);
                currentElapsed += e.getMax() - e.getMin();
            }
            elapsedTime = currentElapsed;
        }
        queue.remove(snapshot.getId());
    }

    @Override
    public String toString() {
        return String.format("elapsed time: %.2fs", 
            elapsedTime != null ? elapsedTime / 1_000_000_000.0 : 0.0);
    }

    public static class Snapshot {
        private final long startTime;
        private final int id;

        public Snapshot(long startTime, int id) {
            this.startTime = startTime;
            this.id = id;
        }

        public long getStartTime() {
            return startTime;
        }

        public int getId() {
            return id;
        }
    }
}