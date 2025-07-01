import cn.sast.common.OS;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.launch;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

@Deprecated(message = "Use MultiWorkerQueue instead.", replaceWith = @ReplaceWith(expression = "MultiWorkerQueue", imports = {}))
public final class TaskQueue<TaskData> {
    private static final Companion Companion = new Companion();
    private final String name;
    private final int numberThreads;
    private final Function3<TaskData, Integer, Continuation<? super Unit>, Object> action;
    private final Channel<TaskData> queue;

    public TaskQueue(@NotNull String name, int numberThreads, 
            @NotNull Function3<? super TaskData, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> action) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (action == null) throw new IllegalArgumentException("action cannot be null");
        
        this.name = name;
        this.numberThreads = Math.max(numberThreads, 1);
        this.action = action;
        this.queue = Channel.create(this.numberThreads * 2);
    }

    public TaskQueue(@NotNull String name, @NotNull Function3<? super TaskData, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> action) {
        this(name, Math.max(OS.INSTANCE.getMaxThreadNum() - 1, 1), action);
    }

    public final void addTask(TaskData taskData, boolean isLast) {
        ChannelResult.getOrThrow(queue.trySendBlocking(taskData));
        if (isLast) {
            queue.close();
        }
    }

    public final void addTask(TaskData taskData) {
        addTask(taskData, false);
    }

    public final void addTask(@NotNull Iterable<? extends TaskData> taskData) {
        if (taskData == null) throw new IllegalArgumentException("taskData cannot be null");
        for (TaskData t : taskData) {
            addTask(t, false);
        }
    }

    public final void addTaskFinished() {
        queue.close();
    }

    @NotNull
    public final Job runTask() {
        CoroutineScope scope = CoroutineScope(Dispatchers.getDefault());
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < numberThreads; i++) {
            Job job = scope.launch(new CoroutineName(name + "-" + i), () -> {
                while (true) {
                    TaskData data = queue.receive();
                    action.invoke(data, 0, null);
                }
            });
            jobs.add(job);
        }

        return scope.launch(new CoroutineName(name + "-joinAll"), () -> {
            for (Job job : jobs) {
                job.join();
            }
        });
    }

    public static final class Companion {
        private Companion() {}
    }
}