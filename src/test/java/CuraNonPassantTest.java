import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CuraNonPassantTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void NonPassantTest_UsernameVide() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("password");

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Le message d'erreur pour le champ username vide n'est pas affiché.");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
