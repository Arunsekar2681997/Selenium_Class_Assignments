package week3.day2;

import org.openqa.selenium.By;

public class LoginTestData extends TestData{
	
	public void enterUsername()
	{
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	}
	
	public void enterPassword()
	{
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	
	public static void main(String[] args) {
		
		LoginTestData ltd = new LoginTestData();
		ltd.navigateToHomePage();
		ltd.enterCredentials();
		ltd.enterUsername();
		ltd.enterPassword();
	}

}
