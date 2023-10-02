package demoblaze.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ThreadManager;

public class CheckoutSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private CartPage cart = new CartPage(driver);
    private PlaceOrderPopUp checkout = new PlaceOrderPopUp(driver);

    @Step
    @When("user click Place Order")
    public void user_click_place_order() {
        cart.clickPlaceOrder();
    }

    @When("user fill name with {string} in order form")
    public void user_fill_name_with_in_order_form(String name) {
        checkout.fillName(name);
    }

    @When("user fill country with {string} in order form")
    public void user_fill_country_with_in_order_form(String country) {
        checkout.fillCountry(country);
    }

    @When("user fill city with {string} in order form")
    public void user_fill_city_with_in_order_form(String city) {
        checkout.fillCity(city);
    }

    @When("user fill credit card with {string} in order form")
    public void user_fill_credit_card_with_in_order_form(String card) {
        checkout.fillCreditCard(card);
    }

    @When("user fill month with {string} in order form")
    public void user_fill_month_with_in_order_form(String month) {
        checkout.fillMonth(month);
    }

    @When("user fill year with {string} in order form")
    public void user_fill_year_with_in_order_form(String year) {
        checkout.fillYear(year);
    }

    @When("user click Purchase")
    public void user_click_purchase() {
        checkout.clickPurchase();
    }

    @Then("user see thank you message with text {string}")
    public void user_see_thank_you_message_with_text(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user see amount is {string} in thank you pop up")
    public void user_see_amount_is_in_thank_you_pop_up(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user see card number is {string} in thank you pop up")
    public void user_see_card_number_is_in_thank_you_pop_up(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user see Name is {string} in thank you pop up")
    public void user_see_name_is_in_thank_you_pop_up(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user see date is current date with month {string} and year {string} in thank you pop up")
    public void user_see_date_is_current_date_with_month_and_year_in_thank_you_pop_up(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("it will redirect to home after click Ok in thank you pop up")
    public void it_will_redirect_to_home_after_click_ok_in_thank_you_pop_up() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}