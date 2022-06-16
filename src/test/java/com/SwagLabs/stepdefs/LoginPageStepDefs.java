package com.SwagLabs.stepdefs;

import com.SwagLabs.pages.ContextState;
import com.SwagLabs.pages.HomePage;
import com.SwagLabs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.SwagLabs.utilities.Driver.driver;
import static org.junit.Assert.assertTrue;

public class LoginPageStepDefs extends  ContextState{
    private ContextState contextState;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    public LoginPageStepDefs(ContextState contextState){
        this.contextState = contextState;
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.navigateToLoginPage();
    }
    @When("user enters username {string} and {string} password")
    public void user_enters_username_and_password(String userName, String password) {
        loginPage.enterCredentials(userName, password);
    }
    @Then("user should be able to logged in and navigated to products page")
    public void user_should_be_able_to_logged_in_and_navigated_to_products_page() {
        assertTrue(driver().getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }
}
