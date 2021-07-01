package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;


public class CucumberBase extends BaseTest {

    private static BaseTest baseTest = null;

    @Before
    public static void before() {
        baseTest = new CucumberBase();
        baseTest.startup();
    }

    @After
    public static void after() {
        baseTest.finishUp();
    }

    public static WebDriver getCurrentDriver() {
        return baseTest.getDriver();
    }
}