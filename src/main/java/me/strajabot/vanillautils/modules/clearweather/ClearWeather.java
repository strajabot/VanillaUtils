package me.strajabot.vanillautils.modules.clearweather;

import me.strajabot.vanillautils.modules.Module;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.jetbrains.annotations.NotNull;

public class ClearWeather extends Module {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        info("Player joined server");
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if(event.toWeatherState()) event.setCancelled(true);
    }

    @EventHandler
    public void onThunderStorm(ThunderChangeEvent event) {
        if(event.toThunderState()) event.setCancelled(true);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "weather_clear";
    }

    @Override
    public @NotNull String getName() {
        return "Weather Clear";
    }

    @Override
    public void enable() {
        registerListeners();
    }

    @Override
    public void disable() {
        unregisterListeners();
    }

}
