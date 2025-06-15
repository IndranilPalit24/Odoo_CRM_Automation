package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    /**
     * Initializes the WebDriver based on the browser name provided.
     *
     * @param Browser The name of the browser (e.g., "chrome", "firefox").
     * @return A WebDriver instance for the specified browser.
     */
    public WebDriver init_Driver(String Browser, String headless_Mode){
        System.out.println("Browser is "+Browser);

        if(Browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
//            driverThread.set(new ChromeDriver());

            ChromeOptions options =new ChromeOptions();

            if(headless_Mode.equalsIgnoreCase("YES")) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-extensions");
            }

            driverThread.set(new ChromeDriver(options));
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
