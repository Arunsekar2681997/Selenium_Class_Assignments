package Maraton3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIndividuals extends BaseClass{
/*
 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Dropdown icon in the Individuals tab
5. Click on New Individual
6. Enter the Last Name as 'Kumar'
7.Click save and verify Individuals Name"

 */
	@BeforeTest
	public void setData()
	{
		dataFile = "Create_Individuals";
	}
	
	@Test(dataProvider = "fetchData",groups = "createIndividuals")
	public void createIndividuals(String lastName) throws InterruptedException {
	

	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(3000);
	WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
	driver.executeScript("arguments[0].scrollIntoView();", scroll);
	WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
	driver.executeScript("arguments[0].click();", individual);
	
	driver.findElement(By.xpath("//div[text()='New']")).click();

	driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lastName);
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	//verify Individuals Name

}
}