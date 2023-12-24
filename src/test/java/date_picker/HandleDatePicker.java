package date_picker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDatePicker {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String year = "2024";
		String month = "Feb";
		String date = "15";

		// click on calendar
		driver.findElement(By.id("onwardCal")).click();

		while (true) {
			String month_year = driver
					.findElement(By.xpath("//*[contains(@class,'DayNavigator__CalendarHeader')]//div[2]")).getText();

			String arr[] = month_year.split(" ");

			String mon = arr[0];
			String yr = arr[1];
			// String yrs = yr.replace("1", "");
			if (mon.equals(month) && yr.equals(year)) {
				break;
			}

			else {
				WebElement nextButton = driver.findElement(By.xpath(
						"//*[contains(@class,'DayNavigator__CalendarHeader')]//div[2]//following::*[@id='Layer_1']"));
				try {
					nextButton.click();

				} catch (StaleElementReferenceException e) {
					nextButton.click();
				}

			}

		}
		selectDate(date);

	}

	public static String selectDate(String date) {
		String dt = "";
		;
		List<WebElement> allDates = driver
				.findElements(By.xpath("//*[contains(@class,'DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj')]"));

		for (WebElement ele : allDates) {
			dt = ele.getText();

			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}
		return date;
	}

}
