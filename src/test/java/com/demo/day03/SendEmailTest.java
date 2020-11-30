package com.demo.day03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class SendEmailTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
//    @DataProvider(name = "data1")
//    public Object[][] testS(){
//        return  new Object[][];
//        }
//    @org.testng.annotations.Test(dataProvider = "data1")
//    public void sendEmailTestCase() {
//        LoginTest.login(driver,"user","pwd");
//        SendEmailTest.sendEmail("title","fujian","wenjian");
//        Assert.assertEquals(1,1);
//
//
//
//    }
//
//    private static void sendEmail(String title, String fujian, String wenjian) {
//    }
//

    @Test
    public void sendEmail() throws InterruptedException {
        LoginTest.login163(driver,"meyoungtester","meyoung123");
        Thread.sleep(10000);
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();

        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("meyoungtester@163.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys(
                "这个是主题");
        Thread.sleep(3000);

//        driver.findElement(By.xpath(".//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).
//                sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\菊.jpg");
//        定位iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("这个是内容");
//        driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送']")).isDisplayed();
        Assert.assertTrue(bl);


    }


    @After
    public void closedBrowser(){

    }

}
