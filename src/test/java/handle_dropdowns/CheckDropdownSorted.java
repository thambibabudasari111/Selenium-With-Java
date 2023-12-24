package handle_dropdowns;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDropdownSorted {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();

		// live posting
		driver.findElement(By.xpath("//*[text()='Live Posting']")).click();

		WebElement dropdownList = driver.findElement(By.name("category_id"));

		Select select = new Select(dropdownList);

		List<WebElement> options = select.getOptions();

		ArrayList orgList = new ArrayList();

		ArrayList tempList = new ArrayList();

		for (WebElement option : options) {
			orgList.add(option.getText());
			tempList.add(option.getText());

		}

		System.out.println("original list: " + orgList);
		System.out.println("temp list: " + tempList);

		Collections.sort(tempList);

		// after sorting
		System.out.println("original list: " + orgList);
		System.out.println("temp list after sorting: " + tempList);

		if (orgList.equals(tempList)) {
			System.out.println("dropdown sorted");
		} else {
			System.out.println("dropdown unsorted");
		}

		driver.close();

	}

}
