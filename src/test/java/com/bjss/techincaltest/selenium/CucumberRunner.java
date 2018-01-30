package com.bjss.techincaltest.selenium;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        format = {"html:src/report/cucumber-html-report",
        "json:src/report/cucumber-json-report.json",
        "junit:BJSSTechnincalTest/src/report/cucumber-results.xml",
        "usage:BJSSTechnincalTest/src/report/cucumber-usage.json"},
        glue = {"com/bjss/techincaltest/selenium/stepDefinitions"}

)

public class CucumberRunner {
}
