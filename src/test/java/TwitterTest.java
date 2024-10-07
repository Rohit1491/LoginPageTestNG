import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwitterTest {

    // This is a TestNG test method, denoted by the @Test annotation
    @Test
    public void titleTest() {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Twitter website
        driver.get("https://twitter.com");

        // Define the expected title of the Twitter website's login page
        String expectedTitle = "Log in to Twitter / Twitter";

        // Get the current title of the web page opened by the driver
        String actualTitle = driver.getTitle();

        // Assert that the actual title matches the expected title
        Assert.assertEquals(expectedTitle, actualTitle, "Twitter page title does not match");

        // Quit the WebDriver instance
        driver.quit();
    }
}
