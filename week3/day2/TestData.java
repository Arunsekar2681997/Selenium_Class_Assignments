package week3.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	
	ChromeDriver driver = new ChromeDriver();
	
	public void enterCredentials()
	{
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	public void navigateToHomePage()
	{
		
		driver.manage().window().maximize();
	}
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.navigateToHomePage();
		td.enterCredentials();
		
	}

}
