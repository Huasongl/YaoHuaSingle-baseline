package com.yaohua.routemoudle;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

public class ARouteService {

    public static void goSearchPage(Activity activity, String keywords) {
        IAppRouterService appRouterService = (IAppRouterService) ARouter.getInstance()
                .build(RoutePath.APP_MODULE_SERVICE).navigation(activity);
        if (appRouterService != null) {
            appRouterService.goSearchPage(activity, keywords);
        }
    }
}
