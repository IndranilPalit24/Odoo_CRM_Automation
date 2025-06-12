package Pages.HomePageList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contacts {
    private WebDriver driver;

    //Locators
    private By ContactSection = By.xpath("//div[text() ='Contacts']");
    private By VerifyContact = By.xpath("//span[text() ='Name']");
    private By NewButton = By.xpath("//button[text() =' New ']");
    private By SelectPerson = By.xpath("//label[text()='Person']");
    private By SelectCompany = By.xpath("//label[text()='Company']");
    private By CompanyName = By.xpath("//input[@placeholder='e.g. Lumber Inc']");


    //Constructor
    public Contacts(WebDriver driver){this.driver=driver;}

    //Methods
    public String getContactSection(){
        return driver.findElement(ContactSection).getText();
    }

    public void clickonContactSection(){
        driver.findElement(ContactSection).click();
    }

    public boolean verifyContactSection(){
        try {
            return driver.findElement(VerifyContact).isDisplayed();
        }catch(Exception e){
            System.out.println("You are not inside Contacts Section");
            return false;
        }
    }

    public void clickonNewButton(){
        driver.findElement(NewButton).click();
    }
    public void selectPerson(){
        driver.findElement(SelectPerson).click();
    }

    public void SelectCompany(){
        driver.findElement(SelectCompany).click();
    }

    public void provideValidCompanyName(String companyName){
        driver.findElement(CompanyName).click();
        driver.findElement(CompanyName).sendKeys(companyName);
    }


}
