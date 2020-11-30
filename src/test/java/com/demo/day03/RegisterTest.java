package com.demo.day03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    @Test
    public void register(){


        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.className("f-float-left")).click();
        String handle1=driver.getWindowHandle();
        for (String handles :driver.getWindowHandles()) {
            if(handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("username")).sendKeys("emain"+time);
        driver.findElement(By.id("password")).sendKeys("123213123");
        driver.findElement(By.id("phone")).sendKeys("123215653");
        driver.findElement(By.className("j-register")).click();

//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath()));
    }
        @After
        public void closedBrowser(){


        }
}
