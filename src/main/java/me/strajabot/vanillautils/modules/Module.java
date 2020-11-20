package me.strajabot.vanillautils.modules;

import com.google.common.base.Preconditions;
import me.strajabot.vanillautils.VanillaUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public abstract class Module implements Listener {

    public abstract void enable();
    public abstract void disable();
    @NotNull
    public abstract String getIdentifier();
    @NotNull
    public abstract String getName();

    protected Plugin getPlugin() {
        return VanillaUtils.get();
    }

    protected void info(@NotNull String log) {
        Preconditions.checkNotNull(log, "Argument \"log\" can't be null");
        getPlugin().getLogger().info(log);
    }

    protected void err(@NotNull String log) {
        Preconditions.checkNotNull(log, "Argument \"err\" can't be null");
        getPlugin().getLogger().warning(colorize(log, RED_TEXT()));
    }

    protected void err(@NotNull Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Argument \"throwable\" can't be null");
        String stacktrace = ExceptionUtils.getStackTrace(throwable);
        err(stacktrace);
    }

    public void registerListeners() {
        getPlugin().getServer().getPluginManager().registerEvents(this, getPlugin());
    }

    public void unregisterListeners() {
        HandlerList.unregisterAll(this);
    }
}
