package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {

		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the URL
		driver.get("https://www.amazon.in/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//wait for to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Search the input and click enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//take the first price of the product
		WebElement getAmount = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String amount = getAmount.getText();
		System.out.println("First Product Price Is : "+amount);
		
		//take the first product rating
		WebElement getRatingCount = driver.findElement(By.xpath("//div[contains(@class,'a-size-small')]/a/span"));
		String ratingCount = getRatingCount.getText();
		ratingCount = ratingCount.replace("(", "").replace(")", "");
		System.out.println("Number Of Ratings Give For The First Product : "+ratingCount);
		
		//click the first product image
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		
		//sleep for sometime
		Thread.sleep(3000);
		
		//To store the multiple windows
		Set<String> allWindowHandles = driver.getWindowHandles();
		//Store the multiple windows into the List
		List<String> allWindows =  new ArrayList<String>(allWindowHandles);
		
		//switch to the child window
		driver.switchTo().window(allWindows.get(1));
		
		//Scroll & Click Add to cart option
		Actions act = new Actions(driver);
		WebElement ScrollTo = driver.findElement(By.id("add-to-cart-button"));
		act.scrollToElement(ScrollTo).perform();
		ScrollTo.click();
		
		//Get & Print the Whole Value
		WebElement getWholeValue = driver.findElement(By.xpath("//div[@id='sw-atc-buy-box']//span[@class='a-price-whole']"));		
		String getCartSubTotal = getWholeValue.getText();
		
		//checking the both amounts(First product amount and get
		if (amount.equalsIgnoreCase(getCartSubTotal)) {
			System.out.println("Both Amounts Are Same");
		} else {
			System.out.println("Both Amounts Are Not Same");
		}
		
		//close all the browsers
		driver.quit();
		
		
		
		
	}

}
