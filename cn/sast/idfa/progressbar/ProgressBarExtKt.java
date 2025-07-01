package cn.sast.idfa.progressbar;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarRenderer;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public final class ProgressBarExtKt {
    @NotNull
    public static <Render extends ProgressBarRenderer> Render wrapper(
            @NotNull ProgressBar progressBar,
            @NotNull ProgressBarRendererWrapper<Render> newRenderWrapper) {
        if (progressBar == null) throw new IllegalArgumentException("progressBar cannot be null");
        if (newRenderWrapper == null) throw new IllegalArgumentException("newRenderWrapper cannot be null");

        try {
            Field actionField = ProgressBar.class.getDeclaredField("action");
            actionField.setAccessible(true);
            Object action = actionField.get(progressBar);

            Field rendererField = action.getClass().getDeclaredField("renderer");
            rendererField.setAccessible(true);
            ProgressBarRenderer renderer = (ProgressBarRenderer) rendererField.get(action);

            ProgressBarRenderer newRenderer = newRenderWrapper.wrap(progressBar, renderer);
            rendererField.set(action, newRenderer);
            return (Render) newRenderer;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to wrap progress bar renderer", e);
        }
    }

    @NotNull
    public static ProgressBarExt.DefaultProcessInfoRenderer wrapper(@NotNull ProgressBar progressBar) {
        if (progressBar == null) throw new IllegalArgumentException("progressBar cannot be null");
        return wrapper(progressBar, (pb, r) -> new ProgressBarExt.DefaultProcessInfoRenderer(pb, r));
    }

    @FunctionalInterface
    public interface ProgressBarRendererWrapper<R extends ProgressBarRenderer> {
        R wrap(@NotNull ProgressBar progressBar, @NotNull ProgressBarRenderer renderer);
    }
}
