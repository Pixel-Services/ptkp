package com.pixelservices.plugin.descriptor.finder;

import com.pixelservices.plugin.descriptor.PluginDescriptor;

import java.nio.file.Path;

public interface PluginDescriptorFinder {
    PluginDescriptor findPluginDescriptor(Path path);
}
