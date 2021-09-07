package com.yaohua.studies.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import com.yaohua.studies.utils.Config;

public abstract class AbsSplashActivity extends AppCompatActivity implements IEventListener{

    public final static String TAG = "AbsSplashActivity";
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext =this;
        super.onCreate(savedInstanceState);
        initSplashUI();
        startAppCheck();
    }

    private void initSplashUI() {

    }

//    protected boolean isNeedDynSplash() {
//        // 自己创建闪屏
//        boolean needDynSplash = false;
//        if (Config.ServerConfig.DISPLAY_DYN_SPLASH) {//需要显示动态闪屏
//            if (!Config.ServerConfig.getShowedDynSplashFlag(mContext)) {//首次安装
//                needDynSplash = true;
//            } else if (CommonConfig.getVersionCode() != Version.getVersionCode()) {//覆盖安装
//                needDynSplash = true;
//            } else if (!CommonConfig.getVersion().equals(Version.cur_version)) {//灰度包覆盖前一版本
//                needDynSplash = true;
//            }
//        }
//        return needDynSplash;
//    }

    protected abstract void startAppCheck();

    @Override
    public void doFunction(Bundle b) {

    }

    @Override
    public Activity getFromActivity() {
        return null;
    }
}
