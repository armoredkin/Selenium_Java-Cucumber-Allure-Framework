package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebElement anyElement;
    List<String> anyList = new ArrayList<>();

    public CartPage(WebDriver driver){
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

    @FindBy(css = "td:nth-of-type(2)")
    private WebElement firstProductTitle;

    /**
     * Get first row product title
     * @return first product title
     */
    public String getFirstProductTitle(){
        return firstProductTitle.getText();
    }

    /**
     * Get price text relative to product name
     * @param productName is product name
     * @return text price
     */
    public String getPrice(String productName){
        String element = "//td[.='" + productName + "']/following-sibling::td[1]";
        return driver.findElement(By.xpath(element)).getText();
    }

    /**
     * Click delete relative to product name
     * @param productName is product name
     */
    public void clickDelete(String productName) throws InterruptedException {
        String element = "//td[.='" + productName + "']/following-sibling::td[2]/a";
        driver.findElement(By.xpath(element)).click();
        Thread.sleep(2000);
    }

    /**
     * Get number of products in cart
     * @return String total products in cart
     */
    public int getProductListSize() {
        // find the table
        WebElement t = driver.findElement(By.id("tbodyid"));
        // count rows inside table with size() method
        List<WebElement> rws = t.findElements(By.xpath("//tr[@class='success']"));
        return rws.size();
    }

    /**
     * Get all products image link in cart
     * @return List<String> image links
     */
    public List<String> getImageLinks(){
        anyList.clear();
        //iterate cards in table, get img link in each card, then add to list
        for (int i = 1;i <= this.getProductListSize(); i++) {
            anyElement = driver.findElement(By.cssSelector("#tbodyid > tr:nth-of-type(" + i + ") > td:nth-of-type(1) > img"));
            anyList.add(anyElement.getAttribute("src").substring(26));
        }
        return anyList;
    }

    /**
     * Get all products titles in cart
     * @return List<String> product titles
     */
    public List<String> getProductTitles(){
        anyList.clear();
        //iterate cards in table, get title in each card, then add to list
        for (int i = 1;i <= this.getProductListSize(); i++) {
            anyElement = driver.findElement(By.cssSelector("#tbodyid > tr:nth-of-type(" + i + ") > td:nth-of-type(2)"));
            anyList.add(anyElement.getText());
        }
        return anyList;
    }

    /**
     * Delete products in cart
     * @param products is list of products name
     */
    public void deleteProducts(List<String> products) throws InterruptedException {
        //iterate rows in table, get price in each card, then add to list
        for (String product : products) {
            anyElement = driver.findElement(By.xpath("//td[.='" + product + "']/following-sibling::td[2]/a"));
            anyElement.click();
            Thread.sleep(2000);
        }
    }
}
