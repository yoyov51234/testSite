package test;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MDriverManager;

import java.io.File;

import static utils.DriverFactory.downloadDir;

public class TestDownload extends BaseTest {
    @Test
    public void testDownload() throws  Exception {
        WebDriver driver = MDriverManager.getDriver();
        driver.get("https://demo.automationtesting.in/FileDownload.html");
        driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("nihao");

        File file = new File(downloadDir);
        if (!file.exists()) file.delete();
        driver.findElement(By.xpath("//button[@id='createTxt']")).click();
        driver.findElement(By.xpath("//a[@id='link-to-download']")).click();

        file = new File(System.getProperty("user.dir") + "/downloads/info.txt");
        String s = FileUtils.readFileToString(file, "UTF-8");
        Assert.assertEquals(s,"nihao");


    }

  

}
