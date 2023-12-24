package date_picker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// click on dob
		driver.findElement(By.id("dob")).click();

		// select month
		WebElement monthDropdown = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		Select month = new Select(monthDropdown);
		month.selectByVisibleText("Feb");

		// select year
		WebElement yearDropdown = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
		Select year = new Select(yearDropdown);
		year.selectByVisibleText("1990");

		String date = "13";

		List<WebElement> dates = driver.findElements(By.xpath("//*[@data-handler='selectDay']//a"));

		for (WebElement allDates : dates) {
			if (allDates.getText().equals(date)) {
				allDates.click();
				break;
			}
		}

	}

}
