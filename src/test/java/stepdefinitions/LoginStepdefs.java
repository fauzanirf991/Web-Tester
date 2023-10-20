package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepdefs {
    private WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User on the login page")
    public void userOnTheLoginPage() {
        driver.get(baseUrl);
    }

    @And("user fill in the User Name as {string}")
    public void userFillInTheUserNameAs(String userName) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
    }

    @And("user fill in the Password as {string}")
    public void userFillInThePasswordAs(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user click on the Log In button")
    public void userClickOnTheLogInButton() {
        driver.findElement(By.className("submit-button")).click();
    }

   @Then("user should be redirected to the dashboard page")
    public void verifyRedirectToDashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
    }
    @Then("user get a message {string}")
    public void userGetAMessage(String message) {
        assertEquals(driver.findElement(By.tagName("h3")).getText(), (message));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
