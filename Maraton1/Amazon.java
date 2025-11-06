package Maraton1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		//		01) Launch Chrome
		ChromeDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//	02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		//	add implicitlyWait
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
				
		//	03) Type "Bags for boys" in the Search box ("bags for boys",Keys.Enter);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys",Keys.ENTER);
			
		//	04) Choose the item in the result (bags for boys)
		//	05) Print the total number of results (like 50000)
		//	1-48 of over 50,000 results for "bags for boys"
		String result = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']")).getText();
		System.out.println("Result Is : "+result);
		
		
		//	06) Select the first 2 brands in the left menu
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox-fancy')]//label)[1]")).click();
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox-fancy')]//label)[2]")).click();
		
		//	(like American Tourister, Generic)
		//	07) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
		driver.findElement(By.xpath("//a[@class='a-dropdown-link' and contains(text(), 'Newest')]")).click();
		
		//	08) Print the first resulting bag info (name, discounted price)
		String productName = driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")).getText();
		System.out.println("Product Name Is : "+productName);
		String productPrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']")).getText();
		System.out.println("Product Price Details Are : "+productPrice);
		//	09) Get the page title and close the browser(driver.close())
		String title = driver.getTitle();
		System.out.println("Browser Current Title Is : "+title);
		
		//close the browser
		driver.quit();

	}

}
