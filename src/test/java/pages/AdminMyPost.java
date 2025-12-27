package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminMyPost {
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminMyPost(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void myPostclk() {
	    WebElement myPost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='My posts']")));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", myPost);
	    js.executeScript("arguments[0].click();", myPost);
	}

}
