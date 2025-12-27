package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAllPost {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Set constructor
	public AdminAllPost(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// navigate to allpost page
	public void allPosts() {
		WebElement vPost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav' and text()='All posts']")));
		vPost.click();
		
	}
	
    public void clickEdit() {
		
		//For executing scroll function
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement edt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='Edit'])[1]")));
	    js.executeScript("arguments[0].scrollIntoView(true);", edt); // Scroll the page until the Edit button comes into view
	    js.executeScript("arguments[0].click();", edt);
	    
	    WebElement subtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
	    subtn.click();
	    wait.until(ExpectedConditions.alertIsPresent()); //to click the popup message
	    driver.switchTo().alert().accept();
	}
    
    public void clkDelete() {
    	
    	WebElement vPost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav' and text()='All posts']")));
		vPost.click();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement delt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='Delete'])[1]")));
	    js.executeScript("arguments[0].scrollIntoView(true);", delt); // Scroll the page until the delete button comes into view
	    js.executeScript("arguments[0].click();", delt);
	    
    	
    }

}
