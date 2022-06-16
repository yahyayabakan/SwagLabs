package com.SwagLabs.stepdefs;

import com.SwagLabs.pages.ContextState;
import com.SwagLabs.pages.HomePage;
import com.SwagLabs.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.SwagLabs.utilities.Driver.driver;
import static org.junit.Assert.assertEquals;
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
    @Then("{string} product  should be listed with {string} correct price")
    public void product_should_be_listed_with_correct_price(String item, String price) {
        assertTrue(homePage.getPrice(item).equals(price));
    }
    @Then("user clicks to continue shopping button and navigates back to the products page")
    public void user_clicks_to_continue_shopping_button_and_navigates_back_to_the_products_page() {
        homePage.clickContinueShoppingButton();
    }
    @Then("user clicks checkout button")
    public void user_clicks_checkout_button() {
        homePage.clickCheckoutButton();
    }

    @Then("user clicks continue button")
    public void user_clicks_continue_button() {
        homePage.continueCheckoutClick();
    }
    @Then("total price of items in cart should be correct")
    public void total_price_of_items_in_cart_should_be_correct() {
        assertTrue(homePage.calculateTotalPrice() == homePage.readTotalLabel() );
    }
    @Then("user clicks finish button and receives {string} notification")
    public void user_clicks_finish_button_and_receives_notification(String string) {
        homePage.clickFinishButton();
        assertEquals(homePage.orderConfirmationMessage.getText(),"THANK YOU FOR YOUR ORDER");
    }
    @Then("user clicks open menu button then clicks LOGOUT button")
    public void user_clicks_open_menu_button_then_clicks_logout_button() {
        homePage.logout();
    }
    @Then("user should be able to logout and directed to the login page")
    public void user_should_be_able_to_logout_and_directed_to_the_login_page() {
        assertTrue(driver().getCurrentUrl().equals("https://www.saucedemo.com/"));
    }
    @Then("user populates First Name {string}, Last Name {string} and ZipPostal Code {string}")
    public void user_populates_first_name_last_name_and_zip_postal_code(String firstName, String lastName, String postalCode) {
        homePage.populateInformation(firstName,lastName,postalCode);
    }

    @Then("user should be able to see {string}")
    public void user_should_be_able_to_see(String string) {
        assertTrue(loginPage.errorMessage.getText().equals("Epic sadface: Sorry, this user has been locked out."));
    }


}
