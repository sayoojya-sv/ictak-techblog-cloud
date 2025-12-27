package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminHomePage;

public class HomeAssertions {
	WebDriver driver;
	WebDriverWait wait;
	AdminHomePage ad_home;
	
	//constructor to initialize driver
	public HomeAssertions(WebDriver driver) {
		this.driver=driver;
		ad_home=new AdminHomePage(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Assert whether element present
	public boolean isHomePageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='WELCOME TO ICTAK TECH BLOG']"))).isDisplayed();
    }
	
	public boolean isdeletemsgDisplayed() {
		return driver.findElement(By.name("post deleted")).isDisplayed();
	}

}
