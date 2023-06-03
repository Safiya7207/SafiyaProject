package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinations"},
monochrome= true,
plugin= {
		"pretty", "json:target/JSONReports/report.json",
		"pretty", "html:target/HTMLReports/report.html",
		"pretty", "junit:target/JUnitReports/report.xml"
		}


		)
public class TestRunner {

}
