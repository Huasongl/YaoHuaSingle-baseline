package com.yaohua.commonmodule;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseConfig {
    private static final String TAG = "BaseConfig";
    private static Map<String, MMKV> spMap = new ConcurrentHashMap();

    public BaseConfig() {
    }

//    public static void putString(String configFileName, String key, String value) {
//        try {
//            getEditor(configFileName).putString(key, value).commit();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "putString: " + configFileName);
//        }
//
//    }
//
//    protected static void putStringSet(String configFileName, String key, Set<String> values) {
//        try {
//            getEditor(configFileName).putStringSet(key, values).commit();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "putStringSet: " + configFileName);
//        }
//
//    }
//
//    protected static void putInt(String configFileName, String key, int value) {
//        try {
//            getEditor(configFileName).putInt(key, value).commit();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "putInt: " + configFileName);
//        }
//
//    }
//
//    protected static void putLong(String configFileName, String key, long value) {
//        try {
//            getEditor(configFileName).putLong(key, value).commit();
//        } catch (Exception var5) {
//            var5.printStackTrace();
//            Log.e("BaseConfig", "putLong: " + configFileName);
//        }
//
//    }
//
//    protected static void putFloat(String configFileName, String key, float value) {
//        try {
//            getEditor(configFileName).putFloat(key, value).commit();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "putFloat: " + configFileName);
//        }
//
//    }
//
//    protected static void putBoolean(String configFileName, String key, boolean value) {
//        try {
//            getEditor(configFileName).putBoolean(key, value).commit();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "putBoolean: " + configFileName);
//        }
//
//    }
//
//    protected static void remove(String configFileName, String key) {
//        try {
//            getEditor(configFileName).remove(key).commit();
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Log.e("BaseConfig", "remove: " + configFileName);
//        }
//
//    }
//
//    protected static void clear(String configFileName) {
//        try {
//            getEditor(configFileName).clear().commit();
//        } catch (Exception var2) {
//            var2.printStackTrace();
//            Log.e("BaseConfig", "clear: " + configFileName);
//        }
//
//    }
//
//    protected static Map<String, ?> getAll(String configFileName) {
//        try {
//            return getSp(configFileName).getAll();
//        } catch (Exception var2) {
//            var2.printStackTrace();
//            Log.e("BaseConfig", "getAll: " + configFileName);
//            return new HashMap();
//        }
//    }
//
//    protected static String getString(String configFileName, String key, String defValue) {
//        try {
//            return getSp(configFileName).getString(key, defValue);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "getString: " + configFileName);
//            return defValue;
//        }
//    }
//
//    protected static Set<String> getStringSet(String configFileName, String key, Set<String> defValues) {
//        try {
//            return getSp(configFileName).getStringSet(key, defValues);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "getStringSet: " + configFileName);
//            return defValues;
//        }
//    }
//
//    protected static int getInt(String configFileName, String key, int defValue) {
//        try {
//            return getSp(configFileName).getInt(key, defValue);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "getInt: " + configFileName);
//            return defValue;
//        }
//    }
//
//    protected static long getLong(String configFileName, String key, long defValue) {
//        try {
//            return getSp(configFileName).getLong(key, defValue);
//        } catch (Exception var5) {
//            var5.printStackTrace();
//            Log.e("BaseConfig", "getLong: " + configFileName);
//            return defValue;
//        }
//    }
//
//    protected static float getFloat(String configFileName, String key, float defValue) {
//        try {
//            return getSp(configFileName).getFloat(key, defValue);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "getFloat: " + configFileName);
//            return defValue;
//        }
//    }

//    protected static boolean getBoolean(String configFileName, String key, boolean defValue) {
//        try {
//            return getSp(configFileName).getBoolean(key, defValue);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("BaseConfig", "getBoolean: " + configFileName);
//            return defValue;
//        }
//    }
//
//    protected static boolean contains(String configFileName, String key) {
//        try {
//            return getSp(configFileName).contains(key);
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Log.e("BaseConfig", "contains: " + configFileName);
//            return false;
//        }
//    }

//    private static MMKV getSp(String configFileName) {
//        if (TextUtils.isEmpty(configFileName)) {
//            configFileName = "SETTING";
//        }
//
//        if (spMap.get(configFileName) != null) {
//            return (MMKV)spMap.get(configFileName);
//        } else {
//            spMap.put(configFileName, initMMKV(configFileName));
//            return (MMKV)spMap.get(configFileName);
//        }
//    }

//    private static SharedPreferences.Editor getEditor(String configFileName) {
//        return getSp(configFileName).edit();
//    }

//    private static MMKV initMMKV(String configFileName) {
//        MMKV preferences = MMKV.mmkvWithID(configFileName, 2);
//        SharedPreferences old_man = BaseApplication.Companion.getINSTANCE().getSharedPreferences(configFileName, 0);
//        preferences.importFromSharedPreferences(old_man);
//        old_man.edit().clear().commit();
//        return preferences;
//    }
}
