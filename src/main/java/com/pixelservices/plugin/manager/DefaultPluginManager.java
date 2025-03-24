package com.pixelservices.plugin.manager;

import com.pixelservices.plugin.descriptor.finder.PluginDescriptorFinder;
import com.pixelservices.plugin.descriptor.finder.YamlDescriptorFinder;
import com.pixelservices.plugin.impl.SimplePlugin;
import com.pixelservices.plugin.lifecycle.PluginState;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultPluginManager extends AbstractPluginManager {
    public DefaultPluginManager() {
        this(Paths.get("plugins"));
    }

    public DefaultPluginManager(Path directory) {
        this(directory, new YamlDescriptorFinder());
    }

    public DefaultPluginManager(Path directory, PluginDescriptorFinder descriptorFinder) {
        super(directory, descriptorFinder);
    }

    public void start() {
        AtomicInteger failedCount = new AtomicInteger();

        getPlugins().forEach(pluginWrapper -> {
            try {
                if (pluginWrapper.getState().equals(PluginState.LOADED)) {
                    ((SimplePlugin) pluginWrapper.getPlugin()).start();
                }
            } catch (Throwable e) {
                pluginWrapper.setState(PluginState.FAILED);
                logger.error("Failed to start plugin: " + pluginWrapper.getPluginDescriptor().getPluginId(), e);
                failedCount.getAndIncrement();
            }
        });

        logger.info("Successfully started " + (getPlugins().size() - failedCount.get()) + " plugins. Failed to start " + failedCount.get() + " plugins.");
    }

    public void stop() {
        getPlugins().forEach(pluginWrapper -> {
            try {
                if (pluginWrapper.getState().equals(PluginState.LOADED)) {
                    ((SimplePlugin) pluginWrapper.getPlugin()).stop();
                }
            } catch (Throwable e){
                pluginWrapper.setState(PluginState.FAILED);
                logger.error("Failed to stop plugin: " + pluginWrapper.getPluginDescriptor().getPluginId(), e);
            }
        });

        unloadPlugins();
    }
}
