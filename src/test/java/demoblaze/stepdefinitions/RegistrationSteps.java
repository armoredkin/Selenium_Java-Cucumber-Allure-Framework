package demoblaze.stepdefinitions;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderPage;
import pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.RegisterPopUp;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.ThreadManager;

import java.time.Duration;

public class RegistrationSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private HomePage homepage = new HomePage(driver);
    private HeaderPage header = new HeaderPage(driver);
    private RegisterPopUp register = new RegisterPopUp(driver);

    @Step
    @Given("user is at {string}")
    public void user_is_at(String url) {
        if (url.equalsIgnoreCase("demoblaze")) {
            url = Constants.DEMOBLAZE;
        }
        homepage.openPage(url);
        //hooks.takeScreenshot();
    }

    @When("user open Sign up form pop up")
    public void user_open_sign_up_form_pop_up() {
        header.clickSignUpHeader();
    }

    @When("user fill Username with random valid character")
    public void user_fill_username_with_random_valid_character() {
        String username = JavaHelpers.generateAlphanumeric(5);
        register.fillUsername(username);
    }

    @When("user fill Password with random valid character")
    public void user_fill_password_with_random_valid_character() {
        String password = JavaHelpers.generateAlphanumeric(5);
        register.fillPassword(password);
    }

    @When("user click Sign up in registration pop up")
    public void user_click_sign_up_in_registration_pop_up() {
        register.clickSignUpButton();
    }

    @Then("user see pop up with message {string}")
    public void user_see_pop_up_with_message(String popUpMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMsg, popUpMsg, "Sign Up unsuccessful because: " + alertMsg);
    }

    @Then("user can click OK to close the pop up")
    public void user_can_click_ok_to_close_the_pop_up() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
        Assert.assertNull(alert);
    }

    @When("user fill Username with {string}")
    public void user_fill_username_with(String userName) {
        register.fillUsername(userName);
    }
    @And("user fill Password with {string}")
    public void user_fill_password_with(String password) {
        register.fillPassword(password);
    }
}