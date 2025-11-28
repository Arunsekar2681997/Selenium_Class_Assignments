package pages;

import org.openqa.selenium.By;

import base.CommonCodes;

public class LoginPage extends CommonCodes{
	
	public LoginPage enterUsername()
	{
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		return this;
	}
	
	public LoginPage enterPassword()
	{
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	
	public WelcomePage clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}
}
