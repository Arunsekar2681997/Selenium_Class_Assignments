package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
		
		//click create lead option
		driver.findElement(By.linkText("Create Lead")).click();
		
		//enter firstname
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("ArunSekar");
		
		//enter lastname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Panneer Selvam");
		
		//enter company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Team AS");
		
		//enter Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("First Selenium Project");
		
		//click create Lead Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//get the title and print the title
		String title = driver.getTitle();
		System.out.println("Current Window Title Is : "+title);
		
		//close the browser
		driver.close();

	}

}
