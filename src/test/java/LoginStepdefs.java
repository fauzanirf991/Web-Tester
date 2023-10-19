import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepdefs {
    private WebDriver driver;
    @Test
    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User on the login page")
    public void userOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");
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
        driver.findElement(By.id("login_button")).click();
    }

    @Then("user get a message {string}")
    public void userGetAMessage(String message) {
        assertEquals(driver.findElement(By.id("loginstatus")).getText(), (message));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
