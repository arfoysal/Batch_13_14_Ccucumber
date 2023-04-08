package utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

public class DriverSetup {
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get();
    }

    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new RuntimeException("Browser not found using the name '" + browserName + "'!");
        }
    }

    public static synchronized void setBrowser(String browserName) {
        WebDriver webDriver = getBrowser(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        setDriver(webDriver);
    }

    public static synchronized void quitBrowser(Scenario scenario) {
        takeScreenshot(scenario);
        getDriver().quit();
    }

    public static void takeScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
