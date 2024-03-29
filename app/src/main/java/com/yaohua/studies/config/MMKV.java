package com.yaohua.studies.config;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    private static EnumMap<MMKVRecoverStrategic,Integer> recoverIndex = new EnumMap<MMKVRecoverStrategic, Integer>(MMKVRecoverStrategic.class);
    private static String rootDir;

//    public static String initialize(Context context) {
//        String root = context.getFilesDir().getAbsolutePath() + "/mmkv";
//        return initialize(root, (MMKV.LibLoader)null);
//    }
//
//    public static String initialize(String rootDir) {
//        return initialize(rootDir, (MMKV.LibLoader)null);
//    }

    public interface LibLoader {
        void loadLibrary(String var1);
    }

    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        return null;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return null;
    }

    @Override
    public int getInt(String key, int defValue) {
        return 0;
    }

    @Override
    public long getLong(String key, long defValue) {
        return 0;
    }

    @Override
    public float getFloat(String key, float defValue) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return false;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    @Override
    public Editor putString(String key, @Nullable String value) {
        return null;
    }

    @Override
    public Editor putStringSet(String key, @Nullable Set<String> values) {
        return null;
    }

    @Override
    public Editor putInt(String key, int value) {
        return null;
    }

    @Override
    public Editor putLong(String key, long value) {
        return null;
    }

    @Override
    public Editor putFloat(String key, float value) {
        return null;
    }

    @Override
    public Editor putBoolean(String key, boolean value) {
        return null;
    }

    @Override
    public Editor remove(String key) {
        return null;
    }

    @Override
    public Editor clear() {
        return null;
    }

    @Override
    public boolean commit() {
        return false;
    }

    @Override
    public void apply() {

    }
}
