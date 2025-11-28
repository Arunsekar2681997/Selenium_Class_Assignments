package pages;

import org.openqa.selenium.By;

import base.CommonCodes;

public class CreateLead extends CommonCodes{
	
	public CreateLead enterCompanyName()
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		return this;
		
	}
	
	public CreateLead enterFirstName()
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		return this;
	}
	
	public CreateLead enterLastname()
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		return this;
	}
	
	public ViewLead clickSubmitButton()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLead();
	}

}
