package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {

	public static void main(String[] args) {
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		  
		//Maximize the browser
		driver.manage().window().maximize();
		 
		//load the URL
		driver.get("https://www.facebook.com/");
		 
		//enter the email ID
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		
		//enter the password
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		  
		//click login button
		driver.findElement(By.xpath("//button[@name='login']")).click();
		  
		//get and print the title
		String get_CurrentWindowTitle = driver.getTitle();
		System.out.println("Current Window Title Is : "+get_CurrentWindowTitle);
		  
		//close the browser
		driver.close();

	}

}
