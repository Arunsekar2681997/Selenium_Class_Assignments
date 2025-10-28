package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	ChromeDriver driver = new ChromeDriver();
	
	public void findElement()
	{
		driver.manage().window().maximize();
	}
	
	public void clickElement()
	{
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	public void enterText()
	{
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	
	public void performCommonTasks()
	{
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	}
	
	public static void main(String[] args) {
		
		BaseClass bc = new BaseClass();
		bc.findElement();
		bc.clickElement();
		bc.enterText();
		bc.performCommonTasks();
	}

}
