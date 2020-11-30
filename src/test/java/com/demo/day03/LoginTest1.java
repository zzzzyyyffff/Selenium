package com.demo.day03;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest1 {
    WebDriver driver;
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.100.24:4445/wd/hub"),dc);
        driver.get("https://mail.163.com");
        Thread.sleep(3000);
        driver.quit();
    }
    @DataProvider(name = "userlist")
    public Object[][] test1(){
        return  new Object[][] {
                {"user1","123456789"},
                {"user2","sfdsf"}};
        }

    @Test(dataProvider = "userlist")
    public void loginSuccess(String username,String pwd) throws InterruptedException {

        LoginTest1.login(driver,username,pwd);
        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
//        String  logout = driver.findElement(By.linkText("退出")).getText();
//        Assert.assertEquals(logout,"退出");
    }

    private static void login(WebDriver driver, String username, String pwd) {
        driver.get("https://mail.qq.com/");
        driver.switchTo().frame("login_frame");

        driver.findElement(By.id("u")).sendKeys("2322876176");
        driver.findElement(By.id("p")).sendKeys("zyf19960818");
        driver.findElement(By.id("login_button")).click();
//        Thread.sleep(3000);
    }




}
