package com.yaohua.studies.designmethod.ocp;

import android.app.Notification;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification){
        super(rule,notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {

    }
}
