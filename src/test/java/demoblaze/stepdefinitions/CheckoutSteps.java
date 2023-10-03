package demoblaze.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.PlaceOrderPopUp;
import pages.ThankYouPopUp;
import utilities.Constants;
import utilities.ThreadManager;

import java.util.Calendar;

public class CheckoutSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private CartPage cart = new CartPage(driver);
    private PlaceOrderPopUp checkout = new PlaceOrderPopUp(driver);
    private ThankYouPopUp thanks = new ThankYouPopUp(driver);

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
    public void user_click_purchase() throws InterruptedException {
        checkout.clickPurchase();
    }

    @Then("user see thank you message with text {string}")
    public void user_see_thank_you_message_with_text(String message) {
        Assert.assertEquals(thanks.getThankYouMsg(), message, "Thank you message is wrong");
    }

    @Then("user see amount is {string} in thank you pop up")
    public void user_see_amount_is_in_thank_you_pop_up(String amount) {
        Assert.assertEquals(thanks.getPriceAmount(), amount, "Amount price is wrong");
    }

    @Then("user see card number is {string} in thank you pop up")
    public void user_see_card_number_is_in_thank_you_pop_up(String card) {
        Assert.assertEquals(thanks.getCardNumber(), card, "Card number is wrong");
    }

    @Then("user see Name is {string} in thank you pop up")
    public void user_see_name_is_in_thank_you_pop_up(String name) {
        Assert.assertEquals(thanks.getName(), name, "Name is wrong");
    }

    @Then("user see date is current date with month {string} and year {string} in thank you pop up")
    public void user_see_date_is_current_date_with_month_and_year_in_thank_you_pop_up(String month, String year) {
        // get current day date
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        String dayOfMonthStr = String.valueOf(dayOfMonth);
        // split to get day, month, and year number
        String[] number = thanks.getDate().split("/");
        Assert.assertEquals(number[0], dayOfMonthStr, "Day is wrong");
        Assert.assertEquals(number[1], month, "Month date is wrong");
        Assert.assertEquals(number[2], year, "Year date is wrong");
    }

    @Then("it will redirect to home after click Ok in thank you pop up")
    public void it_will_redirect_to_home_after_click_ok_in_thank_you_pop_up() throws InterruptedException {
        thanks.clickOk();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.DEMOBLAZE, "Failed redirect to Home");
    }

    @Then("user can click close purchase form pop up")
    public void user_can_click_close_purchase_form_pop_up() throws InterruptedException {
        checkout.clickClose();
    }
}