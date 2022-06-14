package com.SwagLabs.pages;

import com.SwagLabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.driver(), this);
    }
    @FindBy(id="user-name")
    public WebElement usernameInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(id="login-button")
    public WebElement loginButton;
    @FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")
    public WebElement errorMessage;


}
