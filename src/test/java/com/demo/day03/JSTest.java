package com.demo.day03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exJS() throws InterruptedException {

        driver.get("https://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(5000);

    }

    @After
    public void closedBrowser(){
        driver.quit();

    }
}
