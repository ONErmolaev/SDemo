package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginPage;
import model.MainPage;
import org.testng.Assert;
import runner.CucumberBase;

public class LoginTestsCu {

    private LoginPage loginPage;
    private MainPage mainPage;

    @Given("I am on the Sauce Demo Login Page")
    public void goToLoginPage() {
        loginPage =  new LoginPage(CucumberBase.getCurrentDriver());
        loginPage.open();
    }

     @When("I fill the account information for account {string} into the Username field and the password field {string}")
     public void enterCredentials(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("I click the Login Button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void redirectToTheMainPage(){
        mainPage =  new MainPage(CucumberBase.getCurrentDriver());
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @And("I verify the App Logo exists")
    public void verifyLogo(){
        Assert.assertTrue(mainPage.getLogo().isDisplayed());
        Assert.assertTrue(
                mainPage.getLogo().getCssValue("background-image").contains("https://www.saucedemo.com/static/media/logo3x.096bf4a7.svg"),
                "Unable to find logo image"
        );
    }

    @Then("I verify the Error Message contains the text {string}")
    public void verifyErrorMessage(String errorMessage){
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: " + errorMessage);
    }
}
