package com.bjss.techincaltest.selenium.objectRepository;

import org.openqa.selenium.By;

public class Tshirts {

    public static By tShirts = By.xpath("//div[@id='block_top_menu']/ul/li[3]/a");
    public static By tShirtsQuickView = By.xpath("//div[@id='center_column']/ul/li/div/div[1]/div/a[2]/span");
    public static By image = By.xpath("//div[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
    public static By price = By.id("our_price_display");
    public static By tShirtsSize = By.id("group_1");
    public static By addToCart = By.xpath("//p[@id='add_to_cart']/button");
    public static By continueShopping = By.xpath("//div[@class='button-container']/span/span");
    public static By proceedToCheckOut = By.partialLinkText("Proceed to checkout");
}
