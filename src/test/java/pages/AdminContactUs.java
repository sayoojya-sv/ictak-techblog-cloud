package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminContactUs {
	WebDriver driver;
	WebDriverWait wait;
	
	//create constructor
	public AdminContactUs(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	}
	
	//to navigate to contact-us page
	public void clk_contact() {
	    By contactUs = By.xpath("//a[@id='nav' and contains(text(),'Contact us')]");
	    WebElement contactLink = wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", contactLink);
	}

	
	//to send message with name email and message
	public void inp_value(String eName, String eMail, String msg) {

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    WebElement ename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
	    js.executeScript("arguments[0].value=arguments[1];", ename, eName);

	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	    js.executeScript("arguments[0].value=arguments[1];", email, eMail);

	    WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("message")));
	    js.executeScript("arguments[0].value=arguments[1];", message, msg);
	}

	
	public void sndBtn() {
		WebElement sendBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='SEND']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", sendBtn); // scroll into view

		js.executeScript("arguments[0].click();", sendBtn); // click using JS

	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}

	
	public void clickIcon() {
		WebElement git_icon=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='contact-icon']")));
		git_icon.click();
	}

}

