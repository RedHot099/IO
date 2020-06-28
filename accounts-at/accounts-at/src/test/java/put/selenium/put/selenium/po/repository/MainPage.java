package put.selenium.put.selenium.po.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(xpath="//h3")
    WebElement header;

    private String host;

    public MainPage(WebDriver driver, String host){

        this.driver = driver;
        this.host = host;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public boolean isOnPageNotLoggedIn(){
        return header.getText().equals("Login");
    }

    public void openPage(){
        driver.get(String.format("http://%s/accounts/controller", this.host));
    }


}
