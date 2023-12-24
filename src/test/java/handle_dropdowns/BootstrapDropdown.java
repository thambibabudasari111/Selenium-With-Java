package handle_dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// click on payzap close button (advertisement)
		WebElement closeBtn = driver.findElement(By.xpath("//*[@class='closeSummer']"));
		closeBtn.click();
		driver.findElement(By.xpath("//*[@class='closeSummer']")).click();

		// select product type
		driver.findElement(By.xpath("//*[@class='drp1']//*[@class='dropdown']")).click();

		List<WebElement> productTypes = driver.findElements(By.xpath("//*[@class='drp1']//ul//li"));

		selectOptionFromDropdown(productTypes, "Accounts");

		// select product
		driver.findElement(By.xpath("//*[@class='drp2']//*[@class='dropdown']")).click();

		List<WebElement> selectProduct = driver.findElements(By.xpath("//*[@class='drp2']//ul//li"));

		selectOptionFromDropdown(selectProduct, "Salary Accounts");

		Thread.sleep(3000);

		driver.close();

	}

	// Generic method
	public static void selectOptionFromDropdown(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
