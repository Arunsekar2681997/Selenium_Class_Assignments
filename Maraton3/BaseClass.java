package Maraton3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public ChromeDriver driver;
	public String dataFile;
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
			return ReadExcelData.readData(dataFile);
	
	}
	
	@Parameters({"url","username","password"})
	
	@BeforeMethod
	public void preCond(String url , String userName , String passWord)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--user-data-dir=C:\\Users\\arunsekar.CLAYFIN\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Selenium");

		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void postCond()
	{
		driver.quit();
	}

}
