package pages;

import org.openqa.selenium.By;

import base.CommonCodes;

public class MyLeads extends CommonCodes{
	
	public CreateLead clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead();
		
	}

}
