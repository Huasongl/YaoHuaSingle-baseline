package com.yaohua.studies.designmethod.ocp;

public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
    private long timeoutCount;

    public ApiStatInfo(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {
        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.durationOfSeconds = durationOfSeconds;
        this.timeoutCount = timeoutCount;
    }
}
