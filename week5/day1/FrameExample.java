package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		
		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch To frame
		driver.switchTo().frame("iframeResult");
		
		//click the option
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//swith to alert
		Alert alert = driver.switchTo().alert();
		
		//Accept the alert
		alert.accept();
		
		//Get the value post accept the alert
		WebElement getValue = driver.findElement(By.id("demo"));
		String value = getValue.getText();
		
		//Print the value using sysout statement
		System.out.println("After Accepting The Try It Button , Displayed Value Is : "+value);
		
		//close the browser
		driver.quit();

	}

}
