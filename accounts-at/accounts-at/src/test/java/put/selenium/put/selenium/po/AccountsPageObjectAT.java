package put.selenium.put.selenium.po;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.put.selenium.po.repository.*;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;


public class AccountsPageObjectAT {

    private WebDriver driver;

    ResetDatabase resetDatabse;
    MainMenu mainMenu;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    MainPage mainPage;
    LoggedInUserInformation loggedInUserInfo;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);

        resetDatabse = new ResetDatabase(driver);
        mainMenu = new MainMenu(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver, "localhost:8080");
        loggedInUserInfo = new LoggedInUserInformation(driver);

        resetDatabse.resetDatabase();
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        // TODO
        java.lang.String username = "user";
        java.lang.String password = "password";
        java.lang.String name = "Jan Kowalski";
        java.lang.String address = "ul. Nowa 10";

        mainPage.openPage();
        mainPage.isOnPageNotLoggedIn();
        mainMenu.clickRegisterLink();
        registrationPage.isOnPage();
        registrationPage.registerUser(username, password, password, name, address);
        loginPage.isOnPage();
        loginPage.loginUser(username, password);
        loggedInUserInfo.getUserInformation();
    }


}
