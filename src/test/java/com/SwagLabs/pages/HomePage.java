package com.SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.SwagLabs.utilities.Driver.driver;

public class HomePage { public HomePage(){PageFactory.initElements(driver(),this);}

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    public WebElement products;

    @FindBy(className = "shopping_cart_link")
    public WebElement cart;

    @FindBy(xpath = "//button[@name='continue-shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueCheckout;

    @FindBy(className = "summary_total_label")
    public WebElement totalPrice;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement orderConfirmationMessage;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement openMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;


    public void addToCart(String item){
        driver().findElement(By.xpath("//*[contains(text(), '" +item+"')]//parent::a//parent::div//parent::div//div[2]//button")).click();
    }

    public void clickCart(){
        cart.click();
    }

    ////div[contains(text(),'Sauce Labs Backpack')]//parent::a/following-sibling::div[2]/div
    public String getPrice(String item){
        //return driver().findElement(By.xpath("//div[contains(text(),'"+item+"')]//parent::a//parent::div[@class='inventory_item_label']/following-sibling::div/div\n")).getText();
       // System.out.println(driver().findElement(By.xpath("//div[contains(text(),'"+item+"')]//parent::a/following-sibling::div[2]/div")).getText());
        return driver().findElement(By.xpath("//div[contains(text(),'"+item+"')]//parent::a/following-sibling::div[2]/div")).getText();
    }

    public void clickContinueShoppingButton(){
        continueShopping.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void populateInformation(String firstName, String lastName, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    public void continueCheckoutClick(){
        continueCheckout.click();
    }

    public double calculateTotalPrice(){
        List<WebElement> elements = driver().findElements(By.className("inventory_item_price"));
        double totalPrice = 0;
        for(WebElement element : elements){
            totalPrice += Double.parseDouble(element.getText().substring(1));
        }
        return totalPrice + 3.20;
    }

    public double readTotalLabel(){
        return Double.parseDouble(totalPrice.getText().substring(8));
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void logout(){
        openMenu.click();
        logout.click();
    }
}
