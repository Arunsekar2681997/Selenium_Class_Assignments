package stepdefinition;

import org.openqa.selenium.By;

import stepdefinition.BaseClass;
import io.cucumber.java.en.And;

public class EditAccount extends BaseClass{
	
//	And 
//	And 
//	And Enter phone number and search as 
//	And 
//	And 
//	And 
//	And 
//	Then Verify the page
	
	@And("Click find leads option")
	public void clickFindLeads()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Click phone option")
	public void clickPhone()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@And("Enter phone number and search as {string}")
	public void enterPhoneAndSearch(String phoneNumebr)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumebr);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	
	@And("Click the first record")
	public void clickResult() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	
	@And("Click edit button")
	public void clickEditButton()
	{
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@And("Edit the value as {string}")
	public void editValue(String compNameValue)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(compNameValue);
	}
	
	@And("Click the submit button for edit flow")
	public void clickSubmitButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	

}
