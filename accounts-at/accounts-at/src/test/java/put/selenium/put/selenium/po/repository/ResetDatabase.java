package put.selenium.put.selenium.po.repository;

import org.openqa.selenium.WebDriver;

public class ResetDatabase {

    private final WebDriver driver;

    public ResetDatabase(WebDriver driver){
        this.driver = driver;
    }

    public void resetDatabase(){
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

}
