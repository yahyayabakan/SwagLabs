Feature: Add item to cart
  Background:
    Given user is on the login page

  Scenario:  Buy some items and check out
    When user enters username "standard_user" and "secret_sauce" password
    Then user should be able to logged in and navigated to products page
    And user adds "Sauce Labs Backpack" product to cart
    And user clicks cart button
    Then "Sauce Labs Backpack" product  should be listed with correct price
    And user clicks to continue shopping button and navigates back to the products page
    And user adds "Sauce Labs Bike Light" product to cart
    And user clicks cart button
    And user clicks checkout button
    And user populates First Name "John", Last Name "Lock" and ZipPostal Code "NE83PU"
    And user clicks continue button
    Then total price of items in cart should be correct
    Then user clicks finish button and receives "THANK YOU FOR YOUR ORDER" notification
    And user clicks open menu button then clicks LOGOUT button
    Then user should be able to logout and directed to the login page

  Scenario:
    When user enters username "locked_out_user" and "secret_sauce" password
    Then user should be able to see "Epic sadface: Sorry, this user has been locked out."



