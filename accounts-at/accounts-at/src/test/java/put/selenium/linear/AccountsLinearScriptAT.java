package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        //TODO
        driver.get("http://localhost:8080/accounts/controller");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("pass");
        driver.findElement(By.name("repeat_password")).click();
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("pass");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("name");
        driver.findElement(By.name("addressData")).click();
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("adress");
        driver.findElement(By.name("submit")).click();
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }


}
