package com.bjss.techincaltest.selenium.stepDefinitions;

import com.bjss.techincaltest.selenium.genericFunctions.CommonBehaviour;
import com.bjss.techincaltest.selenium.genericFunctions.LoadConfigProperties;
import com.bjss.techincaltest.selenium.genericFunctions.SeleniumCommands;
import com.bjss.techincaltest.selenium.objectRepository.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;


public class Test1_StepDefinitions extends SeleniumCommands {

    String itemOne_Size = "", itemTwo_Size = "", itemOne_Price = "", itemTwo_Price = "", dress = "";

    @Given("^login into automation practice$")
    public void login_into_automation_practice() throws Throwable {
        LoadConfigProperties config = new LoadConfigProperties();
        openUrl(config.loadConfig("url"));
        click(HomePage.signIn,"Sign In");
        CommonBehaviour.login();

    }

    @And("^Quick view an item$")
    public void quick_view_an_item() throws Throwable {
        click(Tshirts.tShirts,"TShirts");
         mouseOver(Tshirts.image, Tshirts.tShirtsQuickView);

    }

    @And("^Change the size of the item$")
    public void change_the_size_of_the_item() throws Throwable {
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        itemOne_Price = getText(Tshirts.price,"Price");
        itemOne_Price = itemOne_Price.substring(1);
        itemOne_Size = selectByVisibleText(Tshirts.tShirtsSize,"M","TShirts Size Drop Down box");

    }

    @And("^Add that item to your baske$")
    public void add_that_item_to_your_baske() throws Throwable {
        click(Tshirts.addToCart,"Add To Cart");
        driver.switchTo().defaultContent();
    }

    @And("^Continue shopping$")
    public void continue_shopping() throws Throwable {
        Thread.sleep(3000);
        //waitForVisibilityOfElement(60,Tshirts.continueShopping,"Continue Shopping button");
        click(Tshirts.continueShopping,"Continue Shopping");
    }

    @And("^Quick view a different item \\(leave the size at the default$")
    public void quick_view_a_different_item_leave_the_size_at_the_default() throws Throwable {
        mouseover_presenceOfElementLocated(Dresses.dresses);
        click(Dresses.casualDresses,"casualDresses");
        mouseOver(Dresses.image, Dresses.quickView);
    }

    @And("^Add that item to your basket$")
    public void add_that_item_to_your_basket() throws Throwable {
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        itemTwo_Price = getText(Tshirts.price,"Price");
        itemTwo_Price = itemTwo_Price.substring(1);
        itemTwo_Size = selectDefaultValue_Dropdown(Tshirts.tShirtsSize,"casual dress Size Drop Down box");
        click(Tshirts.addToCart,"Add To Cart");
        driver.switchTo().defaultContent();
    }

    @When("^View the basket and confirm that the items are of the size you selected, that their prices are correct, that Total Products is the sum of the two items and that ‘Total’ equals the Total Products \\+ Shipping$")
    public void view_the_basket_and_confirm_that_the_items_are_of_the_size_you_selected_that_their_prices_are_correct_that_Total_Products_is_the_sum_of_the_two_items_and_that_Total_equals_the_Total_Products_Shipping() throws Throwable {
        Thread.sleep(3000);
        click(Tshirts.proceedToCheckOut,"Procced to check out");
        int rowCount = tableCount(ShoppingCartSummary.tableCount);

        if(rowCount == 2){
            String itemOne_Size_SummaryCart = getText(ShoppingCartSummary.firstRowSize,"First row size in Shopping Cart Summary");
            dress = itemOne_Size_SummaryCart.substring(8,14);
            itemOne_Size_SummaryCart =itemOne_Size_SummaryCart.substring(23);
            String itemTwo_Size_SummaryCart = getText(ShoppingCartSummary.secondRowSize,"Second row size in Shopping Cart Summary");
            itemTwo_Size_SummaryCart =itemTwo_Size_SummaryCart.substring(23);
            String itemOne_Price_SummaryCart = getText(ShoppingCartSummary.firstRowPrice,"First Row Price in Shopping cart Summary");
            itemOne_Price_SummaryCart = itemOne_Price_SummaryCart.substring(1);
            String itemTwo_Price_SummaryCart = getText(ShoppingCartSummary.SecondRowPrice,"Second Row Price in Shopping cart Summary");
            itemTwo_Price_SummaryCart = itemTwo_Price_SummaryCart.substring(1);
            if(itemOne_Price.equalsIgnoreCase(itemOne_Price_SummaryCart)){
                if(itemOne_Size.equalsIgnoreCase(itemOne_Size_SummaryCart)){
                    if(itemTwo_Price.equalsIgnoreCase(itemTwo_Price_SummaryCart)){
                        if(itemTwo_Size.equalsIgnoreCase(itemTwo_Size_SummaryCart)){
                            String totalProducts = getText(ShoppingCartSummary.totalProducts,"Total Products");
                            totalProducts = totalProducts.substring(1);
                            String totalPrice = String.valueOf(Double.parseDouble(itemOne_Price) + Double.parseDouble(itemTwo_Price));
                            totalPrice = totalPrice.substring(0,5);
                            if(totalProducts.equalsIgnoreCase(totalPrice)){
                                String totalShipping = getText(ShoppingCartSummary.totalShipping,"Total Shipping");
                                totalShipping = totalShipping.substring(1);
                                String total = getText(ShoppingCartSummary.total,"Total");
                                total = total.substring(1);
                                String sum = String.valueOf(Double.parseDouble(totalShipping) + Double.parseDouble(totalProducts));
                                if(total.equalsIgnoreCase(sum)){

                                }
                                else{
                                    Assert.fail("Total is not equal to total products +totalShipping in the shopping cart summary.");
                                }
                            }
                            else{
                                Assert.fail("Total Price of 2 items is not matching to the total products in the shopping cart summary.");
                            }
                        }
                        else{
                            Assert.fail("Selected size for Item 2 is not matching in the shopping cart summary.");
                        }
                    }
                    else{
                        Assert.fail("Selected Price for Item 2 is not matching in the shopping cart summary.");
                    }
                }
                else{
                    Assert.fail("Selected size for Item 1 is not matching in the shopping cart summary.");
                }
            }
            else{
                Assert.fail("Selected Price for Item 1 is not matching in the shopping cart summary.");
            }

        }
    }

    @Then("^Proceed through checkout to payment \\(complete by wire\\)$")
    public void proceed_through_checkout_to_payment_complete_by_wire() throws Throwable {
        click(ShoppingCartSummary.proceedToSummary_ShoppingCartSummary,"Procced to Checkout in Shopping Cart Summary");
        click(Addresses.proceedToCheckOut_Addresses,"Procced to Checkout in Addresses");
        click(Shipping.termsOfService,"terms of service in shipping");
        click(Shipping.proceedToCheckOut_Shipping,"procced to checck out in shipping");
        click(Payment.payByWire,"pay by wire");
        click(Payment.confirmOrder,"ConfirmOrder");
    }


    @And("^Logout from automation practice$")
    public void logout_from_automation_practice() throws Throwable {
        click(HomePage.logout,"LogOut");
        close();
    }

}
