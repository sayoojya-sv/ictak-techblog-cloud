package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static void capture(WebDriver driver, String testName) throws IOException  {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\sayoojya\\OneDrive\\Desktop\\dockerictaktech\\dockerictak\\target\\screenshots" + testName + ".png");
        FileUtils.copyFile(src, dest);
    }

}