package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {
    private WebDriver driver;

    //Locators
    private By EmailId = By.xpath("//input[@placeholder='Enter your email']");
    private By Password = By.xpath("//input[@placeholder='Enter your password']");
    private By LoginButton = By.xpath("//button[text()='Log in']");

    public Loginpage(WebDriver driver){
        this.driver=driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void EnterEmail(String email){
        driver.findElement(EmailId).sendKeys(email);
    }

    public void EnterPassword(String password){
        driver.findElement(Password).sendKeys(password);
    }

    public void ClickonLoginButton(){
        driver.findElement(LoginButton).click();
    }

    public HomePage doLogin(String userName, String PassWord){
        driver.findElement(EmailId).sendKeys(userName);
        driver.findElement(Password).sendKeys(PassWord);
        System.out.println("Logged in with UserName: "+userName+" and Password: "+PassWord);
        driver.findElement(LoginButton).click();
        //if it lands on homepage then do login method responsibility to provide the home page as per chaining method
        return new HomePage(driver);
    }
}
