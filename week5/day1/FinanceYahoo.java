package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) throws InterruptedException {
		
		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load the URL
		driver.get("https://finance.yahoo.com/");
		
		//mouse hover to more option
		WebElement click_More = driver.findElement(By.xpath("//span[text()='More']"));
		
		//Using actions for mouse hover
		Actions act = new Actions(driver);
		act.moveToElement(click_More).perform();
		
		//using java wait to sleep the program particular time
		Thread.sleep(2000);
		
		//clicking the crypto option
		driver.findElement(By.xpath("(//a[contains(text(),'Crypto')])[3]")).click();
		
		//using java wait to sleep the program particular time
		Thread.sleep(3000);
		
		//print statement
		System.out.println("Crypto Currencies Are : ");
		
		//Store the entire values into the List and Print It
		List<WebElement> findElements = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for (WebElement getNames : findElements) {
			System.out.println(getNames.getText());
		}
		
		

	}

}
