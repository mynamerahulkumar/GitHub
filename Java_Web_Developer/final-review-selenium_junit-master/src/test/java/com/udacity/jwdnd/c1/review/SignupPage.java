package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(css = "#inputFirstName")
    private WebElement inputFirstName;

    @FindBy(css = "#inputLastName")
    private WebElement inputLastName;

    @FindBy(css = "#inputUsername")
    private WebElement inputUsername;

    @FindBy(css = "#inputPassword")
    private WebElement inputPassword;

    @FindBy(css = "#submit-button")
    private WebElement submitButton;

    public  SignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void signup(String firstName,String lastName,String username,String password){
        this.inputFirstName.sendKeys(firstName);
        this.inputLastName.sendKeys(lastName);
        this.inputPassword.sendKeys(password);
        this.inputUsername.sendKeys(username);
        this.submitButton.click();
    }


}
