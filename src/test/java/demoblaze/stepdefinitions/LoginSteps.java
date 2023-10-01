package demoblaze.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPopUp;
import pages.RegisterPopUp;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.ThreadManager;

import java.time.Duration;

public class LoginSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final LoginPopUp login = new LoginPopUp(driver);
    private final HeaderPage header = new HeaderPage(driver);


    @Step
    @Given("user login to demoblaze as {string}")
    public void user_login_to_demoblaze_as(String type) throws InterruptedException {
        String email = "";
        String password = "";

        if (type.equalsIgnoreCase("normal user")) {
            email = Constants.USERNAME;
            password = Constants.PASSWORD;;
        }
        login.fillUsername(email);
        login.fillPassword(password);
        login.clickLoginButton();
        Thread.sleep(2000);
    }

    @Given("user click Login in header")
    public void user_click_login_in_header() {
        header.clickLoginHeader();
    }

}