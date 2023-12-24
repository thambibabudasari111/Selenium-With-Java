package tooltips_and_windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
		
		register.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
