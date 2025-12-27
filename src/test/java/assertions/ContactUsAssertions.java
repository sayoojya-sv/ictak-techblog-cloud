package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminContactUs;

public class ContactUsAssertions {
	
	WebDriver driver;
	WebDriverWait wait;
	AdminContactUs admContact;
	
	public ContactUsAssertions(WebDriver driver) {
		this.driver=driver;
		admContact=new AdminContactUs(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	//To check whether navigated to ContactUs page
		public boolean isContactUsDisplayed() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Contact us']"))).isDisplayed();
	}

}
