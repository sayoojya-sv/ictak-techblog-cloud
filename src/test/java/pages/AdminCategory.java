package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCategory {
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminCategory(WebDriver driver) {
		this.driver=driver;
		wait =new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	//to navigate to category page
	public void cate_gory() {
	    WebElement viewCat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Categories']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",viewCat);
	}

	//view and select category
	public void selCat() {
	    WebElement sel_cat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='DEMO']")));
	    sel_cat.click();
	    //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",sel_cat);
	    
	    //to select readmore function
//	    WebElement readMore=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//small[text()='Read more'])[3]")));
//	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click;" ,readMore);
	}

}
