package base;

import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.MDriverManager;


@Listeners({ScreenshotListener.class})
public class BaseTest {

    @BeforeMethod
    public void setup()
    {
        MDriverManager.getDriver();


    }
    @AfterMethod
    public void teardown()
    {
        MDriverManager.quitDriver();
    }

}
