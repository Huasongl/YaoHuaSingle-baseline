package com.yaohua.studies.designmethod.lsp;

public class Transporter {
    private HttpClient httpClient;

    public Transporter(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public Response sendRequest(Request request){
        return new Response();
    }
}
