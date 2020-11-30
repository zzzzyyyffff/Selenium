package com.demo.day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class upLoadTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void uploadTest() throws InterruptedException {

        driver.get("Z:\\HTY\\workspace\\Selenium\\src\\main\\resources\\index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\菊.jpg");

        Thread.sleep(5000);

    }

    @After
    public void closedBrowser(){
        driver.quit();

    }
}
