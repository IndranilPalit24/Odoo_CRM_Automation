package Runner;

import io.cucumber.junit.Cucumber;
// ✅ Correct
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
                 features = {"src/test/resources/Feature/Login Feature/Login.feature"},
                 glue = {"StepDefinition", "Hooks"}
        ,         tags = "@LoginRunner"
//                 plugin={"pretty",
//                         "html:target/cucumber-reports/cucumber.html",
//                         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"// Generate detailed HTML report
//                 }
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
