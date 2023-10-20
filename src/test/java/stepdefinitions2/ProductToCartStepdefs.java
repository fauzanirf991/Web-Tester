package stepdefinitions2;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductToCartStepdefs {
    private WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("user on the login page 2")
    public void userOnTheLoginPage() {
        driver.get(baseUrl);
    }

    @And("user enters valid credentials {string}")
    public void userEntersValidCredentials(String userName) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click on the Log In button 2")
    public void userClickOnTheLogInButton() {
        driver.findElement(By.className("submit-button")).click();
    }

    @And("inventory page opened")
    public void inventoryPageOpened() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));

    }

    @When("user click on add to cart button a product")
    public void userClickOnAddToCartButtonAProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @Then("product added to cart")
    public void productAddedToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        if(driver.findElement(By.className("cart_item")).isDisplayed()){
            driver.quit();
        }
    }

    @Then("product not added to cart")
    public void productNotAddedToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement item = null;
        try {
            item = driver.findElement(By.className("cart_item"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Elemen tidak ditemukan
            System.out.println("Product not in the cart");
        }
    }
}
