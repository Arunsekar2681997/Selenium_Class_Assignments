package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;

public class RadioButton extends Button {
	
	public void selectRadioButton()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String passwordError = driver.findElement(By.xpath("(//div[@id='errorDiv']/p)[2]")).getText();
		System.out.println("Error Message Occured As : "+passwordError);
	}
	
	public static void main(String[] args) {
		RadioButton rb = new RadioButton();
		rb.click();
		rb.setText("demosalesmanager");
		rb.submit();
		rb.selectRadioButton();
		
		
	}
}
