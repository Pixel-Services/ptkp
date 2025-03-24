package com.pixelservices.plugin.configuration;

public class PluginConfig {

    public String getString(String key) {
        return null;
    }

    public String getString(String key, String defaultValue) {
        String value = getString(key);
        return value != null ? value : defaultValue;
    }

    public int getInt(String key) {
        return 0;
    }

    public int getInt(String key, int defaultValue) {
        int value = getInt(key);
        return value != 0 ? value : defaultValue;
    }

    public boolean getBoolean(String key) {
        return false;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return getBoolean(key) || defaultValue;
    }

    public double getDouble(String key) {
        return 0.0;
    }

    public double getDouble(String key, double defaultValue) {
        double value = getDouble(key);
        return value != 0.0 ? value : defaultValue;
    }

    public long getLong(String key) {
        return 0L;
    }

    public long getLong(String key, long defaultValue) {
        long value = getLong(key);
        return value != 0L ? value : defaultValue;
    }

    public float getFloat(String key) {
        return 0.0f;
    }

    public float getFloat(String key, float defaultValue) {
        float value = getFloat(key);
        return value != 0.0f ? value : defaultValue;
    }

    public byte getByte(String key) {
        return 0;
    }

    public byte getByte(String key, byte defaultValue) {
        byte value = getByte(key);
        return value != 0 ? value : defaultValue;
    }

    public short getShort(String key) {
        return 0;
    }

    public short getShort(String key, short defaultValue) {
        short value = getShort(key);
        return value != 0 ? value : defaultValue;
    }

    public char getChar(String key) {
        return '\u0000';
    }

    public char getChar(String key, char defaultValue) {
        char value = getChar(key);
        return value != '\u0000' ? value : defaultValue;
    }

    public Object get(String key) {
        return null;
    }

    public Object get(String key, Object defaultValue) {
        Object value = get(key);
        return value != null ? value : defaultValue;
    }

    public void set(String key, Object value) {

    }

    public void save() {

    }
}
