package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class ScreenshotListener implements ITestListener {


    public void onTestFailure(ITestResult result) {

        String screenshotPath = ScreenshotUtil.takeScreenShot(result.getMethod().getMethodName());
        System.out.println("📸 Screenshot saved at: " + screenshotPath);


    }

}
