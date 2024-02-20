import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MakeAppTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void appointment() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();


        WebElement profileTitle = driver.findElement(By.id("btn-make-appointment"));
        WebElement dateInput = driver.findElement(By.id("txt_visit_date"));
        dateInput.sendKeys("2024-06-15  ");
        WebElement commentInput = driver.findElement(By.id("txt_comment"));
        commentInput.sendKeys("Rendez-vous.");
        WebElement submitButton = driver.findElement(By.id("btn-book-appointment"));
        submitButton.click();

            String urlapp = driver.getCurrentUrl();
            //WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a"));
            //Assert.assertTrue(successMessage.isDisplayed(), "Le rendez-vous n'a pas été créé avec succès.");
            Assert.assertEquals(urlapp, "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

            Thread.sleep(3000);
            driver.close();
        }
    }


