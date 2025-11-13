package test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MDriverManager;

public class TestLogin extends BaseTest {
    Logger logger = LoggerFactory.getLogger(TestLogin.class);

    @Test
    public void testLogin() {
        logger.info("test login");
        WebDriver driver = MDriverManager.getDriver();
        driver.get("https://practice.automationtesting.in/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Practice Site");
        logger.info("test login successful");
    }


    @Test
    public void testLoginFail() {

        logger.info("test login failed");
        WebDriver driver = MDriverManager.getDriver();
//        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Practice Site1");
    }

}
