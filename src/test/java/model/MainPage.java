package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    private WebElement logo;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public WebElement getLogo() {
        if (logo == null ) {
            logo = getDriver().findElement(By.className("app_logo"));
        }
        return logo;
    }
}
