package com.bjss.techincaltest.selenium.stepDefinitions;

import com.bjss.techincaltest.selenium.genericFunctions.SeleniumCommands;
import com.bjss.techincaltest.selenium.objectRepository.OrderHistory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Test3_StepDefinitions extends SeleniumCommands {
    String dreesColour = "";

    @When("^create an assertion which will cause a fail for dress colour and capture screenshot$")
    public void create_an_assertion_which_will_cause_a_fail_for_dress_colour_and_capture_screenshot() throws Throwable {
        click(OrderHistory.orderReference,"Order Reference");
        dreesColour = getText(OrderHistory.product, "product");
        if (dreesColour.equalsIgnoreCase("Red")) {
        } else {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/DressColor2.png"));
            Assert.fail("Dress colour is not Red");
        }

    }
}
