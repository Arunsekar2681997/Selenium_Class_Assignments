package Maraton2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliq {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		
		//2. MouseHover on 'Brands'
		WebElement findBrands = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(findBrands).perform();
		
		Thread.sleep(2000);
		
		//3. MouseHover on 'Watches & Accessories'
		
		WebElement findWatches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(findWatches).perform();
		
		Thread.sleep(2000);
		
		//4. Choose the first option from the 'Featured brands'.
		
		driver.findElement(By.xpath("//div[text()='Casio']")).click();
		
		Thread.sleep(2000);
		
		//5. Select sortby: New Arrivals
		WebElement findDropdown = driver.findElement(By.xpath("//select[@label='Popularity']"));
		Select sel = new Select(findDropdown);
		sel.selectByVisibleText("New Arrivals");
		
		//6. choose men from catagories filter.
		driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
		
		Thread.sleep(2000);
		
		//7. print all price of watches
		List<WebElement> getWatchPrices = driver.findElements(By.xpath("//h3[@class='ProductDescription__boldText']/parent::div[@class='ProductDescription__priceHolder']"));
		
		List<String> allwatchPrices = new ArrayList<String>();
		
		for (WebElement watchPrice : getWatchPrices) {
			String price = watchPrice.getText();
			price = price.replaceAll("[^0-9]", "");
			allwatchPrices.add(price);
		}
		
		System.out.println(allwatchPrices);
		
		Thread.sleep(5000);
		
		//8. click on the first resulting watch.
		WebElement findProduct = driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])[1]"));
//		act.scrollToElement(findProduct).perform();
		findProduct.click();
		
		//switch to child window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allWindows.get(1));
		
		Thread.sleep(2000);
		
		//9. compare two price are similar  
		WebElement getAmount = driver.findElement(By.xpath("//div[contains(@class,'ProductDetailsMainCard')]//h3"));
		String watchPrice = getAmount.getText();
		watchPrice = watchPrice.replaceAll("[^0-9]", "");		
		if (allwatchPrices.get(0).equals(watchPrice)) {
			System.out.println("Both Screen Watch Prices Are Same Only");
		} else {
			System.out.println("Both Screen Watch Prices Are Not Same");
		}
		
		//10. click Add to cart and get count from the cart icon.
		WebElement findAddToBag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		act.scrollToElement(findAddToBag).perform();
		findAddToBag.click();
		Thread.sleep(3000);
		WebElement getCountValue = driver.findElement(By.xpath("//span[contains(@class,'cartCount')]"));
		String cartCount = getCountValue.getText();
		System.out.println("Cart Count Is : "+cartCount);
		
		//11. Click on the cart
		driver.findElement(By.xpath("//div[contains(@class,'myBagShow')]")).click();
		
		//12. Take a snap of the resulting page. 
		//ignore this one since screenshot related modules are not yet completed
		
		//13. Close All the opened windows one by one.
		driver.close();
		driver.switchTo().window(allWindows.get(0));
		driver.close();
		
	
		
		
		
	}

}
