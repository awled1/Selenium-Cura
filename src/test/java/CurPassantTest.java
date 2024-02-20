import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CurPassantTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void PassantTest() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement profileTitle = driver.findElement(By.id("btn-make-appointment"));
        Assert.assertTrue(profileTitle.isDisplayed(), "La page de profil n'a pas été chargée après la connexion.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
