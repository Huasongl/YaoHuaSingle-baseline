package com.yaohua.core;

public class ReaderNetTask extends ReaderShortyTask {
    private static final long serialVersionUID = 1L;
    public static final String TASKNAME = "NetTask";
    protected String mUrl = "";

    public ReaderNetTask() {
    }

    public String getTaskName() {
        return "NetTask";
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof ReaderNetTask)) {
            return false;
        } else if (this.mUrl != null && !"".equals(this.mUrl)) {
            return this.mUrl.equalsIgnoreCase(((ReaderNetTask)o).getUrl());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }
}
