package com.example.demo.controller;

import com.example.demo.ChatForm;
import com.example.demo.ChatMessage;
import com.example.demo.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
@Controller
public class ChatController {
    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", messageListService.getChatMessage());
        return "chat";
    }

    @PostMapping()
    public String highFive(ChatForm chatForm, Model model) {
        messageListService.addChatMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", messageListService.getChatMessage());
        return "chat";
    }
    @ModelAttribute("allMessageTypes")
    public String[] getAllMessageType(){
        return new String[]{"Say","Shout","Whisper"};
    }
}
