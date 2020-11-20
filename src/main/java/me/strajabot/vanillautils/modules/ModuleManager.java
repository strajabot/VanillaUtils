package me.strajabot.vanillautils.modules;

import com.google.common.base.Preconditions;
import me.strajabot.vanillautils.Messages;
import me.strajabot.vanillautils.VanillaUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class ModuleManager {

    private Map<String, Module> available;

    private List<String> enabled;

    public ModuleManager() {
        available = new HashMap<>();
        enabled = new ArrayList<>();
    }

    private void addModule(@NotNull Module module) {
        Preconditions.checkNotNull(module, "Argument \"module\" can't be null");
        available.put(module.getIdentifier(), module);
    }

    public void enableModule(@NotNull String identifier) {
        Preconditions.checkNotNull(identifier, "Argument \"identifier\" can't be null");
        Preconditions.checkArgument(available.containsKey(identifier), "Module \""+ identifier + "\" doesn't exist");
        Preconditions.checkArgument(!enabled.contains(identifier), "Module \""+ identifier + "\" is already enabled");

        Module module = available.get(identifier);
        module.enable();
        enabled.add(identifier);

        info(colorize(Messages.moduleEnabled(module.getName()), GREEN_TEXT()));
    }

    public void disableModule(@NotNull String identifier) {
        Preconditions.checkNotNull(identifier, "Argument \"identifier\" can't be null");
        Preconditions.checkArgument(available.containsKey(identifier), "Module \""+ identifier + "\" doesn't exist");
        Preconditions.checkArgument(enabled.contains(identifier), "Module \""+ identifier + "\" is already disabled");

        Module module  = available.get(identifier);
        module.disable();
        enabled.remove(identifier);

        info(colorize(Messages.moduleDisabled(module.getName()), RED_TEXT()));
    }

    public List<String> getEnabled() {
        return Collections.unmodifiableList(enabled);
    }

    public Map<String, Module> getAvailable() {
        return Collections.unmodifiableMap(available);
    }

    private void info(@NotNull String message) {
        Preconditions.checkNotNull(message, "Argument \"message\" can't be null");
        VanillaUtils.get().getLogger().info(message);
    }
}
