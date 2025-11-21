package Maraton3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DeleteIndividuals extends BaseClass {

	@BeforeTest
	public void setData()
	{
		dataFile = "Delete_Individuals";
	}
	
	@Test(dataProvider = "fetchData",groups = "deleteIndividuals",dependsOnGroups = "editIndividuals")
	public void deleteIndividuals(String searchName , String findName) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Delete
7.Click on the Delete option in the displayed popup window.
8. Verify Whether Individual is Deleted using Individual last name"

		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		Thread.sleep(3000);
	
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(searchName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement clickDropdown = driver.findElement(By.xpath("(//*[local-name()='svg' and @data-key='down'])[5]"));
		clickDropdown.click();
		//Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		WebElement findSearch = driver.findElement(By.xpath("//input[@class='slds-input']"));
		findSearch.clear();
		Thread.sleep(3000);
		findSearch.sendKeys(findName,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//h3[contains(text(),'Nothing to see here')]")).getText();
		
		if (verify.contains("Nothing")) {
			System.out.println("Testcase Pass");
		} else {
			System.out.println("Testcase Fail");
		}
		//Verify Whether Individual is Deleted using Individual last name"
		
	}

}
