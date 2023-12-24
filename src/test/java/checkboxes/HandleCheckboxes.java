package checkboxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1. select specific check box
		// driver.findElement(By.xpath("//*[@id='sunday']")).click();

		// 2. select all the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath(
				"//*[@class='form-group']//label[@for='days']//following-sibling::*[contains(@class,'form-check-inline')]"));

		System.out.println("total check boxes:" + checkboxes.size());

		/*
		 * for(WebElement checkbox: checkboxes) { checkbox.click(); }
		 */

		// 3. select check boxes based on choice
		/*
		 * for(WebElement checkbox: checkboxes)
		 * 
		 * { String checkboxName = checkbox.getText();
		 * 
		 * System.out.println(checkboxName);
		 * 
		 * if(checkboxName.equals("Sunday") || checkboxName.equals("Monday")) {
		 * checkbox.click(); } }
		 */

		// 4. select last 2 check boxes
		// total no.of check boxes - no.of check boxes to select = starting index
		int totalCheckboxes = checkboxes.size();

		/*
		 * for(int i=totalCheckboxes-2;i<totalCheckboxes;i++) {
		 * checkboxes.get(i).click(); }
		 */

		// 5. select first 3 check boxes
		for (int i = 0; i < totalCheckboxes; i++) {
			if (i < 3) {
				checkboxes.get(i).click();
			}
		}
	}

}
