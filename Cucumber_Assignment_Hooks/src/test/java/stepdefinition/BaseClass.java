package stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests  {
	
	public static ChromeDriver driver;
	public static Actions act;
	public static WebDriverWait wait;
	public String leadID;
	

}
