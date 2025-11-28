package pages;

import org.openqa.selenium.By;

import base.CommonCodes;

public class WelcomePage extends CommonCodes{
	
	public HomePage clickCRMSFA()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage();
	}

}
