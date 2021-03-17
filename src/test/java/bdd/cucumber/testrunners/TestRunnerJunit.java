package bdd.cucumber.testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/resources/Features"},
        glue={"bdd.cucumber.stepdefinitions"},
        tags= "@sample or not @sampleSc" ,
        plugin= {"pretty"},
        monochrome=true,
        dryRun=false
        )
public class TestRunnerJunit {

}