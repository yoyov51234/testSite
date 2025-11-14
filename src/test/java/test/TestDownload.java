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

        // 创建下载目录
        File dir = new File(downloadDir);
        if (!dir.exists()) dir.mkdirs();

        File targetFile = new File(downloadDir + "/info.txt");

        driver.findElement(By.xpath("//button[@id='createTxt']")).click();
        driver.findElement(By.xpath("//a[@id='link-to-download']")).click();

        targetFile = new File(System.getProperty("user.dir") + "/downloads/info.txt");

        // 等待文件下载完成
        int timeout = 10; // seconds
        int waited = 0;
        while (!targetFile.exists() && waited < timeout) {
            Thread.sleep(1000);
            waited++;
        }

        if (!targetFile.exists()) {
            throw new RuntimeException("Download failed: info.txt not found in " + targetFile.getAbsolutePath());

        }
        String s = FileUtils.readFileToString(targetFile, "UTF-8");
        Assert.assertEquals(s,"nihao");


    }

  

}
