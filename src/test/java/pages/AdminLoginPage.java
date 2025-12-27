package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	public void dropDown() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement drpDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='navbarDropdown' and contains(@class,'dropdown-toggle')]")));
		drpDown.click();
		WebElement log = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='drop' and text()='Login']")));
		log.click();
	}
	
	public void loginEmail(String e_mail) {
		WebElement eMail=driver.findElement(By.id("user"));
		eMail.clear();
		eMail.sendKeys(e_mail);
	}
	public void loginPass(String passWord) {
		WebElement passw=driver.findElement(By.id("pwd"));
		passw.clear();
		passw.sendKeys(passWord);
//			 driver.findElement(By.id("user")).sendKeys(e_mail);
//			 driver.findElement(By.id("pwd")).sendKeys(passWord);
		}
	
	public void subBtn() {
		WebElement lognBtn=driver.findElement(By.id("logbut"));
		lognBtn.click();
	}
	    
	    public String getAlertText() {
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String msg = alert.getText();
	        alert.accept();
	        return msg;
	    }

}