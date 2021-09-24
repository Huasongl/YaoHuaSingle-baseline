package com.yaohua.studies.designmethod.ioc;

import androidx.core.widget.NestedScrollView;

public class Notification {
    private MessageSender messageSender;

    public Notification(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message){
        messageSender.send(cellphone,message);
    }
}
