package com.bjss.techincaltest.selenium.objectRepository;

import org.openqa.selenium.By;

public class Payment {
    public static By payByWire = By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a");
    public static By confirmOrder = By.xpath("//p[@id='cart_navigation']/button");
}
