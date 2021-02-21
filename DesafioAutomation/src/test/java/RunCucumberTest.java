

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/report-html.html", "json:target/report-json.json"})
public class RunCucumberTest {
}
