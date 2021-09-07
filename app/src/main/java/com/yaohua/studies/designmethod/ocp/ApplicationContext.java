package com.yaohua.studies.designmethod.ocp;

import android.app.Notification;

public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans(){
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule,notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule,notification));
        alert.addAlertHandler(new TimeoutHandler(alertRule,notification));
    }

    public Alert getAlert(){
        return alert;
    }

    private static final ApplicationContext instance = new ApplicationContext();
    private ApplicationContext(){
        initializeBeans();
    }
    public static ApplicationContext getInstance(){
        return instance;
    }
}
