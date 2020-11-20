package me.strajabot.vanillautils;

import me.strajabot.vanillautils.modules.ModuleManager;
import org.bukkit.plugin.java.JavaPlugin;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

public final class VanillaUtils extends JavaPlugin {

    public static VanillaUtils get() {
        return instance;
    }

    private static VanillaUtils instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info(colorize(Messages.pluginEnabled(), GREEN_TEXT()));

        new ModuleManager();
    }

    @Override
    public void onDisable() {
        getLogger().info(colorize(Messages.pluginDisabled(), RED_TEXT()));
        instance = null;
    }

}
