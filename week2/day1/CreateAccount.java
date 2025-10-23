package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();

		// 1) Use a fresh/throwaway Chrome profile (nothing saved → no breach warning)
		options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "chrome-tmp-profile");
		

		//creating object & launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//enter username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		
		//click button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRM link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//click Accounts option
		driver.findElement(By.linkText("Accounts")).click();
		
		//click create account option
		driver.findElement(By.linkText("Create Account")).click();
		
		//enter accountname
		driver.findElement(By.id("accountName")).sendKeys("Lead Account");
		
		//enter description
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester.");
		
		//enter Number of Employees
		driver.findElement(By.id("numberEmployees")).sendKeys("500");
		
		//enter Site Name
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		
		//click Create Account button
		driver.findElement(By.className("smallSubmit")).click();
		
		//get and print the Title
		String get_Title = driver.getTitle();
		System.out.println("Browser Title Is : "+get_Title);
		
		driver.close();
		
		

	}

}
