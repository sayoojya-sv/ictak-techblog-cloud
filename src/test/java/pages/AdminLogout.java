package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLogout {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminLogout(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	//loggin out
	public void logOut() {

	    WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='logout']")));
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", log); // Scroll until logout is visible

	    wait.until(ExpectedConditions.elementToBeClickable(log));

	    js.executeScript("arguments[0].click();", log); // Scroll until logout is visible
	}


}
