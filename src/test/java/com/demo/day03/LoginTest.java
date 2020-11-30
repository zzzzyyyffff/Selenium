package com.demo.day03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    public static void login(WebDriver driver, String username, String pwd) {

    }

    @Before

    public void openIeOrChorme(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.setProperty("webdriver.ie.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://mail.qq.com/");
    }
//    @Test
//    public void loginSucess(){
//        driver.findElement(By.id("qqLoginTab")).click();
//
////        driver.findElement(By.id("u"));
////        driver.findElement(By.name("u"));
////        driver.findElement(By.id("dologin")).click();
////
////        WebDriverWait wait = new WebDriverWait(driver,20);
////        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
////        String  logout = driver.findElement(By.linkText("退出")).getText();
////        Assert.assertEquals(logout,"退出");
//
//    }
    @Test
    public void SuccessQQTest() throws InterruptedException {
//        driver.get("https://mail.qq.com/");
//        driver.switchTo().frame("login_frame");
//        driver.findElement(By.linkText("QQ登录")).click();
//        driver.findElement(By.id("u")).sendKeys("2322876176");
//        driver.findElement(By.id("p")).sendKeys("zyf19960818");
//        driver.findElement(By.id("login_button")).click();
//        Thread.sleep(5000);
        LoginTest.loginQQ(driver,"2322876176","zyf19960818");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String  logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");


    }
    @Test
    public void Success163Test() throws InterruptedException {
//        driver.get("https://mail.qq.com/");
//        driver.switchTo().frame("login_frame");
//        driver.findElement(By.linkText("QQ登录")).click();
//        driver.findElement(By.id("u")).sendKeys("2322876176");
//        driver.findElement(By.id("p")).sendKeys("zyf19960818");
//        driver.findElement(By.id("login_button")).click();
//        Thread.sleep(5000);
        LoginTest.login163(driver,"meyoungtester","meyoung123");
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
//        String  logout = driver.findElement(By.linkText("退出")).getText();
//        Assert.assertEquals(logout,"退出");


    }

    private static void loginQQ(WebDriver driver,String email,String pwd) throws InterruptedException {
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("meyoungtester");
//        driver.findElement(By.name("password")).sendKeys("meyoung123");
//        driver.findElement(By.id("dologin")).click();
        driver.get("https://mail.qq.com/");
        driver.switchTo().frame("login_frame");
//        driver.findElement(By.linkText("QQ登录")).click();
        driver.findElement(By.id("u")).sendKeys("2322876176");
        driver.findElement(By.id("p")).sendKeys("zyf19960818");
        driver.findElement(By.id("login_button")).click();
//        Thread.sleep(3000);
    }
    static void login163(WebDriver driver, String email, String pwd) throws InterruptedException {
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("meyoungtester");
//        driver.findElement(By.name("password")).sendKeys("meyoung123");
//        driver.findElement(By.id("dologin")).click();


        WebElement webElement = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(webElement);
//        driver.findElement(By.linkText("QQ登录")).click();
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung123");
        driver.findElement(By.id("dologin")).click();
//        Thread.sleep(3000);
    }

    @Test
    public void loginError() throws InterruptedException {
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("meyoungtester");
//        driver.findElement(By.name("password")).sendKeys("meyoung123");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.loginQQ(driver,"2322876176","zyf19960818");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[id=\"nerror\"]/div[2]")));
        String error = driver.findElement(By.xpath("//*[id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"账号或密码错误");

    }
//    public void logon(WebDriver driver,String email,String pwd) {
//
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("meyoungtester");
//        driver.findElement(By.name("password")).sendKeys("meyoung123");
//        driver.findElement(By.id("dologin")).click();
//    }
}
