package com.yaohua.routemoudle;

import android.app.Activity;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 此类存在意义：未提供对外service,并且未从app中拆分出来
 */
public interface IAppRouterService extends IProvider {

    void goSearchPage(Activity lBindActivity, String keywords);

}
