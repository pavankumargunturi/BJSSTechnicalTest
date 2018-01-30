package com.bjss.techincaltest.selenium.browserSelection;

import com.bjss.techincaltest.selenium.genericFunctions.LoadConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserSelection {

    public static final String IE = "IE";
    public static final String FIREFOX = "firefox";
    public static WebDriver driver;


    public static void browserSel(String browser) throws IOException {

        LoadConfigProperties config = new LoadConfigProperties();
        if(browser.equalsIgnoreCase(FIREFOX)){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase(IE)){
            System.setProperty("webdriver.ie.driver", config.loadConfig("ieDriverPath"));

            DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            cap.setCapability("ignoreZoomSetting",true);
            cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
            driver = new InternetExplorerDriver(cap);
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
