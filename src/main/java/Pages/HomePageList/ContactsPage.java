package Pages.HomePageList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage {
    private WebDriver driver;
    private WebDriverWait wait;


    /**
     * Locators to Create a New Contact
     */
    private By ContactSection = By.xpath("//div[text() ='Contacts']");
    private By VerifyContact = By.xpath("//span[text() ='Name']");
    private By NewButton = By.xpath("//button[text() =' New ']");

    /**
     * Locators to Select Contact Type
     */

    private By SelectPerson = By.xpath("//label[text()='Person']");
    private By SelectCompany = By.xpath("//label[text()='Company']");

    /**
     * City Locator used is Abeerdenshire
     */
    private By StateName = By.xpath("//a[text()='Aberdeenshire ']");

    /**
     * Locators to Create Account for Company
     */
    private By CompanyName = By.xpath("//input[@placeholder='e.g. Lumber Inc']");
    private By CompanyEmail = By.xpath("//input[@placeholder='Email']");
    private By PhoneButton = By.xpath("//input[@placeholder='Phone']");
    private By Street1 = By.xpath("//input[@placeholder='Street...']");
    private By Street2 = By.xpath("//input[@placeholder='Street 2...']");
    private By City = By.xpath("//input[@placeholder='City']");
    private By State = By.xpath("//input[@placeholder='State']");
    private By Zip = By.xpath("//input[@placeholder='ZIP']");
    private By Country = By.xpath("//input[@placeholder='Country']");
    private By GSTIN = By.xpath("//input[@placeholder='e.g. BE0477472701']");
    private By Website = By.xpath("//input[@placeholder='e.g. https://www.odoo.com']");
    private By CategoryId = By.xpath("//div[@name = 'category_id']/div/div/div/div/input");
    private By SelectTags = By.xpath("//a[@class='dropdown-item ui-menu-item-wrapper text-truncate'][1]");
    private By B2BTag = By.xpath("//a[.//span[normalize-space()='B2B']]");
    private By AddContact = By.xpath("//div[contains(text(),'Add Contact')]");
    private By SaveAndClose = By.xpath("//button[contains(text(),'Save & Close')]");
    private By ContactList = By.xpath("//a[@aria-label='Home menu']//span[contains(text(),'Contacts')]");
    private By JobTitleforCompany = By.xpath("//input[@placeholder='Job title']");

    /**
     * Locators to Create Account for Person
     */
    private By PersonName = By.xpath("//input[@placeholder='e.g. Brandon Freeman']");
    private By PersonEmail = By.xpath("//input[@placeholder='Email']");
    private By PersonPhone = By.xpath("//input[@placeholder='Phone']");
    private By CompanyNameForPerson = By.xpath("//input[@placeholder='Company Name...']");
    private By JobPosition = By.xpath("//input[@placeholder='e.g. Sales Director']");
    //Street1, Street2, City, State, Zip, Country, GSTIN, WebSite, and Tags have the same locators to be used

    /**
     * Locators for Modal
     *
     */
    private By ModalChange = By.xpath("//div[@class='modal-dialog modal-dialog-centered modal-lg']");
    private By EmailIdModal = By.xpath("//div[@class='modal-dialog modal-dialog-centered modal-lg']//input[@placeholder='Email']");
    private By PhoneModal = By.xpath("//div[@class='modal-dialog modal-dialog-centered modal-lg']//input[@placeholder='Phone']");



    public ContactsPage(WebDriver driver){
        /**
         * @params driver, wait
         * @return this constructor is used to create a new instance of ContactsPage class
         */
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Methods
    public String getContactSection(){
        return driver.findElement(ContactSection).getText();
    }

    public void clickonContactSection(){
        driver.findElement(ContactSection).click();
    }

    public boolean verifyContactSection(){
        /**
         * @return it verifies if the Contact Section is displayed or not
         */
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

    public void SelectCompanyOrPerson(String ContactType, String name){
        /**
         * @param ContactType, name
         * @return it clicks on the Select Company or Select Person button and then creates a new account
         * for either Person or Company based on the ContactType provided.
         */
        if(ContactType.equalsIgnoreCase("Person")){
            wait.until(ExpectedConditions.elementToBeClickable(SelectPerson)).click();
            System.out.println("Person Account is being Created.....");
            CreateNewAccountForPerson(name);
        }else if(ContactType.equalsIgnoreCase("Company")){
            wait.until(ExpectedConditions.elementToBeClickable(SelectCompany)).click();
            System.out.println("Company Account is being Created.....");
            CreateNewAccountForCompany(name);
        }else{
            System.out.println("Invalid Person or Company type provided. Please provide either Person or Company");
        }
    }

    public void CreateNewAccountForCompany(String companyName){
        /**
         * @param companyName
         * @return it creates a new account for a company based on the companyName provided.
         */
        wait.until(ExpectedConditions.elementToBeClickable(CompanyName)).click();
        driver.findElement(CompanyName).sendKeys(companyName);

        wait.until(ExpectedConditions.elementToBeClickable(CompanyEmail)).click();
        driver.findElement(CompanyEmail).sendKeys("abc123@gmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(PhoneButton)).click();
        driver.findElement(PhoneButton).sendKeys("1234567891");

        wait.until(ExpectedConditions.elementToBeClickable(Street1)).click();
        driver.findElement(Street1).sendKeys("Aberdeen City Council, Business Hub 4");

        wait.until(ExpectedConditions.elementToBeClickable(Street2)).click();
        driver.findElement(Street2).sendKeys("Marischal College, Broad Street, Aberdeen");

        wait.until(ExpectedConditions.elementToBeClickable(City)).click();
        driver.findElement(City).sendKeys("Aberdeen");

        wait.until(ExpectedConditions.elementToBeClickable(Zip)).click();
        driver.findElement(Zip).sendKeys("AB12 3AB" +Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(State)).click();
        driver.findElement(State).sendKeys("Aberdeenshire (GB)");

        wait.until(ExpectedConditions.elementToBeClickable(StateName)).click();

//        wait.until(ExpectedConditions.elementToBeClickable(Country)).click();
//        driver.findElement(Country).sendKeys("United Kingdom");

        wait.until(ExpectedConditions.elementToBeClickable(GSTIN)).click();
        driver.findElement(GSTIN).sendKeys("BE0477472701");

        wait.until(ExpectedConditions.elementToBeClickable(Website)).click();
        driver.findElement(Website).sendKeys("https://www.odoo.com");

        wait.until(ExpectedConditions.elementToBeClickable(CategoryId)).click();
        driver.findElement(CategoryId).sendKeys("B2B");
//        driver.findElement(B2BTag).click();

        wait.until(ExpectedConditions.elementToBeClickable(AddContact)).click();
        driver.findElement(AddContact).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(ModalChange));

        wait.until(ExpectedConditions.elementToBeClickable(PersonName)).click();
        driver.findElement(PersonName).sendKeys("Brandon");

        wait.until(ExpectedConditions.elementToBeClickable(EmailIdModal)).click();
        driver.findElement(PersonEmail).sendKeys("brandon2013@gmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(PhoneModal)).click();
        driver.findElement(PersonPhone).sendKeys("98753213445");

        wait.until(ExpectedConditions.elementToBeClickable(JobTitleforCompany)).click();
        driver.findElement(JobTitleforCompany).sendKeys("Vice President");

        wait.until(ExpectedConditions.elementToBeClickable(SaveAndClose));
        driver.findElement(SaveAndClose).click();
    }

    public void CreateNewAccountForPerson(String personName){
        /**
         * @param personName
         * @return it creates a new account for a person based on the personName provided.
         */
        wait.until(ExpectedConditions.elementToBeClickable(PersonName)).click();
        driver.findElement(PersonName).sendKeys(personName);
        System.out.println("Person Account is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(PersonEmail)).click();
        driver.findElement(PersonEmail).sendKeys("abccompany@gmail.com");
        System.out.println("Person Email is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(PersonPhone)).click();
        driver.findElement(PersonPhone).sendKeys("1234567891");
        System.out.println("Person Phone is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(CompanyNameForPerson)).click();
        driver.findElement(CompanyNameForPerson).sendKeys("Lumber Inc");
        System.out.println("Company Name is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(Street1)).click();
        driver.findElement(Street1).sendKeys("Aberdeen City Council, Business Hub 4");
        System.out.println("Street1 is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(Street2)).click();
        driver.findElement(Street2).sendKeys("Marischal College, Broad Street, Aberdeen");
        System.out.println("Street2 is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(City)).click();
        driver.findElement(City).sendKeys("Aberdeen");
        System.out.println("City is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(Zip)).click();
        driver.findElement(Zip).sendKeys("AB12 3AB" +Keys.ENTER);
        System.out.println("Zip is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(State)).click();
        driver.findElement(State).sendKeys("Aberdeenshire (GB)");
        System.out.println("State is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(StateName)).click();
        System.out.println("State Name is being Created.....");

//        wait.until(ExpectedConditions.elementToBeClickable(Country)).click();
//        driver.findElement(Country).sendKeys("United Kingdom");


        wait.until(ExpectedConditions.elementToBeClickable(JobPosition)).click();
        driver.findElement(JobPosition).sendKeys("Sales Director");
        System.out.println("Job Position is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(GSTIN)).click();
        driver.findElement(GSTIN).sendKeys("BE0477472701");
        System.out.println("GSTIN is being Created.....");

        wait.until(ExpectedConditions.elementToBeClickable(Website)).click();
        driver.findElement(Website).sendKeys("https://www.odoo.com");
        System.out.println("Website is being Created.....");


        String[] tags = {"Sales", "Marketing", "Operations"};

        for(String tag:tags){
            wait.until(ExpectedConditions.elementToBeClickable(CategoryId)).click();
            driver.findElement(CategoryId).click();
            driver.findElement(CategoryId).sendKeys(tag);
            driver.findElement(CategoryId).sendKeys(Keys.ENTER);
        }
        System.out.println("Tags are being Posted in the Account.....");

    }
    public void NavigateBackToContactList(){
        driver.findElement(ContactList).click();
        System.out.println("Navigated Back to Contact List Page.....");

    }



}
