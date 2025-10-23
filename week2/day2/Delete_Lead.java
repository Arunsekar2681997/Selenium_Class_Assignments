package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Delete_Lead {

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
		
		//click leads option
		driver.findElement(By.linkText("Leads")).click();
		
		//click Find Leads Option
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//Wait for sometime to load the page
		Thread.sleep(5000);
		
		//Capture the First Lead ID and Print  
		WebElement get_LeadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]"));		
		String lead_ID = get_LeadID.getText();
		System.out.println("Deleted Lead ID Is : "+lead_ID);
		
		//click the first captured lead ID
		get_LeadID.click();
		
		Thread.sleep(5000);
		
		//click Delete option
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		
		//click Find Leads Option Again
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//Search the deleted lead id in the lead ID input field
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead_ID);
		System.out.println(lead_ID);
		
		
		Thread.sleep(2000);
		
		//click Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		//Find and get message
		WebElement get_Message = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String get_Verify_Message = get_Message.getText();
		System.out.println(get_Verify_Message);
		
		
		//Wait for sometime to load the page		
		Thread.sleep(2000);
		
		
		//Verify the testcase is passed or not
		if(get_Verify_Message.contains("No records to display"))
		{
			System.out.println("Lead Id Is Deleted From The Web");
		}
		else {
			System.out.println("Lead ID Is Not Deleted From The Web");
		}
		
		//close the browser
		driver.close();
		
		

	}

}
