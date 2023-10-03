@regression @checkout
Feature: Checkout and purchase product

  Background:
    Given user is at 'demoblaze'
    And user click Login in header
    And user login to demoblaze as 'normal user'

  @orderSomeProducts
  Scenario: Successfully purchase several products
    When user add to cart several products below from Home
      | Samsung galaxy s6 |
      | Sony xperia z5    |
      | Sony vaio i5      |
    And user go to Cart page
    And user click Place Order
    And user fill name with "Eko" in order form
    And user fill country with "Indonesia" in order form
    And user fill city with "Jogja" in order form
    And user fill credit card with "1111111111" in order form
    And user fill month with "9" in order form
    And user fill year with "2023" in order form
    And user click Purchase
    Then user see thank you message with text "Thank you for your purchase!"
    And user see amount is "1470 USD" in thank you pop up
    And user see card number is "1111111111" in thank you pop up
    And user see Name is "Eko" in thank you pop up
    And user see date is current date with month "9" and year "2023" in thank you pop up
    And it will redirect to home after click Ok in thank you pop up

  @orderSomeProducts
  Scenario: Failed purchase product when Name and CC is empty
    When user add to cart several products below from Home
      | Nokia lumia 1520	 |
      | Samsung galaxy s7    |
    And user go to Cart page
    And user click Place Order
    # Without filling anything in purchase form
    And user click Purchase
    Then user see pop up with message "Please fill out Name and Creditcard."
    And user can click OK to close the pop up
    And user can click close purchase form pop up
    And user delete all products in cart page :
      | Nokia lumia 1520	 |
      | Samsung galaxy s7    |
    And product list should be empty in cart page
