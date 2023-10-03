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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThankYouPopUp {

    WebDriver driver;

    public ThankYouPopUp(WebDriver driver){
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

    @FindBy(css = ".sweet-alert > h2")
    private WebElement thankMessage;

    @FindBy(css = ".lead")
    private WebElement purchasedInfoText;

    @FindBy(css = ".confirm")
    private WebElement okButton;

    /**
     * Get thank you message
     * @return String thank you message
     */
    public String getThankYouMsg(){
        return thankMessage.getText();
    }

    /**
     * Get purchased info text
     * @return Array of Strings purchased info include Id, Amount, Card Number, Name, and Date
     */
    public String[] getPurchasedInfo(){
        return purchasedInfoText.getText().split("\r?\n|\r");
    }

    /**
     * Get amount price from splitting purchased info
     * @return String amount price with currency
     */
    public String getPriceAmount(){
        return getPurchasedInfo()[1].substring(8);
    }

    /**
     * Get card number from splitting purchased info
     * @return String card number
     */
    public String getCardNumber(){
        return getPurchasedInfo()[2].substring(13);
    }

    /**
     * Get name from splitting purchased info
     * @return String name
     */
    public String getName(){
        return getPurchasedInfo()[3].substring(6);
    }

    /**
     * Get date from splitting purchased info
     * @return String date
     */
    public String getDate(){
        return getPurchasedInfo()[4].substring(6);
    }

    /**
     * Click ok button
     */
    public void clickOk() throws InterruptedException {
        okButton.click();
        Thread.sleep(2000);
    }
}
