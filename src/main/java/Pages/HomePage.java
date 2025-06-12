package Pages;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    //Locators
    private By HomePageSection = By.xpath("//div[@role=\"listbox\"]/div");

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * Returns the title of the current page.
     * @return
     */
    public String getHomePageTitle(){
        return driver.getTitle();
    }

    //Page Action
    public List<String> verifyHomePageList(){
        /**
         * This Method creates a new list to store the element in the List
         * It adds all the HomePage Sections to HomePageList Array(WebElement)
         * using For Loop we find the elements one by one and then add them to the new List which is
         * HomePageNewList and print it in the console too
         */
        List<String>HomePageNewList = new ArrayList<>();
        List<WebElement> HomePageList = driver.findElements(HomePageSection);
        System.out.println("HomePageList Size: "+HomePageList.size());

        for(WebElement element:HomePageList){
            String List = element.getText();
            System.out.println("List is: "+List);

            HomePageNewList.add(List);
        }

        return HomePageNewList;
    }

}
