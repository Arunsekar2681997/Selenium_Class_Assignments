package week6.day1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SalesForce extends BaseClass {
	
	@Test
	public void newEntityCreation() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		//click toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		//click View All option
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		//click Legal Entities
		WebElement findValue = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions act = new Actions(driver);
		act.scrollToElement(findValue).perform();
		findValue.click();
		//Click on New Legal Entity
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Enter Legal entity name
		driver.findElement(By.xpath("(//div[@part='input-container']//input)[2]")).sendKeys("ArunSekar Test");
		//Enter the company name
		driver.findElement(By.xpath("(//div[@part='input-container']//input)[3]")).sendKeys("TestLeaf");
		//Enter description value
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		//select status value
		Thread.sleep(3000);
		WebElement findDropDown = driver.findElement(By.xpath("(//span[text()='--None--'])"));
		act.scrollToElement(findDropDown).perform();
		driver.executeScript("arguments[0].click();", findDropDown);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		//click save button
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
		//Verify the Alert message (Complete this field) displayed for Name
		WebElement getSuccessMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		WebElement getLegalName = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]/div"));
		String legalName = getLegalName.getText();
		System.out.println("Name Is : "+legalName);
		String successMessage = getSuccessMessage.getText();
		if(successMessage.contains("was created"))
		{
			System.out.println("New Legal Entity Is Created SuccessFully");
		}
		else
		{
			System.out.println("New Legal Entity Is Not Created");
		}	
	}

}
