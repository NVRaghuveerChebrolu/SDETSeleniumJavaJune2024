package BDDtestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/BDDfeatures",
	glue= {"com.BDD"},
	tags = "@GmoRegression",
	plugin= {"pretty","html:target/cucumber-reports.html"},
	//dryRun=true,
	monochrome=true
		)
public class TestRunner {
}
