package handle_dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestDropdown {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("selenium");

		List<WebElement> searchOptions = driver.findElements(By.xpath("//*[@id='Alh6id']//ul//li"));

		System.out.println("no.of auto suggestions: " + searchOptions.size());

		for (WebElement option : searchOptions) {
			if (option.getText().equals("selenium webdriver")) {
				option.click();
				break;
			}
		}

	}

}
