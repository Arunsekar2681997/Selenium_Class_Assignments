package Maraton2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class MobileOrder {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Launch ServiceNow application
		driver.get("https://dev273042.service-now.com/");
		
		//2. Login with valid credentials username as admin and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("*w6ndQP4vI$G");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(30);
		sh.findElementByXPath("//div[text()='All']").click();
		sh.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//Switch to frame
		WebElement findFrame = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(findFrame);
		
		//4. Click on  mobiles
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		Thread.sleep(3000);
		
		//5. Select Apple iphone13pro
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		
		Thread.sleep(3000);
		
		//6. Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		
		Thread.sleep(7000);
		Actions act = new Actions(driver);
		//7. Enter phonenumber as 99 in original phonenumber field
		WebElement findPhoneNumber = driver.findElement(By.xpath("(//input[contains(@class,'form-control')])[2]"));
		act.scrollToElement(findPhoneNumber).perform();
		findPhoneNumber.sendKeys("9876543210");
		
		Thread.sleep(3000);
		
		//8. Select Unlimited from the dropdown in Monthly data allowance
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='IO:ff1f478e9747011021983d1e6253af68']"));
		Select sel = new Select(dropdown);
		sel.selectByValue("unlimited");

		Thread.sleep(3000);
		
		//9. Update color field to Gold and storage field to 512GB
		WebElement selectColor = driver.findElement(By.xpath("//label[text()='Gold']"));
		act.scrollToElement(selectColor).perform();
		selectColor.click();
		Thread.sleep(3000);
		WebElement selectStorage = driver.findElement(By.xpath("//label[contains(text(),'512')]"));
		act.scrollToElement(selectStorage).perform();
		selectStorage.click();
		
		Thread.sleep(3000);
		
		//10. Click on Order now option
		WebElement findOrderNow = driver.findElement(By.id("oi_order_now_button"));
		act.scrollToElement(findOrderNow).perform();
		findOrderNow.click();
		
		Thread.sleep(3000);

		
		WebElement getMessage = driver.findElement(By.xpath("//span[contains(text(),'submitted')]"));
		String getSuccessMessage = getMessage.getText();
		if (getSuccessMessage.contains("submitted")) {
			System.out.println("Your Order Is Placed & The Confirmation Message Below As:");
			System.out.println(getSuccessMessage);	
		} else {
			System.out.println("Sorry!Your Order Is Not Placed Due To Technical Reason , Please Try After Some Time");
		}
		
		WebElement getRequest = driver.findElement(By.xpath("//a[@id='requesturl']/b"));
		String requestNumber = getRequest.getText();
		System.out.println("Your Order Request Number Is : "+requestNumber);
	}	

}
