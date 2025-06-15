package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = {"StepDefinition","Hooks"},
        tags = "@Group03"
)
public class ContactPageValidationCompanyRunner extends AbstractTestNGCucumberTests {
}
