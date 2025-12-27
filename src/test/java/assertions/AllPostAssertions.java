package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminAllPost;


public class AllPostAssertions {
	
	WebDriver driver;
	WebDriverWait wait;
	AdminAllPost ad_all;
	
	//constructor to initialize driver
	public AllPostAssertions(WebDriver driver) {
		this.driver=driver;
		ad_all=new AdminAllPost(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Assert whether element present
	public boolean isallPostDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='All Posts']"))).isDisplayed();
}
}
