package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    /**
     * Initializes the WebDriver based on the browser name provided.
     *
     * @param Browser The name of the browser (e.g., "chrome", "firefox").
     * @return A WebDriver instance for the specified browser.
     */
    public WebDriver init_Driver(String Browser){
        System.out.println("Browser is "+Browser);

        if(Browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driverThread.set(new ChromeDriver());
        }else{
            System.out.println("Browser not supported. Please pass the Correct Browser "+Browser);
        }

        //Add More Browsers here
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * Returns the WebDriver instance for the current thread.
     * @return
     */
    public static synchronized WebDriver getDriver(){
        return driverThread.get();
    }
}
