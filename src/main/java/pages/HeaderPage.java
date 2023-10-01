package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;

public class HeaderPage {

    WebDriver driver;

    public HeaderPage(WebDriver driver){
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

    @FindBy(id = "signin2")
    private WebElement signUpButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    /**
     * Click sign up button in top right
     */
    public void clickSignUpHeader(){
        signUpButton.click();
    }

    /**
     * Click login button in header
     */
    public void clickLoginHeader(){
        loginButton.click();
    }
}
