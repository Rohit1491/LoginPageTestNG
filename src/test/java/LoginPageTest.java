import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {
    @Test
    public void loginWithValidCredentials() {
        // Set the system property for Chrome driver with its path
        WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        // Locate the username input field element by its id
        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");

        // Locate the password input field element by its id
        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");

        // Find the login button element by its class name
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));

        // Submit the login form
        loginButtonEl.submit();

        // Declare expected URL
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        // Wait for the page to be redirected to the expected URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Verify if the expected URL matches the current URL
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");

        // Declare the expected and current headings for the homepage
        String expectedHomeHeading = "Clothes That Get YOU Noticed";
        WebElement actualHomeHeadingEl = driver.findElement(By.className("home-heading"));
        String actualHomeHeading = actualHomeHeadingEl.getText();

        // Verify if the expected heading matches the actual heading
        Assert.assertEquals(expectedHomeHeading, actualHomeHeading, "Homepage heading does not match");

        // Close the driver instance
        driver.close();

    }
}
