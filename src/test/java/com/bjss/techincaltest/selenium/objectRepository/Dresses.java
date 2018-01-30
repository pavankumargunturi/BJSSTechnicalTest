package com.bjss.techincaltest.selenium.objectRepository;

import org.openqa.selenium.By;

public class Dresses {

    public static By dresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a");
    public static By casualDresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");
    public static By image = By.xpath("//div[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
    public static By quickView = By.xpath("//div[@class='product-image-container']/a[2]");
}
