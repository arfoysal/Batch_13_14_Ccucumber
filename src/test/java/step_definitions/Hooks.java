package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetup;

public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");
    @Before
    public void launchBrowser(){
        DriverSetup.setBrowser(browserName);
    }

    @After
    public void quiteBrowsers(Scenario scenario){
        DriverSetup.quitBrowser(scenario);
    }
}
