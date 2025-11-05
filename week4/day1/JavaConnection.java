package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaConnection implements DatabseConnection {

	ChromeDriver driver = new ChromeDriver();
	
	//implementation for connect method
	public void connect() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/maps/");
		
	}

	//implementation for disconnect method
	public void disconnect() {
		
		driver.findElement(By.id("searchboxinput")).sendKeys("Theni",Keys.ENTER);
	}

	//implementation for executeUpdate method
	public void executeUpdate() {
		String browserTitle = driver.getTitle();
		System.out.println("Browser Title Is : "+browserTitle);
		driver.quit();
		
	}

	public static void main(String[] args) {
		JavaConnection jc = new JavaConnection();
		jc.connect();
		jc.disconnect();
		jc.executeUpdate();
	}
	
}
