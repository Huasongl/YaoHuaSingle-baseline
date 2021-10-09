package com.yaohua.commonmodule;

public class FlavorConfig {
    public static DomainInitializer mDomain;

    public static FlavorConfig getInstance() {
        return FlavorConfig.FlavorConfigHolder.instance;
    }

    private FlavorConfig() {
    }

    public FlavorConfig configPlatoform(String platform) {
        AppConfig.C_PLATFORM = platform;
        return this;
    }

    public FlavorConfig configSubPlatform(String subPlatform) {
        AppConfig.SUB_PLATFORM = subPlatform;
        return this;
    }

    public FlavorConfig configURLVersion(String version) {
        AppConfig.URL_VERSION = version;
        return this;
    }

    public FlavorConfig configAPPID(String appId) {
        AppConfig.APPID = appId;
        return this;
    }

    public FlavorConfig configAREAID(String areaId) {
        AppConfig.AREAID = areaId;
        return this;
    }

    public FlavorConfig configWXShareId(String shareId) {
        AppConfig.WX_SHARE_APPID = shareId;
        return this;
    }

    public FlavorConfig configURLVersion2(String version) {
        AppConfig.URL_VERSION2 = version;
        return this;
    }

    public FlavorConfig configCURVersion(String version) {
        AppConfig.CUR_VERSION = version;
        return this;
    }

    public FlavorConfig configVersionName(String versionName) {
        AppConfig.VERSION_NAME_NOW = versionName;
        return this;
    }

    public FlavorConfig configServerURLVersion(String version) {
        AppConfig.SERVER_URL_VERSION = version;
        return this;
    }

    public FlavorConfig configSkinPermission(String permission) {
        AppConfig.SKIN_PERMISSION = permission;
        return this;
    }

    public void configDoMain(DomainInitializer domain) {
        mDomain = domain;
    }

    private static class FlavorConfigHolder {
        private static FlavorConfig instance = new FlavorConfig();

        private FlavorConfigHolder() {
        }
    }
}
