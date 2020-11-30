package com.demo.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","Z:\\HTY\\workspace\\Selenium\\drivers\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
