package com.demo.day03;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.100.24:4445/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
    @DataProvider(name = "data4")
    public Object[][] test1(){
        return  new Object[][] {
                {"firefox","http://192.168.100.24:8888"},
                {"chrome","http://192.168.100.24:5556"}};
        }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser,String url) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser == "firefox") {
            dc = DesiredCapabilities.firefox();
        }else if (browser == "chrome"){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        Thread.sleep(3000);
        driver.quit();

    }
    @Test(dataProvider = "data4")
    public void testGrid3(String browser,String url) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser == "firefox") {
            dc = DesiredCapabilities.firefox();
        }else if (browser == "chrome"){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        Thread.sleep(3000);
        driver.quit();

    }


}
