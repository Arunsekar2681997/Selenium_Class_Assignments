package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;

public class CheckBoxButton extends Button{
	
	
	public void clickCheckBoxButton()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String checked_Value = driver.findElement(By.xpath("(//div[@id='errorDiv']/p)[1]")).getText();
		System.out.println("Message Value Is : "+checked_Value);
		driver.close();
	}
	
	public static void main(String[] args) {
		CheckBoxButton cbb = new CheckBoxButton();
		cbb.click();
		cbb.setText("Demosalesmanager");
		cbb.submit();
		cbb.clickCheckBoxButton();
	}
}
