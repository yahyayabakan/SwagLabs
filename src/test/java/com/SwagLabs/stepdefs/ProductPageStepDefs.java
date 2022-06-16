package com.SwagLabs.stepdefs;

import com.SwagLabs.pages.ContextState;
import com.SwagLabs.pages.HomePage;
import com.SwagLabs.pages.LoginPage;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ProductPageStepDefs extends ContextState{
    private ContextState contextState;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    public ProductPageStepDefs(ContextState contextState){
        this.contextState = contextState;
    }

    @Then("user adds {string} product to cart")
    public void user_adds_product_to_cart(String item) {
        homePage.addToCart(item);
    }
    @Then("user clicks cart button")
    public void user_clicks_cart_button() {
        homePage.clickCart();
    }
    @Then("{string} product  should be listed with correct price")
    public void product_should_be_listed_with_correct_price(String item) {
        System.out.println(homePage.getPrice(item));
    }
    @Then("user clicks to continue shopping button and navigates back to the products page")
    public void user_clicks_to_continue_shopping_button_and_navigates_back_to_the_products_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks checkout button")
    public void user_clicks_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks continue button")
    public void user_clicks_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("total price of items in cart should be correct")
    public void total_price_of_items_in_cart_should_be_correct() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks finish button and receives {string} notification")
    public void user_clicks_finish_button_and_receives_notification(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks open menu button then clicks LOGOUT button")
    public void user_clicks_open_menu_button_then_clicks_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should be able to logout and directed to the login page")
    public void user_should_be_able_to_logout_and_directed_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user populates First Name {string}, Last Name {string} and ZipPostal Code {string}")
    public void user_populates_first_name_last_name_and_zip_postal_code(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should be able to see {string}")
    public void user_should_be_able_to_see(String string) {
        assertTrue(loginPage.errorMessage.getText().equals("Epic sadface: Sorry, this user has been locked out."));
    }


}
