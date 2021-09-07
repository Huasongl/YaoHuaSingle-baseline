package com.yaohua.studies.designmethod.ocp;

import android.app.Notification;

public class TimeoutHandler extends AlertHandler {

    public TimeoutHandler(AlertRule alertRule, Notification notification) {
        super(alertRule,notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {

    }
}
