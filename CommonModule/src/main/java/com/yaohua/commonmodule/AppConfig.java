package com.yaohua.commonmodule;

import android.os.Build;
import android.os.FileUtils;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AppConfig extends BaseConfig {
    public static String C_PLATFORM = null;
    public static String SUB_PLATFORM = null;
    public static String APPID = null;
    public static String AREAID = null;
    public static String WX_SHARE_APPID = null;
    public static String WX_APP_SECRET = null;
    public static String URL_VERSION = null;
    public static String URL_VERSION2 = null;
    public static String CUR_VERSION = null;
    public static String VERSION_NAME_NOW = null;
    public static String SERVER_URL_VERSION = null;
    public static String SKIN_PERMISSION = null;
//    public static String switchEnvFile = SysDeviceUtils.getSDcardPath() + "/switch_env.txt";

    public AppConfig() {
    }

//    public static void setEnv(int env) {
//        File file = new File(switchEnvFile);
//        if (!file.exists()) {
//            try {
//                boolean isSucess = file.createNewFile();
//                if (!isSucess) {
//                    return;
//                }
//            } catch (IOException var3) {
//                var3.printStackTrace();
//            }
//        }

//        FileUtils.writeFile(file, (env + "").getBytes());
//    }

//    public static int getEnv() {
//        try {
//            String content = FileUtils.readString(switchEnvFile);
//            return TextUtils.isEmpty(content) ? -1 : Integer.parseInt(content);
//        } catch (Exception var2) {
//            File file = new File(switchEnvFile);
//            file.deleteOnExit();
//            var2.printStackTrace();
//            return -1;
//        }
//    }

//    static {
//        if (Build.VERSION.SDK_INT >= 29) {
//            switchEnvFile = ((BaseApplication) Objects.requireNonNull(BaseApplication.Companion.getINSTANCE())).getExternalFilesDir((String)null) + "/switch_env.txt";
//        }
//
//    }
}
