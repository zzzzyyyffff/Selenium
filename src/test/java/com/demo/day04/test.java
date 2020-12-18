package com.demo.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {
    @Test
    public void getTexts() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("Z:\\HTY\\workspace\\Selenium\\src\\main\\resources\\test.html");
        String keyword = "1594";
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr[td[text()=" + keyword + "]]//input")).click();
    }
}
