package mouse_operations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropImages {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame using web element
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='gallery']//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='gallery']//li[2]"));
		
		WebElement target = driver.findElement(By.id("trash"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(item1, target).perform();
		action.dragAndDrop(item2, target).perform();
				
		
	}

}
