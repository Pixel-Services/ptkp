package com.pixelservices.plugin;

import com.pixelservices.plugin.descriptor.PluginDescriptor;
import com.pixelservices.plugin.exceptions.PluginLoadException;
import com.pixelservices.plugin.loader.CustomClassLoader;

import java.nio.file.Path;

public class PluginFactory {
    public static Plugin createPlugin(Path path, PluginDescriptor descriptor) throws PluginLoadException {
        try (CustomClassLoader classLoader = new CustomClassLoader(path, PluginFactory.class.getClassLoader())) {
            Class<?> pluginClass = classLoader.loadClass(descriptor.getPluginClass());
            return (Plugin) pluginClass.newInstance();
        } catch (Throwable e) {
            throw new PluginLoadException("Failed to create plugin", e);
        }
    }
}