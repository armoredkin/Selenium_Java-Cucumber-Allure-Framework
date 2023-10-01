package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
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

    @FindBy(id = "tbodyid")
    private WebElement productListTable;

    /**
     * Go to destination url
     * @param url is destination url
     */
    public void openPage(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * Get list of all product titles in Home
     * @return  array of String product titles
     */
    public List<String> storeProductName(){
        // find the table
        WebElement t = driver.findElement(By.id("tbodyid"));
        // count cards inside table with size() method
        List<WebElement> rws = t.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
        int rws_cnt = rws.size();
        // create empty Webelement and list of strings
        WebElement title;
        List<String> titles = new ArrayList<>();
        //iterate cards in table, get title in each card, then add to list
        for (int i = 1;i <= rws_cnt; i++) {
            title = driver.findElement(By.cssSelector("#tbodyid > div:nth-of-type(" + i + ") .hrefch"));
            titles.add(title.getText());
        }
        return titles;
    }

    /**
     * Click product titles in Home by product name
     * @param productName is product name
     */
    public void clickProductName(String productName){
        WebElement p = driver.findElement(By.xpath("//a[.='" + productName + "']"));
        p.click();
    }

}
