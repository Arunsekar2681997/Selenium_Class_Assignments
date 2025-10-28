package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement {
	
	ChromeDriver driver = new ChromeDriver();
	
	public void click()
	{
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	public void setText(String text)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(text);
	}

}
