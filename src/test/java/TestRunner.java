import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "alertPackage",
        features = "src/test/resources/features", tags = "@alert3",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports/html.html"})
public class TestRunner {
}
