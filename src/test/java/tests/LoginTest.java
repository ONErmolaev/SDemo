package tests;

import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void successLoginPageTest(){
        new LoginPage(driver)
                .open()
                .enterCredentials("standard_user", "secret_sauce")
                .clickLogin();

        WebElement logo = new MainPage(driver).getLogo();
        Assert.assertTrue(logo.isDisplayed());
        Assert.assertTrue(
                logo.getCssValue("background-image").contains("https://www.saucedemo.com/static/media/logo3x.096bf4a7.svg"),
                "Unable to find logo image"
        );
    }

    @Test(dependsOnMethods = "successLoginPageTest")
    public void failLoginPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .enterCredentials("locked_out_user", "secret_sauce")
                .clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been banned.");
     }

}
