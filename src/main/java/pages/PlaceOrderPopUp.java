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

public class PlaceOrderPopUp {

    WebDriver driver;

    public PlaceOrderPopUp(WebDriver driver) {
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

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(css = "[onclick='purchaseOrder()']")
    private WebElement purchaseButton;

    /**
     * Fill name field
     * @param name is text inputted as name
     */
    public void fillName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
    }

    /**
     * Fill country field
     * @param country is text inputted as country
     */
    public void fillCountry(String country) {
        countryField.sendKeys(country);
    }

    /**
     * Fill city field
     * @param city is text inputted as city
     */
    public void fillCity(String city) {
        cityField.sendKeys(city);
    }

    /**
     * Fill credit card field
     * @param card is text inputted as card
     */
    public void fillCreditCard(String card) {
        cardField.sendKeys(card);
    }

    /**
     * Fill month field
     * @param month is text inputted as month
     */
    public void fillMonth(String month) {
        monthField.sendKeys(month);
    }

    /**
     * Fill year field
     * @param year is text inputted as year
     */
    public void fillYear(String year) {
        yearField.sendKeys(year);
    }

    /**
     * Click purchase button
     */
    public void clickPurchase() {
        purchaseButton.click();
    }

}