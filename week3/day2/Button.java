package week3.day2;

import org.openqa.selenium.By;

public class Button extends WebElement{
	
	public void submit()
	{
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	}
	
	public static void main(String[] args) {
		
	}

}
