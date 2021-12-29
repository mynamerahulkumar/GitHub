package com.drive.GoogleDriveProject.Messages.Controller1;

import com.drive.GoogleDriveProject.Messages.Services.MessageListService;
import com.drive.GoogleDriveProject.Messages.pojo.MessageForm;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;


@Controller
public class HomeController {
    private MessageListService messageListService;
    public HomeController(MessageListService messageListService){
        this.messageListService=messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }
    public String addHomePage(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings",messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }




}
