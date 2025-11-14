package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.MDriverManager;

public class TestUpload extends BaseTest {
    @Test
    public void testUpload() throws  Exception {
        WebDriver driver = MDriverManager.getDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        String filePath = System.getProperty("user.dir")+"/src/test/resources/fileToUpload.json";
        driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys(filePath);


    }



}
