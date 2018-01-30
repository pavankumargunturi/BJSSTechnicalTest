package com.bjss.techincaltest.selenium.objectRepository;

import org.openqa.selenium.By;

public class ShoppingCartSummary {
    public static By tableCount = By.xpath("//table[@id='cart_summary']/tbody/tr");
    public static By firstRowSize = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td/small[2]/a");
    public static By secondRowSize = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td/small[2]/a");
    public static By firstRowPrice = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[4]/span/span");
    public static By SecondRowPrice = By.xpath("//table[@id='cart_summary']/tbody/tr[2]/td[4]/span/span");
    public static By totalProducts = By.xpath("//table[@id='cart_summary']/tfoot/tr[1]/td[3]");
    public static By totalShipping = By.id("total_shipping");
    public static By total = By.id("total_price_without_tax");
    public static By proceedToSummary_ShoppingCartSummary = By.xpath("//div[@id='center_column']/p[2]/a[1]/span");
}
