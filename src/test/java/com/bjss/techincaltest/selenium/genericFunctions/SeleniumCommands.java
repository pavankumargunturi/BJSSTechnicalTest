package com.bjss.techincaltest.selenium.genericFunctions;

import com.bjss.techincaltest.selenium.browserSelection.BrowserSelection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class SeleniumCommands extends BrowserSelection {

    static LoadConfigProperties config = new LoadConfigProperties();

    //command to open url in a browser
    public static void openUrl(String url) throws IOException {
        browserSel(config.loadConfig("browser"));
        driver.get(url);
    }

    //Clicking on any element in a webpage
    public static void click(By locator, String elementName){
        try{
            driver.findElement(locator).click();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to click");
        }
    }

    //Close the browser
    public static void close(){
        driver.close();
    }

    //Entering text in the textbox or textarea
    public static void sendText(By locator, String text, String elementName){
        try{
            driver.findElement(locator).sendKeys(text);
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to enter text in the textbox");
        }
    }

    //Perform keyboard operation
    public static void sendKeys (By locator, String keyBoardOperation){
           driver.findElement(locator).sendKeys(keyBoardOperation);
    }

    //Clear the text in textbox
    public static void clear(By locator, String elementName){
        try {
            driver.findElement(locator).clear();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to clear text in the textbox");
        }
    }

    //Returns the text in textbox
    public static String getText(By locator, String elementName){
        String text = "";
        try {
            text = driver.findElement(locator).getText();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to get text in the textbox");
        }
        return text;
    }

    //Returns the attribute value
    public static String getAttribute(By locator, String elementName){
        String att = "";
        try {
            att = driver.findElement(locator).getText();
        }
        catch (NoSuchElementException e){
                Assert.fail("Unable to find the element " + elementName + " to get text in the textbox");
        }
        return att;
    }

    //To verify whether the element is displayed in the page or not
    public static boolean isDisplay(By locator, String elementName){
        boolean elementDisplayed = false;
        try{
            elementDisplayed = driver.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to verify whether it is displayed or not in the page");
        }
        return elementDisplayed;
    }

    //To verify whether the element is enabled in the page or not
    public static boolean isEnable(By locator, String elementName){
        boolean elementEnabled = false;
        try{
            elementEnabled = driver.findElement(locator).isEnabled();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to verify whether it is enabled or not in the page");
        }
        return elementEnabled;
    }

    //To verify whether the element is enabled in the page or not
    public static boolean isSelected(By locator, String elementName){
        boolean elementSelected = false;
        try{
            elementSelected = driver.findElement(locator).isSelected();
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find the element " + elementName + " to verify whether it is selected or not in the page");
        }
        return elementSelected;
    }

    //To select the visible text from drop down
    public static String selectByVisibleText(By locator, String selectVisibleText, String elementName )
    {
        String selectedValue = "";
       try {
           WebElement element = driver.findElement(locator);
           Select s = new Select(element);
           s.selectByVisibleText(selectVisibleText);
           selectedValue = s.getFirstSelectedOption().getText();
       }
       catch(NoSuchElementException e){
           Assert.fail("Unable to find element " + elementName + " to select the visibility text from drop down");
       }
        return selectedValue;
    }

    //Select the default value from drop down
    public static String selectDefaultValue_Dropdown(By locator, String elementName )
    {
        String selectedValue = "";
        try {
            WebElement element = driver.findElement(locator);
            Select s = new Select(element);

            selectedValue = s.getFirstSelectedOption().getText();
        }
        catch(NoSuchElementException e){
            Assert.fail("Unable to find element " + elementName + " to select the visibility text from drop down");
        }
        return selectedValue;
    }
    //To select the value from drop down
    public static void selectByValue_Dropdown(By locator, String selectByValue, String elementName){
        try{
            Select sel = new Select(driver.findElement(locator));
            sel.selectByValue(selectByValue);
        }
        catch(NoSuchElementException e){
            Assert.fail("Unable to find element " + elementName + " to select the visibility text from drop down");
        }
    }

    //To select the index from drop down
    public static void selectByIndex_Dropdown(By locator, String selectByIndex, String elementName){
        try{
            Select sel = new Select(driver.findElement(locator));
            sel.selectByValue(selectByIndex);
        }
        catch(NoSuchElementException e){
            Assert.fail("Unable to find element " + elementName + " to select the visibility text from drop down");
        }
    }

    //Submit Form
    public static void submitForm(By locator){
        driver.findElement(locator).submit();
    }

    //Accept alert
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //Dismiss alert
    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //Wait until visibility Of Element Located
    public static void waitForVisibilityOfElement(int timeInSeconds, By locator, String elementName){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (NoSuchElementException e){
            Assert.fail("Unable to find element " + elementName);
        }
    }

    //Mouse Over
    public static void mouseOver(By mouseoverLocator, By clickableLocator){
        Actions action = new Actions(driver);
        WebElement mo = driver.findElement(mouseoverLocator);
        action.moveToElement(mo).moveToElement(driver.findElement(clickableLocator)).click().build().perform();
     }

     public static void mouseover_presenceOfElementLocated(By locator){
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
         Actions builder = new Actions(driver);
         builder.moveToElement(element).perform();
     }

     public static int tableCount(By locator){
         List<WebElement> rows = driver.findElements(locator);
         int count = rows.size();
         return count;
     }
}
