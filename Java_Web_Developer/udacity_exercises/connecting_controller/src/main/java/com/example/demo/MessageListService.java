package com.example.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageListService {
    List<String> messages = new ArrayList<>();
    public List<String> getMessages() {
        return messages;
    }
    public void addMessage(String message) {
        messages.add(message);
    }
    List<ChatMessage> chatMessages=new LinkedList<>();

    public List<ChatMessage> getChatMessage(){
        return this.chatMessages;
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating a post construct bean");
        this.chatMessages=new ArrayList<>();
    }
    public void addChatMessage(ChatForm chatForm){
        ChatMessage newChatMessage=new ChatMessage();
        newChatMessage.setUserName(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say":
                newChatMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newChatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newChatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(newChatMessage);
    }
}
