package com.yaohua.studies;

import android.os.Build;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yaohua.commonmodule.FlavorConfig;
import com.yaohua.core.BaseApplication;


public class AbsApplication extends BaseApplication {

    public AbsApplication() {
        instance = this;
    }

    public static synchronized AbsApplication getInstance() {
        return (AbsApplication) instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        configAppDebug();
        configFlavor();
    }

    public  void configFlavor(){
        String deviceFlag = Build.MANUFACTURER;
        String packageName = this.getApplicationInfo().packageName;
        String code = "13.6.0.300";
        String version;
        String subPlatform = "heytap";
        if (deviceFlag.equalsIgnoreCase("oppo")) {
            version = "heytapbook_" + code + "_android_newop";
        } else if (deviceFlag.equalsIgnoreCase("oneplus")) {
            version = "heytapbook_" + code + "_android_oneplus";
        } else if (deviceFlag.equalsIgnoreCase("realme")) {
            version = "heytapbook_" + code + "_android_realme";
        } else {
            version = "heytapbook_" + code + "_android_newop";
        }
        if ("com.oppo.book".equals(packageName)) {
            version = "oppobook_" + code + "_android_oppo";
            subPlatform = "oppo";
        }
        FlavorConfig.getInstance().configPlatoform("oppo")
                .configSubPlatform(subPlatform)
                .configURLVersion("6_0")
                .configAPPID("1450004236")
                .configAREAID("1")
                .configWXShareId("wx7532dbc77a0c12c4")
                .configURLVersion2("6")
                .configCURVersion(version)
                .configVersionName(code)
                .configServerURLVersion("1_0_0")
                .configSkinPermission("")
                .configDoMain(new DomainInitializerImpl());
    }

    private void configAppDebug() {
        
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            // 打印日志
            //ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }

        //路由初始化
        ARouter.init(this);
    }
}
