package com.bjss.techincaltest.selenium.objectRepository;

import org.openqa.selenium.By;

public class OrderHistory {
    public static By orderReference = By.xpath("//table[@id='order-list']/tbody/tr[1]/td[1]/a");
    public static By comment = By.xpath("//form[@id='sendOrderMessage']/p[3]/textarea");
    public static By dropDown = By.xpath("//form[@id='sendOrderMessage']/p[2]/select");
    public static By send = By.xpath("//form[@id='sendOrderMessage']/div/button");
    public static By message = By.xpath("//div[@id='block-order-detail']/div[5]/table/tbody/tr/td[2]");
    public static By product = By.xpath("//div[@id='order-detail-content']/table/tbody/tr[2]/td[2]/label");
}
