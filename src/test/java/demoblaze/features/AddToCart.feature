@regression @addToCart
Feature: Add and delete items in cart

  Background:
    Given user is at 'demoblaze'
    And user click Login in header
    And user login to demoblaze as 'normal user'

  @addOneToCart
  Scenario: Successfully add one product to Cart
    When user click product "Nexus 6" in home
    And user click Add to cart button
    Then user see pop up with message "Product added."
    And user can click OK to close the pop up
    When user go to Cart page
    And user can see product title is "Nexus 6" in cart page
    And user can see product price for "Nexus 6" is "650" in cart page
    And user delete product "Nexus 6" in cart page

  @addSomeToCart
  Scenario: Successfully add several product to Cart and delete it
    When user add to cart several products below from Home
      | Samsung galaxy s6 |
      | Sony xperia z5    |
      | Sony vaio i5      |
    And user go to Cart page
    Then user can see only "3" products in the cart
    And user can see product pics is correct in cart page :
      | imgs/galaxy_s6.jpg |
      | imgs/sony_vaio_5.jpg   |
      | imgs/xperia_z5.jpg |
    And user can see these product titles in cart page :
      | Samsung galaxy s6 |
      | Sony xperia z5    |
      | Sony vaio i5      |
    And user can see product prices is correct in cart page :
      | Samsung galaxy s6 | 360 |
      | Sony xperia z5    | 320 |
      | Sony vaio i5      | 790 |




  @deleteCart
  Scenario: Successfully delete all products in Cart
    When user go to Cart page
    And user delete all products in cart page :
      | Samsung galaxy s6 |
      | Sony xperia z5    |
      | Sony vaio i5      |
    Then product list should be empty in cart page