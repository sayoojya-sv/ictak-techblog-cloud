package assertions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdminLoginPage;

public class LoginAssertions {
	
	WebDriver driver;
	WebDriverWait wait;
	AdminLoginPage admlog;
	
	public LoginAssertions(WebDriver driver) {
		this.driver=driver;
		this.admlog=new AdminLoginPage(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//To check whether logged inside HomePage
	public boolean isAdminHomePageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'logout')]"))).isDisplayed();
}
	public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String msg = alert.getText();
        alert.accept();
        return msg;
    }
	
	
	public boolean isemptyPassDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[text()='This field required'])[2]"))).isDisplayed();
		
	}
	
	public boolean isemptymessagedisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//small[text()='This field required'])[1]"))).isDisplayed();
	}
	

}
