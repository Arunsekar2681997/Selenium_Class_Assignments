package week3.day2;

import org.openqa.selenium.By;

public class TextField extends WebElement {
	
	public void getText()
	{
		String get_Text = driver.findElement(By.xpath("//label[@for='username']")).getText();
		System.out.println("Text Value Is : "+get_Text);
	}
	
	
	public static void main(String[] args) {

	}

}
