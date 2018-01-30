package com.bjss.techincaltest.selenium.stepDefinitions;

import com.bjss.techincaltest.selenium.genericFunctions.SeleniumCommands;
import com.bjss.techincaltest.selenium.objectRepository.HomePage;
import com.bjss.techincaltest.selenium.objectRepository.MyAccount;
import com.bjss.techincaltest.selenium.objectRepository.OrderHistory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test2_StepDefinitions extends SeleniumCommands {

    @And("^View previous orders$")
    public void view_previous_orders() throws Throwable {
        click(MyAccount.orderHistoryAndDetails,"OrderHistoryAndDetails");

    }

    @When("^Select an item from your previous order \\(there will be others – confirm this by date/time\\) and add a comment$")
    public void select_an_item_from_your_previous_order_there_will_be_others_confirm_this_by_date_time_and_add_a_comment() throws Throwable {
        click(OrderHistory.orderReference,"Order Reference");
        String s = selectByVisibleText(OrderHistory.dropDown,"Printed Dress - Color : Orange, Size : S","Drop Down box");
        System.out.println(s);
        sendText(OrderHistory.comment,"Technicaltest","Comment");
        click(OrderHistory.send,"Send");
    }

    @Then("^Confirm that the comment appears under ‘messages’$")
    public void confirm_that_the_comment_appears_under_messages() throws Throwable {
       String comment = getText(OrderHistory.message,"Message");
       if(comment.equalsIgnoreCase("Technicaltest")){
       }
       else{
           Assert.fail("The comment appears under message is wrong");
       }
       click(HomePage.logout,"Logout");
       close();
    }
}
