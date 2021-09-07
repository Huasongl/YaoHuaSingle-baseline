//package com.yaohua.studies.utils;
//
//import android.content.Context;
//import android.util.Log;
//
//public class Config{
//    public Config(){
//
//    }
//
//    public static class ServerConfig{
//        public static final boolean DISPLAY_DYN_SPLASH = false;
//
//        public static boolean getShowedDynSplashFlag(Context c) {
//            return getBoolean(SETTING, DYNSPLASH, false);
//        }
//    }
//
//    protected static boolean getBoolean(String configFileName, String key, boolean defValue) {
//        try {
//            return getSp(configFileName).getBoolean(key, defValue);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(TAG, "getBoolean: "+configFileName);
//        }
//        return defValue;
//    }
//}
