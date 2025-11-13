package utils;

import org.openqa.selenium.WebDriver;

public class MDriverManager {

    private  final static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private MDriverManager() {
        // 防止被 new
    }

    public static WebDriver getDriver(){
        if(driver.get() == null){
            WebDriver driver1 = DriverFactory.createDriver();
            driver.set(driver1);
        }
        return driver.get();
    }

    public static void quitDriver(){

        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }

    }

}
