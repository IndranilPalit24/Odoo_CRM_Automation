package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Feature/Home Page Validation/HomePageValidation.feature"},
        glue = {"StepDefinition", "Hooks"},
        plugin={"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"// Generate detailed HTML report
        }
)
public class HomePageValidationTestRunner {
}
