package handle_web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRowAndColumnFromWebTable {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String rowPath = "//*[@id='customers']//tr";
		String columnPath = "//*[@id='customers']//th";

		String getPathOfElementsInTable = "//*[@id='customers']//tbody//tr[";

		getRowColumns(rowPath, columnPath, getPathOfElementsInTable, "Canada");

	}

	public static boolean getRowColumns(String rowPath, String columnPath, String getPathOfElementsInTable,
			String name) {
		int rowCount = driver.findElements(By.xpath(rowPath)).size();

		int columnCount = driver.findElements(By.xpath(columnPath)).size();

		boolean flag = false;

		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				String actualValue = driver
						.findElement(By.xpath(getPathOfElementsInTable + (i + 1) + "]" + "//td[" + j + "]")).getText();

				if (actualValue.equals(name)) {
					flag = true;
					System.out.println(i + "  :  " + j);
					break;
				}
			}
		}

		if (flag) {
			return true;
		}
		return flag;
	}

}
