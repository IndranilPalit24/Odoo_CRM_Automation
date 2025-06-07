package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Feature/Login Feature/Login.feature"},
                 glue = {"StepDefinition", "Hooks"},
                 plugin={"pretty",
                         "html:target/cucumber-reports/cucumber.html",  // Generate detailed HTML report
                 }
)
public class LoginTestRunner {
}
