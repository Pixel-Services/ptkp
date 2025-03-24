package com.pixelservices.plugin.configuration.finder;

import com.pixelservices.plugin.configuration.PluginConfig;

import java.nio.file.Path;

public interface PluginConfigurationFinder {
    PluginConfig findPluginConfiguration(String pluginId, Path path);
    PluginConfig findPluginConfiguration(String pluginId, Path path, String configFileName);
}
