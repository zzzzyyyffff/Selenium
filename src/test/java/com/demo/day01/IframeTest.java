package com.demo.day01;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class IframeTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void IframeTest() throws InterruptedException {
        driver.get("file:///C:/Users/xunhe/Desktop/Ceshi.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");

    }
    @After
    public void closedBrowser() throws InterruptedException {

        driver.quit();

    }
}
