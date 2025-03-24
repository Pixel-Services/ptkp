package com.pixelservices.plugin.descriptor;

import com.pixelservices.plugin.depedency.PluginDependency;

import java.util.List;

public interface PluginDescriptor {
    String getPluginId();
    String getDescription();
    String getVersion();
    String getPluginClass();
    List<String> getAuthors();
    String getLicense();
    List<PluginDependency> getDependencies();
}
