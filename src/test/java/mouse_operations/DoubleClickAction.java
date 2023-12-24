package mouse_operations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//switch to the frame
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("welcome to selenium");

		WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		// to perform right click action
		Actions action = new Actions(driver);
		action.doubleClick(copyText).perform();	
		
	}

}
