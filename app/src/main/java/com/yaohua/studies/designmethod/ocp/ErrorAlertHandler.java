package com.yaohua.studies.designmethod.ocp;

import android.app.Notification;

public class ErrorAlertHandler extends AlertHandler{

    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule,notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {

    }
}
