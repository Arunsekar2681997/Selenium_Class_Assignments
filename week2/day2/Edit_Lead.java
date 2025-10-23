package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Edit_Lead {

	public static void main(String[] args) throws InterruptedException {
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
		
		//click Leads option
		driver.findElement(By.linkText("Leads")).click();
		
		//click Create Lead option
		driver.findElement(By.linkText("Create Lead")).click();
		
		//enter company name field using Xpath
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Team AS");
		
		//enter First Name field using Xpath
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("ArunSekar");
		
		//enter Last Name field using Xpath
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Panneer Selvamn");
		
		//enter First Name local field using Xpath
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("AS");
		
		//enter the Department field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality Assurance");
		
		//enter the Description field
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi.,This Is ArunSekar.......");
		
		//enter the Email ID
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("arunsekar2681997@gmail.com");
		
		//select State/Province as NewYork using visible Text
		WebElement find_State_and_Province = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel = new Select(find_State_and_Province);
		sel.selectByVisibleText("New York");
		
		//click Create Lead Button
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		//click Edit option
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//clear the description value
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		
		//Wait for sometime to understand the flow
		Thread.sleep(3000);
		
		//Enter important notes field
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Manual To Automation Tester");
		
		//click update button
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//get and print the current Title
		String get_CurrentTitle = driver.getTitle();
		System.out.println("Current Title Is : "+get_CurrentTitle);
		
		//close the browser
		driver.close();
		
		
		
		

	}

}
