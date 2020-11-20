package me.strajabot.vanillautils;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

public class Messages {

    public static String pluginEnabled() {
        return "VanillaUtils has been enabled";
    }

    public static String pluginDisabled() {
        return "VanillaUtils has been disabled";
    }

    public static String moduleEnabled(@NotNull String moduleName) {
        Preconditions.checkNotNull(moduleName, "Argument \"moduleName\" can't be null");
        return String.format("Module: %s has been enabled", moduleName);
    }

    public static String moduleDisabled(@NotNull String moduleName) {
        Preconditions.checkNotNull(moduleName, "Argument \"moduleName\" can't be null");
        return String.format("Module: %s has been disabled", moduleName);
    }

}
