package com.demo.day01;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WindowSelectTest {
    WebDriver driver;
    @Before
    public void openIeOrChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.ie.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
    }

    @Test
    public void testWin() throws InterruptedException {

        driver.get("Z:\\HTY\\workspace\\Selenium\\src\\main\\resources\\index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1))
                continue;
            driver.switchTo().window(handles);
        }
        driver.findElement(By.linkText("baidu")).click();
    }
    @Test
    public void waitTest() throws InterruptedException {

        driver.get("https://mail.qq.com/");
        driver.findElement(By.xpath("//*[@id=\"qqLoginTab\"]")).click();
//        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"u\"]")).sendKeys("123215653");

        //*[@id="u"]

    }

    @Test
    public void IfraTest() throws InterruptedException {
        driver.get("https://mail.qq.com/");
        driver.switchTo().frame("login_frame");
//        driver.findElement(By.linkText("QQ登录")).click();
        driver.findElement(By.id("u")).sendKeys("2322876176");
        driver.findElement(By.id("p")).sendKeys("zyf19960818");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(3000);


    }
    @After
    public void closedBrowser(){


    }
}
