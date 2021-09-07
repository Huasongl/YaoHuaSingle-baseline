package com.yaohua.studies.designmethod.ocp;

public class AlertRule {
    public AlertRule getMatchedRule(String api) {
        return this;
    }

    public long getMaxTps(){
        return 8;
    }

    public long getMaxErrorCount(){
        return 8;
    }
}
