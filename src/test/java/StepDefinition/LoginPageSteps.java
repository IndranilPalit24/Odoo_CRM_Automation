package StepDefinition;

import DataProvider.DriverFactory;
import Pages.Loginpage;
import Utility.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    private static String Title;
    private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
    ConfigReader configReader = new ConfigReader();
    String URL = configReader.getURL();

    @Given("I login into the website")
    public void i_login_into_the_website() throws InterruptedException {
        DriverFactory.getDriver().get(URL);
        System.out.println("Launching Browser with URL: "+URL);
        Thread.sleep(10000);
    }
    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {
        loginpage.EnterEmail(username);
        loginpage.EnterPassword(password);
    }
    @Then("I should be logged into the website")
    public void i_should_be_logged_into_the_website() throws InterruptedException {
        loginpage.ClickonLoginButton();
        Thread.sleep(5000);
    }
    @Then("Home Page should be opened and title should be title {string}")
    public void home_page_should_be_opened_and_title_should_be_title(String ExpectedTitle) throws InterruptedException {
        Thread.sleep(5000);
        Title = loginpage.getLoginPageTitle();
        System.out.println("Login Page Title: " + Title);
        Assert.assertTrue(Title.contains(ExpectedTitle));
    }

}
