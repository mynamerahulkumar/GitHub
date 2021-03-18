package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(css = "#messageText")
    private WebElement messageText;

    @FindBy(className = "#chatMessageUsername")
    private WebElement chatMessageUsername;

    @FindBy(className = "#chatMessageText")
    private WebElement chatMessageText;

    @FindBy(css = "#submit-button")
    private WebElement submitButton;

    public  ChatPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void chat(String message){
        this.messageText.sendKeys(message);
        this.submitButton.click();
    }
    public ChatMessage getChatMessage(){
        ChatMessage result=new ChatMessage();
        result.setMessageText(chatMessageText.getText());
        result.setUsername(chatMessageUsername.getText());
        return  result;
    }

}
