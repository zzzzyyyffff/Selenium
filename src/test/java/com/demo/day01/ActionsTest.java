package com.demo.day01;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ActionsTest {
    WebDriver driver;
    @Before
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","Z:\\HTY\\workspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void clickTest() {

        driver.get("https://www.baidu.com");
        WebElement newslink = driver.findElement(By.name("tj_settingicon"));
        newslink.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://news.baidu.com/",url);
    }

    @Test
    public void sendkeysTest() throws InterruptedException {

        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
//        WebElement baiduButton = driver.findElement(By.id("su"));
//        baiduButton.click();
//        Thread.sleep(3000);
//        String title = driver.getTitle();
//        Assert.assertEquals("selenium_百度搜索",title);
        Thread.sleep(3000);
        keys.clear();
        Thread.sleep(3000);
    }

    @Test
    public void sendTest() {

        driver.get("https://www.baidu.com");
        List<WebElement> listText = driver.findElements(By.xpath("//*[@id=\"s-top-left\"]"));
        for (int i=0;i < listText.size();i++){
            String text = listText.get(1).getText();
            System.out.println(text);
        }
//        WebElement keys = driver.findElement(By.id("kw"));
//        keys.sendKeys("selenium");
//        WebElement baiduButton = driver.findElement(By.id("su"));
//        baiduButton.click();
//        Thread.sleep(3000);
//        String title = driver.getTitle();
//        Assert.assertEquals("selenium_百度搜索",title);
//        String text1 = keys.getText();
//        keys.clear();
//        String text2=keys.getText();
//
//        Assert.assertEquals("selenium",text1);
//        Assert.assertEquals("",text2);
    }

    @Test
    public void isDisplayedTest() {

        driver.get("https://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }
    @Test
    public void isEnabledTest() {

        driver.get("file:///C:/Users/xunhe/Desktop/Ceshi.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }
    @Test
    public void isSelected() {

        driver.get("file:///C:/Users/xunhe/Desktop/Ceshi.html");
        WebElement element = driver.findElement(By.xpath("buttonhtml"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    @Test
    public void shotTest() {
        driver.get("https://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("C:\\Users\\xunhe\\Desktop\\test.jpg"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Test
    public void doubleClickTest() {
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));

        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();

    }
    @Test
    public void saveHtml() throws AWTException, InterruptedException {


        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int)new Character('A');
        System.out.println(keyS);
        robot.keyPress(87);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);








    }
    @After
    public void closedBrowser(){
        driver.quit();

    }
}
