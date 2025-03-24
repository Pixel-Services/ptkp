package com.pixelservices.plugin.loader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(Path jarPath, ClassLoader parent) throws IOException {
        super(new URL[]{jarPath.toUri().toURL()}, parent);
        addDependencies(jarPath);
    }

    private void addDependencies(Path jarPath) throws IOException {
        try (JarFile jarFile = new JarFile(jarPath.toFile())) {
            Manifest manifest = jarFile.getManifest();
            if (manifest != null) {
                String classPath = manifest.getMainAttributes().getValue("Class-Path");
                if (classPath != null) {
                    for (String path : classPath.split(" ")) {
                        addURL(new URL(path));
                    }
                }
            }
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            return super.loadClass(name);
        } catch (ClassNotFoundException e) {
            for (URL url : getURLs()) {
                try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url}, getParent())) {
                    return urlClassLoader.loadClass(name);
                } catch (ClassNotFoundException ignored) {
                } catch (IOException ioException) {
                    throw new ClassNotFoundException("Failed to load class due to IO error", ioException);
                }
            }
            throw e;
        }
    }
}