package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static String downloadDir = System.getProperty("user.dir") + "/downloads";

    private DriverFactory() {

    }

    public static WebDriver createDriver() {

        String onHub = System.getProperty("onHub", ConfigReader.getProperty("onHub"));
        String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));
        String hubUrl = System.getProperty("hubUrl", ConfigReader.getProperty("hubUrl"));


        ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
        //set the mode here
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);


        if(onHub.equals("true")){
            try{

                return new RemoteWebDriver(new URL(hubUrl), options);

            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid hub URL: " + hubUrl, e);
            }


        } else {
            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);

            } else   {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
        }



    }


}
