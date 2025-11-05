package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		//creating object & launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load the URL
		driver.get("https://www.myntra.com/");
		
		//search the bags
		driver.findElement(By.xpath("//div[@class='desktop-query']/input[@class='desktop-searchBar']")).sendKeys("bags",Keys.ENTER);
		
		//wait sometime to load the page
		Thread.sleep(3000);
		
		//select men filter
		driver.findElement(By.xpath("(//label[@class='common-customRadio gender-label'])[1]")).click();
		
		//wait sometime to load the page
		Thread.sleep(3000);
		
		//Under the "Category" click "Laptop Bags"
		driver.findElement(By.xpath("//label[contains(text(),'Laptop Bag')]")).click();
		
		Thread.sleep(3000);
		
		//print the result count
		String resultCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Results Counts For The Laptop Bag : "+resultCount);
		
		//click more option
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(3000);
		//Get the list of brand of the products
		
		//get the all bagnames
		List<WebElement> element = driver.findElements
				(By.xpath("//ul[@class='FilterDirectory-list']//label[contains(@class,'common-customCheckbox')]"));
		
		//create empty list to store the bag names
		List<String> brandNames = new ArrayList<String>();
		
		//using for each loop to iterate the values and add to the list
		for (WebElement brand  : element) {
			String text = brand.getText().split("\\(")[0].trim();
			
			brandNames.add(text);
		}
		
		//print the list
		System.out.println(brandNames);
		
		
		//close the brand details screen
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		
		//Store the brand list into the List
		List<WebElement> findElements = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		//create a empty list
		List<String> bagNames = new ArrayList<String>();
		
		//iterate the list using for each and store the bag names into the list
		for (WebElement bags : findElements) {
			String bagValues = bags.getText();
			bagNames.add(bagValues);
		}
		
		//print the entire bag name list
		System.out.println("List Of Bag Names Are Below : ");
		System.out.println(bagNames);
		
		//close the browser
		driver.quit();

	}

}
