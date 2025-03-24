package com.pixelservices.plugin.manager;

import com.pixelservices.plugin.PluginWrapper;
import com.pixelservices.plugin.lifecycle.PluginState;

import java.util.List;

public interface PluginManager {
    List<PluginWrapper> getPlugins();
    List<PluginWrapper> getPlugins(PluginState state);
    PluginWrapper getPlugin(String pluginId);
}
