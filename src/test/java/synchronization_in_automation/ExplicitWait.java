package synchronization_in_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.google.com/");
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath(""));
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(null));
	}

}
