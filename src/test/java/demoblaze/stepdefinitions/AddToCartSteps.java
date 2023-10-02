package demoblaze.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import utilities.ThreadManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddToCartSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ProdDetailPage pdp = new ProdDetailPage(driver);
    private HeaderPage header = new HeaderPage(driver);
    private CartPage cart = new CartPage(driver);

    @Step
    @When("user click Add to cart button")
    public void user_click_add_to_cart_button() {
        pdp.clickATCButton();
    }

    @When("user go to Cart page")
    public void user_go_to_cart_page() throws InterruptedException {
        header.clickCartHeader();
    }

    @Then("user can see product title is {string} in cart page")
    public void user_can_see_product_title_is_in_cart_page(String productTitle) {
        Assert.assertEquals(cart.getFirstProductTitle(), productTitle, "Product not appear on cart");
    }

    @Then("user can see product price for {string} is {string} in cart page")
    public void user_can_see_product_price_is_in_cart_page(String productName, String price) {
        Assert.assertEquals(cart.getPrice(productName), price, "Product not appear on cart");
    }

    @Then("user delete product {string} in cart page")
    public void user_delete_product_in_cart_page(String product) throws InterruptedException {
        cart.clickDelete(product);
    }

    @When("user add to cart several products below from Home")
    public void user_add_to_cart_several_products_below_from_home(List<String> products) throws InterruptedException {
        for (String product : products) {
            homepage.clickProductName(product);
            this.user_click_add_to_cart_button();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            header.clickHomeHeader();
        }
    }

    @Then("user can see only {string} products in the cart")
    public void user_can_see_only_products_in_the_cart(String total) {
        Assert.assertEquals(Integer.toString(cart.getProductListSize()), total, "Products in cart has wrong list size");
    }

    @Then("user can see product pics is correct in cart page :")
    public void user_can_see_product_pics_is_correct_in_cart_page(List<String> images) {
        Assert.assertTrue(cart.getImageLinks().containsAll(images) && images.containsAll(cart.getImageLinks()), "Product image links in cart is not correct");
    }

    @Then("user can see these product titles in cart page :")
    public void user_can_see_these_product_titles_in_cart_page(List<String> titles) {
        Assert.assertTrue(cart.getProductTitles().containsAll(titles) && titles.containsAll(cart.getProductTitles()), "Product titles in cart is not correct");
    }

    @Then("user can see product prices is correct in cart page :")
    public void user_can_see_product_prices_is_correct_in_cart_page(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            Assert.assertEquals(cart.getPrice(columns.get(0)), columns.get(1), "Price for " + columns.get(0) + " is incorrect");
        }
    }

    @When("user delete all products in cart page :")
    public void user_delete_all_products_in_cart_page(List<String> prices) throws InterruptedException {
        cart.deleteProducts(prices);
    }

    @Then("product list should be empty in cart page")
    public void product_list_should_be_empty_in_cart_page() {
        Assert.assertEquals(cart.getProductListSize(), 0, "Product list is not empty");
    }

    @And("user can see total product prices is {string} in cart page")
    public void user_can_see_total_product_prices_is_in_cart_page(String total) {
        Assert.assertEquals(cart.getTotalPrice(), total, "Total price is wrong");
    }
}