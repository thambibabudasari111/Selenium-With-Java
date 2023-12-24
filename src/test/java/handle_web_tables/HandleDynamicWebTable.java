package handle_web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleDynamicWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// user name and password
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");

		// login button
		driver.findElement(By.xpath("//*[@id='form-login']//*[@type='submit']")).click();

		// close button of a pop up after login
		driver.findElement(By.xpath("//*[@id='modal-security']//button[@class='btn-close']")).click();

		// click on sales option at the left hand side
		driver.findElement(By.xpath("//*[@id='column-left']//*[normalize-space()='Sales']")).click();

		// click on orders
		driver.findElement(By.xpath("//*[@id='column-left']//*[normalize-space()='Orders']")).click();

		// no.of pages available in the table
		String text = driver.findElement(By.xpath("//*[@class='col-sm-6 text-end']")).getText();

		System.out.println(text);

		// count total no.of pages
		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		System.out.println("total pages: " + total_pages);

		// 2. find how many rows in the table
		for (int p = 1; p < total_pages; p++) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("active page: " + active_page.getText());

			try {
				active_page.click();
			} catch (Exception e) {

			}

			int rows = driver.findElements(By.xpath("//*[@class='table table-bordered table-hover']//tbody//tr"))
					.size();
			System.out.println(rows);

			// 3. Read all the rows data from each page
			for (int r = 1; r <= 10; r++) {
				String orderId = driver
						.findElement(
								By.xpath("//*[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				String customerName = driver
						.findElement(
								By.xpath("//*[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
						.getText();
				String status = driver
						.findElement(
								By.xpath("//*[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[5]"))
						.getText();

				if (status.equals("Pending")) {
					System.out.println(orderId + "    " + customerName + "    " + status);
				}

			}
			try {
				String pageno = Integer.toString(p + 1);

				driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageno + "']")).click();
			} catch (Exception e) {

			}

		}

		// driver.close();

	}

}
