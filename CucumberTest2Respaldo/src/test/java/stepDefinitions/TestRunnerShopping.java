package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features/compra.feature",
							glue = {"stepDefinitions"},
							monochrome = true,
							strict = true,
							plugin = {"json:target/cucumber.json"})

public class TestRunnerShopping {

}
