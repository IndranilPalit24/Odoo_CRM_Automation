package Runner;

import io.cucumber.junit.Cucumber;
// ✅ Correct
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature/Home Page Validation/HomePageValidation.feature"},
        glue = {"StepDefinition", "Hooks"},
        tags = "@HomePageValidationTestRunner"
//        plugin={"pretty",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"// Generate detailed HTML report
//        }
)
public class HomePageValidationTestRunner extends AbstractTestNGCucumberTests {
}
