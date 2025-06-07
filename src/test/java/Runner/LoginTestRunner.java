package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Feature/Login.feature"},
                 glue = {"StepDefinition", "Hooks"},
                 plugin={"pretty"}
)
public class LoginTestRunner {
}
