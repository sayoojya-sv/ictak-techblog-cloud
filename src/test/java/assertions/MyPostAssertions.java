package assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminMyPost;

public class MyPostAssertions {
	
	WebDriver driver;
	WebDriverWait wait;
	AdminMyPost ad_mypst;
	
	//constructor to initialize driver
	public MyPostAssertions(WebDriver driver) {
		this.driver=driver;
		ad_mypst=new AdminMyPost(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Assert whether element present
	public boolean isMyPostDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='By admin '][1]"))).isDisplayed();
}

}
