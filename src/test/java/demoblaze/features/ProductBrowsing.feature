@regression @productBrowsing
Feature: Product Browsing

  Background:
    Given user is at 'demoblaze'
    And user click Login in header
    And user login to demoblaze as 'normal user'

@seeAllCategories
  Scenario: User can see all categories laptops and phones in homepage after login
    When user check product list
    Then user see product list contains "Nexus 6"
    And user see product list contains "Sony vaio i5"
    And user see product list contains "HTC One M9"

  @productDetails
  Scenario: Product details has correct title, price, and description
    When user click product "Nexus 6" in home
    Then user see the title in product detail page is "Nexus 6"
    And user see the price in product detail page is "$650 *includes tax"
    And user see the description in product detail page is "The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805 processor and it comes with 3GB of RAM."