package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;

public class ProdDetailPage {

    WebDriver driver;

    public ProdDetailPage(WebDriver driver){
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

    @FindBy(css = ".name")
    private WebElement productTitle;

    @FindBy(css = ".price-container")
    private WebElement priceLabel;

    @FindBy(css = "small")
    private WebElement taxLabel;

    @FindBy(css = "#more-information > p")
    private WebElement productDesc;

    @FindBy(css = ".btn-success")
    private WebElement addToCartButton;

    /**
     * Get product title
     * @return product title
     */
    public String getProductTitle(){
        return productTitle.getText();
    }

    /**
     * Get product price
     * @return product price
     */
    public String getProductPrice(){
        return priceLabel.getText();
    }

    /**
     * Get product description
     * @return product description
     */
    public String getProductDesc(){
        return productDesc.getText();
    }

    /**
     * Click add to cart button
     */
    public void clickATCButton(){
        addToCartButton.click();
    }

}
