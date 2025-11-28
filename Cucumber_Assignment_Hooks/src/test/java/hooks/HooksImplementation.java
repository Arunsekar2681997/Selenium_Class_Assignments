package hooks;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import stepdefinition.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class HooksImplementation extends BaseClass {
	
	
	@Before
	public void preCond()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		//creating object & launch the browser
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@After
	public void postCond()
	{
		driver.quit();
	}
	

}
