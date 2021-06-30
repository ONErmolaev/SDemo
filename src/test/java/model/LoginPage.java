package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private WebElement userField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        userField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
        return this;
    }

    public String getErrorMessage () {
        return getDriver()
                .findElement(By.xpath("//h3[@data-test='error']"))
                .getText();
    }

    public LoginPage enterCredentials(String user, String password) {
        userField.sendKeys(user);
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }
}
