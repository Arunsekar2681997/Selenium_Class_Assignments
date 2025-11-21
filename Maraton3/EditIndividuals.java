package Maraton3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditIndividuals extends BaseClass {
	
	@BeforeTest
	public void setData()
	{
		dataFile = "Edit_Individuals";
	}
	
	@Test(dataProvider = "fetchData",groups = "editIndividuals",dependsOnGroups ="createIndividuals")
	public void editIndividuals(String searchName,String salutation,String firstName) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher 
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Edit
7.Select Salutation as 'Mr'
8.Enter the first name as 'Ganesh'.
9. Click on Save and Verify the first name as 'Ganesh'"

		 */

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
//		WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
//		driver.executeScript("arguments[0].click();", clk);
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(searchName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		//.sendKeys("Kumars",Keys.ENTER);

		WebElement clickDropdown = driver.findElement(By.xpath("(//*[local-name()='svg' and @data-key='down'])[5]"));
		clickDropdown.click();
//		WebElement ele = driver.findElement(By.xpath("//div//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
//		ele.click();

		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='"+salutation+"']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(firstName);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	   //Verify the first name as 'Ganesh'
	
	}

}
