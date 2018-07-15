package com.penske.products.fleetinsight.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/main/resources/cucumber/"},
        glue = "com.penske.products.fleetinsight.tests",
        tags = {"~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/fleetinsight.json",
                "rerun:target/cucumber-results/fleetinsight.txt"})
public class Runner extends AbstractTestNGCucumberTests {
}
