package Hooks;

import DataProvider.DriverFactory;
import Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

/**
 * Hooks - Pre Annotation and Post Annotation
 */
public class Hooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browser_Name = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browser_Name);
    }

    @After(order = 0)
    public void closeBrowser(){
        driver.quit();
    }

    @After(order =1)
    public void takeScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            //Take Screenshot:
            String screenshot_Name = scenario.getName().replaceAll("","_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png",screenshot_Name);

        }

    }


}
