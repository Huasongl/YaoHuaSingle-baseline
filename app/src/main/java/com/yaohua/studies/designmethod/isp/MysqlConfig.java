package com.yaohua.studies.designmethod.isp;

import java.util.Map;

public class MysqlConfig implements SimpleHttpServer.Viewer{
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;

    public MysqlConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public String getAddress(){
        return this.address;
    }

    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
