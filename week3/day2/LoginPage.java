package week3.day2;

import org.openqa.selenium.By;

public class LoginPage extends BaseClass {
	
	@Override
	public void performCommonTasks()
	{
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL Is : "+currentUrl);
		driver.close();
	}

	public static void main(String[] args) {
		LoginPage lp = new LoginPage();
		lp.performCommonTasks();

	}

}
