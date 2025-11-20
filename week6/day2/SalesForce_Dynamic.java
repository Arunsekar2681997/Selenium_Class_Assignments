package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForce_Dynamic extends BaseClass{
	
	@Test(dataProvider = "fetchdata")
	public void createLegal(String legalEntityName) throws InterruptedException {
		
		
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
		driver.findElement(By.xpath("(//div[@part='input-container']//input)[2]")).sendKeys("Salesforce Automation by "+legalEntityName);
		
		//click save button
		driver.findElement(By.xpath("//button[text()='Save']")).click();
			
		WebElement getLegalName = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]/div"));
		String legalName = getLegalName.getText();
		System.out.println("Name Is : "+legalName);
		
		
		

	}
	
	@DataProvider(name="fetchdata")
	public String[][] setData()
	{
		String[][] data = new String[2][1];
		
		data[0][0]="ArunSekar";
		
		data[1][0] ="AS";
		
		
		return data;
	}

}
