package com.yaohua.studies.designmethod.lsp;

public class Demo {
    public void demoFunction(Transporter transporter){
        Request request = new Request();
        Response response = transporter.sendRequest(request);
    }
}
