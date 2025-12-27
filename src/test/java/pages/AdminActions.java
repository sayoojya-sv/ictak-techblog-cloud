package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminActions {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AdminActions(WebDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void approvePost(String ap_cmnt) {
		
		
		WebElement act=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[p[text()=' Actions']]")));
		act.click();
		WebElement pendApp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pending Approvals']")));
		pendApp.click();
		
//		WebElement appr=driver.findElement(By.xpath("(//button[text()='Approve'])[1]"));
//		appr.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement appr = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='Approve'])[1]")));
	    js.executeScript("arguments[0].scrollIntoView(true);", appr); // Scroll the page until the Edit button comes into view
	    js.executeScript("arguments[0].click();", appr);
		
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    
		WebElement appr_cmt=driver.findElement(By.xpath("//textarea[@name='p_post']"));
		appr_cmt.sendKeys(ap_cmnt);
		
		WebElement snd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));

		JavascriptExecutor js_t = (JavascriptExecutor) driver; // Initialize JavascriptExecutor
		js.executeScript("arguments[0].scrollIntoView(true);", snd); // Scroll down to view element

		js.executeScript("arguments[0].click();", snd);

		wait.until(ExpectedConditions.alertIsPresent()); // to accept popup messages
		driver.switchTo().alert().accept();


	}

	public void rejPost(String re_cmnt) {
		
		WebElement act=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[p[text()=' Actions']]")));
		act.click();
		WebElement pendApp=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Pending Approvals']")));
		pendApp.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement rej = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='Reject'])[1]")));
	    js.executeScript("arguments[0].scrollIntoView(true);", rej); // Scroll the page until the Edit button comes into view
	    js.executeScript("arguments[0].click();", rej);
		
//		WebElement rej=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Reject'])[1]")));
//		rej.click();
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    
	    WebElement rej_cmt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='p_post']")));
	    rej_cmt.sendKeys(re_cmnt);
	    
	     WebElement rej_snd=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit' and text()='send']")));
		 JavascriptExecutor jst = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", rej_snd);
		 
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    
	}
	
	public void addCat(String addC) {
		
		WebElement act=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[p[text()=' Actions']]")));
		act.click();
		
		WebElement add=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='drop' and text()='Add/Remove category']")));
		add.click();
		
		WebElement addCat=driver.findElement(By.xpath("//input[@name='category']"));
		addCat.sendKeys(addC);
		
		WebElement ad=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bt' and text()='Add']")));
		ad.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
		
	}
	
	public void remCat() {
		WebElement act=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[p[text()=' Actions']]")));
		act.click();
		
		WebElement add=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='drop' and text()='Add/Remove category']")));
		add.click();
		
	    WebElement rem=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[contains(text(),'LIVEDEM')]//button[text()='Remove'])[1]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", rem);
		 
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
		
	}

	
	public void newPost(String tiTle, String imgUrl, String posT) {

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Actions']")));
	    js.executeScript("document.evaluate(\"//p[normalize-space()='Actions']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='New post']")));
	    js.executeScript("document.evaluate(\"//a[normalize-space()='New post']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");

	    WebElement ttle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleInputEmail1")));
	    ttle.sendKeys(tiTle);

	    WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("P_image")));
	    img.sendKeys(imgUrl);

	    WebElement dropCat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("p_cat")));
	    new Select(dropCat).selectByVisibleText("DEMO");

	    WebElement pst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("p_post")));
	    pst.sendKeys(posT);

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Submit']")));
	    js.executeScript("document.evaluate(\"//button[normalize-space()='Submit']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");

	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}

	}
