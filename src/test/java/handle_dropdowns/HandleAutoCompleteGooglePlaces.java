package handle_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleAutoCompleteGooglePlaces {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// live posting
		driver.findElement(By.xpath("//*[text()='Live Posting']")).click();

		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");

		String text = "";

		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);

			text = searchBox.getAttribute("value");

			if (text.equals("Toronto, OH, USA")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(1000);
		} while (!text.isEmpty());

	}

}
