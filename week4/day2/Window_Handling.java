package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Window_Handling {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();

		// 1) Use a fresh/throwaway Chrome profile (nothing saved → no breach warning)
		options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "chrome-tmp-profile");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-save-password-bubble");  // Disable password save prompt

	//	options.addArguments("--remote-allow-origins=*");

		//creating object & launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//click button
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//click CRM link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//click contacts option
		driver.findElement(By.linkText("Contacts")).click();
		
		//click merge contact button
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		 // Get current window handle (Parent)
        String parentWindow = driver.getWindowHandle();
		
		//click the widget of the "From Contacts"
		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[1]")).click();
		
		//wait for sometime
		Thread.sleep(2000);
		
		//store the all the windows
		Set<String> allWindows = driver.getWindowHandles();
		
		//wait for sometime
		Thread.sleep(2000);
		
		//Store into the list
		List<String> listWindow=new ArrayList<String>(allWindows);
		
		//Switch to child window
		for (String eachWindows : allWindows) {
			if (!eachWindows.equals(parentWindow)) {
				driver.switchTo().window(eachWindows);
			}
		}
		
		//wait for sometime
		Thread.sleep(3000);
		
		//maximize the new window
		driver.manage().window().maximize();	
		
		//click the first value
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[contains(@class,'cell-first ')]//a)[1]")).click();
		
		//Again switch to parent window
		driver.switchTo().window(parentWindow);
		
		//Now click the widget of the "To Contact".
		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[2]")).click();
		
		//wait for sometime
		Thread.sleep(3000);
		
		//Again store the all windows into the Set
		Set<String> allWindows1 = driver.getWindowHandles();
		
		//Now create the list and store the set values
		List<String> listWindow1=new ArrayList<String>(allWindows1);
		
		//Switch to child window
		for (String eachWindows : allWindows1) {
			if (!eachWindows.equals(parentWindow)) {
				driver.switchTo().window(eachWindows);
			}
		}
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//wait for sometime
		Thread.sleep(3000);
		
		//Now click the second option
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[contains(@class,'cell-first ')]//a)[2]")).click();
		
		//Now switch to the parent window again
		driver.switchTo().window(parentWindow);
		
		//wait for sometime
		Thread.sleep(3000);
		
		//click merge button
		driver.findElement(By.linkText("Merge")).click();
		
		//swith to the control to alert
		Alert alert = driver.switchTo().alert();
		
		//Accept the alert
		alert.accept();
		
		//Print the current window title
		String currentWindowTitle = driver.getTitle();
		System.out.println("Current Window Title Is : "+currentWindowTitle);
		
		//close the browser
		driver.close();
		
		
	}

}
