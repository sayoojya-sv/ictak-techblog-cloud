package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAboutUs {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminAboutUs(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//to navigate to about us page
	public void ab_out() {
		WebElement abt_clk=driver.findElement(By.xpath("//a[@id='nav' and text()='About us']"));
		abt_clk.click();
		
	}
	
	//to check if it is navigated to aboutus page
	public boolean isAboutUsDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='ABOUT US']"))).isDisplayed();
}

	

}
