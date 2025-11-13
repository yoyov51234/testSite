package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public  static String takeScreenShot(String testName) {
        WebDriver driver = MDriverManager.getDriver();
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/"
                + testName + "_" + System.currentTimeMillis() + ".png";
        File dest = new File(path);
        dest.getParentFile().mkdirs();// 如果目录不存在则创建

        try {

            FileUtils.copyFile(screenshotAs,dest );

        } catch (IOException e){
            e.printStackTrace();
        }

        return path;

    }
}
