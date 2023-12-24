package handle_web_tables;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleStaticWebTable {

	public static void main(String[] args) {

		/*
		 * 1. How many rows in table 2. How many columns in table 3. Retrieve the
		 * specific data from table 4. Retrieve all the data from table
		 * 
		 */

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * 
		 * disableChromeOptions(options);
		 */
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		// 1. rows in a web table
		int rows = driver.findElements(By.xpath("//*[@id='customers']//tbody//tr")).size();

		System.out.println("rows in a web table: " + rows);

		int cols = driver.findElements(By.xpath("//*[@id='customers']//tbody//th")).size();
		System.out.println("cols in web table: " + cols);

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j <= cols; j++) {
				String text = driver
						.findElement(By.xpath("//*[@id='customers']//tbody//tr[" + (i + 1) + "]" + "//td[" + j + "]"))
						.getText();
				System.out.print("  " + text);
			}
			System.out.println();
		}

		driver.quit();

	}

}
