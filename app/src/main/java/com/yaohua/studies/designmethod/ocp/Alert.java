package com.yaohua.studies.designmethod.ocp;

import android.app.Notification;
import android.app.NotificationManager;

import java.util.ArrayList;
import java.util.List;

//public class Alert {
//    private AlertRule rule;
//    private Notification notification;
//
//    public Alert(AlertRule rule, Notification notification){
//        this.rule = rule;
//        this.notification = notification;
//    }
//
//    public void check(String api, long requestCount, long errorCount, long durationOfSeconds){
//        long tps = requestCount/durationOfSeconds;
//        if(tps > rule.getMatchedRule(api).getMaxTps()){
//            notification.notify();
//        }
//        if(errorCount>rule.getMatchedRule(api).getMaxErrorCount()){
//            notification.notify();
//        }
//    }
//}

public class Alert{
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler){
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo){
        for(AlertHandler handler : alertHandlers){
            handler.check(apiStatInfo);
        }
    }
}

