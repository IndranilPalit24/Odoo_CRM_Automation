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
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Hooks - Pre Annotation and Post Annotation
 */
public class Hooks {
    private DriverFactory driverFactory;
    
    private WebDriver driver;
    
    private ConfigReader configReader;
    
    Properties prop;
    
    private static Logger log;
    
    
    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        log = LogManager.getLogger(this.getClass().getName());
    }

    @Before(order = 1)
    public void setup(){
    	
    	log.info("===================================Odoo CRM Started=====================\n");
        String browser_Name = prop.getProperty("browser");
        String headless_Mode = prop.getProperty("headless");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browser_Name,headless_Mode);

        //URL to Launch test environment
        String url = prop.getProperty("URL");
        driver.get(url);
        log.info("Launching Browser with URL: "+url+ "\n");
    }

    @After(order = 0)
    public void teardown(){
        driver.quit();
        log.info("========================Driver is Closed===============================\n");
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
