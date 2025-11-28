package pages;

import org.openqa.selenium.By;

import base.CommonCodes;

public class HomePage extends CommonCodes{
	
	public MyLeads clickLeads()
	{
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeads();
		
	}

}
