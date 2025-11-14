package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.MDriverManager;
import utils.UploadFileHelper;

import java.io.File;

public class TestUpload extends BaseTest {
    @Test
    public void testUpload() throws  Exception {
        WebDriver driver = MDriverManager.getDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        String filePath = UploadFileHelper.resolveUploadPath("fileToUpload.json");
        driver.findElement(By.xpath("//input[@id='imagesrc']")).sendKeys(filePath);

    }



}
