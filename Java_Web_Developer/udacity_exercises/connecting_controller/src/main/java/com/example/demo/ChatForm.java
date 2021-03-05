package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChatForm {
   String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    String messageText;
   String messageType;
}
