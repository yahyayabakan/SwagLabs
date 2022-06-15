package com.SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.SwagLabs.utilities.Driver.driver;

public class HomePage {
    public HomePage(){ PageFactory.initElements(driver(), this);}

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    public WebElement products;

    @FindBy(className = "shopping_cart_link")
    public WebElement cart;

    public void addToCart(String item){
        driver().findElement(By.xpath("//*[contains(text(), '" +item+"')]//parent::a//parent::div//parent::div//div[2]//button")).click();
    }

    public void clickCart(){
        cart.click();
    }

    public String getPrice(String item){
        return driver().findElement(By.xpath("//div[contains(text(),'"+item+"')]//parent::a//parent::div[@class='inventory_item_label']/following-sibling::div/div\n")).getText();
    }

}
