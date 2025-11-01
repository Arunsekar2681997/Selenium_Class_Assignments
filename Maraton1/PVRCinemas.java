package Maraton1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		
		
		//launch the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2) Load the Url "https://www.pvrcinemas.com/";
		driver.get("https://www.pvrcinemas.com/");
		
		//Choose Your location as "Chennai"
		//City is already selected
		
		//3) //Choose Your location as "Chennai"
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		
		
		//select the cinema option
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[3]")).click();
		
		//6) Select Your Date as Tomorrow
		driver.findElement(By.xpath("//li[@class='p-dropdown-item']/span[contains(text(),'Tomorrow')]")).click();

		//7) Select Your Movie
		driver.findElement(By.xpath("//li[@class='p-dropdown-item']/span[text()='AARYAN']")).click();
		
		//8) Select Your Show Time
		driver.findElement(By.xpath("//li[@class='p-dropdown-item']//span[text()='08:00 PM']")).click();
		
		//9) Click on Book Button
		driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']")).click();
		
		//10) Click Accept on Term and Condition
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//11) Click any one available seat
		driver.findElement(By.xpath("//span[contains(text(),'CLUB')]//following::span[@class='seat-current-pvr']")).click();
		
		//12) Click Proceed Button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//13) Print the Seat info under book summary
		String seatNumber = driver.findElement(By.xpath("//div[@class='seat-number']/p")).getText();
		System.out.println("Seat Number Is : "+seatNumber);
		
		Thread.sleep(5000);
		
		//14) Print the grand total under book summary
		String totalAmount = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']//span")).getText();
		System.out.println("Grand Total Amount Is : "+totalAmount);
		
		
		//15) Click Continue
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		
		//16) Close the popup
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		//17) Print Your Current Page title
		String title = driver.getTitle();
		System.out.println("Current Browser Title Is : "+title);
		
		//18) Close Browser
		driver.quit();
		
		
				
		
		
		
		 

	}

}
