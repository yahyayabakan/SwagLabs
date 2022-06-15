package com.SwagLabs.pages;

import com.SwagLabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.SwagLabs.utilities.Driver.driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(driver(), this);
    }
    @FindBy(id="user-name")
    public WebElement usernameInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(id="login-button")
    public WebElement loginButton;
    @FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")
    public WebElement errorMessage;

    public  void navigateToLoginPage(){
        driver().get("https://www.saucedemo.com/");
    }

    public void enterCredentials(String userName, String password){
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.sendKeys();
    }

}
