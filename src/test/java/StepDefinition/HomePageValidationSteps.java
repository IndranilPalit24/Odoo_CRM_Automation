package StepDefinition;

import DataProvider.DriverFactory;
import Pages.HomePage;
import Pages.Loginpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class HomePageValidationSteps {
    private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
    private HomePage homepage;

    @Given("User has already logged into the application")
    public void user_has_already_logged_into_the_application(DataTable loginTable) throws InterruptedException {
        List<Map<String,String>> loginlist = loginTable.asMaps();
        String username = loginlist.get(0).get("username");
        String password = loginlist.get(0).get("password");

        DriverFactory.getDriver().get("https://abc-company5.odoo.com/odoo");
        Thread.sleep(5000);
        homepage = loginpage.doLogin(username,password);

    }
    @Given("User is on the HomePage Login Page")
    public void user_is_on_the_home_page_login_page() {
        String title = homepage.getHomePageTitle();
        System.out.println("Home Page Title: "+title);

    }
    @Then("Home Page Lists should be verified as provided Below")
    public void home_page_lists_should_be_verified_as_provided_below(DataTable sectionTable) {
        List<String> expectedHomePageList = sectionTable.asList();
        System.out.println("Expected Home Page List: "+expectedHomePageList);

        List<String> ActualHomePageList = homepage.verifyHomePageList();
        System.out.println("Actual Home Page List: "+ActualHomePageList);

        Assert.assertTrue(expectedHomePageList.containsAll(ActualHomePageList));

    }
}
