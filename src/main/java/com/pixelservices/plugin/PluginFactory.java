package com.pixelservices.plugin;

import com.pixelservices.plugin.descriptor.PluginDescriptor;
import com.pixelservices.plugin.exceptions.PluginLoadException;
import com.pixelservices.plugin.loader.CustomClassLoader;

public class PluginFactory {
    public static Plugin createPlugin(PluginDescriptor descriptor, CustomClassLoader classLoader) throws PluginLoadException {
        try {
            Class<?> pluginClass = classLoader.loadClass(descriptor.getPluginClass());
            return (Plugin) pluginClass.newInstance();
        } catch (Throwable e) {
            throw new PluginLoadException("Failed to create plugin", e);
        }
    }
}