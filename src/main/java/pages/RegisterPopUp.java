package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;

import java.time.Duration;

public class RegisterPopUp {

    WebDriver driver;

    public RegisterPopUp(WebDriver driver){
        this.driver = driver;
        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGELOAD_WAIT_DURATION), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(css = "[onclick='register()']")
    private WebElement signUpButton;

    /**
     * Fill Username field
     * @param username is username inputted
     */
    public void fillUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    /**
     * Fill password field
     * @param password is to input the char for password
     */
    public void fillPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    /**
     * Click sign up button in bottom right
     */
    public void clickSignUpButton(){
        signUpButton.click();
    }

}
