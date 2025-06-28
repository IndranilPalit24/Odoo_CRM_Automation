package StepDefinition;

import DataProvider.DriverFactory;
import Pages.HomePage;
import Pages.HomePageList.ContactsPage;
import Pages.Loginpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;
import java.util.Map;

public class ContactPageSteps {
    private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
    private ContactsPage contactsPage = new ContactsPage(DriverFactory.getDriver());
    private static Logger log;


    @Given("User is on HomePage and clicks on Contacts")
    public void user_is_on_homepage_and_clicks_on_contacts() throws InterruptedException {
    	log = LogManager.getLogger(this.getClass().getName());
        Thread.sleep(5000);
        contactsPage.getContactSection();
        log.info("You are about to Click on Contacts Section.....");

        contactsPage.clickonContactSection();
        log.info("Contacts Section is Clicked.....");

        Thread.sleep(5000);
        contactsPage.verifyContactSection();
        log.info("Confirmed.. You are inside Contacts Page....");
    }

    @When("User clicks on New Button to create a New Contact")
    public void user_is_on_new_button_to_create_a_new_contact() throws InterruptedException {
        Thread.sleep(5000);
        contactsPage.clickonNewButton();
        log.info("Clicked on New Button to Create a New Contact.....");

    }

    /**
     * Below methods are used to create a new Account for a Person
     * @param ContactType
     * @param Person
     */

    @Then("User selects Contact Type as {string} to select and starts to create a Account for Person as {string}")
    public void user_selects_contact_to_select_and_starts_to_create_a_Account_for_individual_Person(String ContactType, String Person) throws InterruptedException {
        contactsPage.SelectCompanyOrPerson(ContactType, Person);
        log.info("Selected " +ContactType+ " as Contact Type and Created a New Account for Person.......");


        Thread.sleep(5000);

    }

    @And("New Account is created for a person")
    public void new_account_is_created_for_a_person(){
        contactsPage.NavigateBackToContactList();

    }

    /**
     * Below methods are used to create a new Account for a Company
     * @param ContactType
     * @param Company
     */
    @Then("User selects Contact Type as {string} to select and starts to create a Account for Company as {string}")
    public void user_selects_contact_to_select_and_starts_to_create_a_Account_for_Company(String ContactType, String Company) throws InterruptedException {
        Thread.sleep(5000);
        log.info("Selected "+ContactType+ " as Contact Type and Created a New Account for Company.......");
        contactsPage.SelectCompanyOrPerson(ContactType, Company);
        Thread.sleep(5000);
    }

    @And("New Account is created for the newly established Company")
    public void new_account_is_created_for_a_company(){
        contactsPage.NavigateBackToContactList();

    }

}
