package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;


public class CucumberBase extends BaseTest {

    private static long startMillis;
    private static BaseTest baseTest = null;

    @Before
    public static void before(Scenario scenario) {
        baseTest = new CucumberBase();
        baseTest.startup();
    }

    @After
    public static void after(Scenario scenario) {
        baseTest.finishUp();
    }

    public static WebDriver getCurrentDriver() {
        return baseTest.getDriver();
    }
}