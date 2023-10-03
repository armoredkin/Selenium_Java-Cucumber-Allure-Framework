package demoblaze.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HeaderPage;
import pages.HomePage;
import pages.ProdDetailPage;
import pages.RegisterPopUp;
import utilities.ThreadManager;

import java.util.ArrayList;
import java.util.List;

public class ProductBrowsingSteps {

    List<String> productList = new ArrayList<>();
    private WebDriver driver = ThreadManager.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ProdDetailPage pdp = new ProdDetailPage(driver);

    @Step
    @When("user check product list")
    public void user_check_product_list() {
        productList.addAll(homepage.storeProductName());
    }

    @Then("user see product list contains {string}")
    public void user_see_product_list_contains(String product) {
        Assert.assertTrue(this.productList.contains(product));
    }

    @When("user click product {string} in home")
    public void user_click_product_in_home(String productName) {
        homepage.clickProductName(productName);
    }

    @Then("user see the title in product detail page is {string}")
    public void user_see_the_title_in_product_detail_page_is(String title) {
        Assert.assertEquals(pdp.getProductTitle(), title, "Product title is wrong");
    }

    @Then("user see the price in product detail page is {string}")
    public void user_see_the_price_in_product_detail_page_is_and(String price) {
        Assert.assertEquals(pdp.getProductPrice().trim(), price, "Product price is wrong");
    }

    @Then("user see the description in product detail page is {string}")
    public void user_see_the_description_in_product_detail_page_is(String desc) {
        Assert.assertEquals(pdp.getProductDesc().trim(), desc, "Product description is wrong");
    }
}