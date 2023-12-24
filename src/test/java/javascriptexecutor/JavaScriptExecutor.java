package javascriptexecutor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * 1. change background color and flash element
		 * 
		 * 2. Draw border and takes screenshot
		 * 
		 * 3. Get page title
		 * 
		 * 4. click action
		 * 
		 * 5. generate alert
		 * 
		 * 6. refresh page
		 * 
		 * 7. scroll down page
		 * 
		 * 8. scroll up page
		 * 
		 * 9. zoom page
		 */

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1. change background color and flash element
		// js.executeScript("arguments[0].style.backgroundColor='red'", logo);
		String bgcolor = logo.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("#FF0000", logo, driver);
			Thread.sleep(50);
			changeColor(bgcolor, logo, driver);
		}

		// 2. draw border
		/*
		 * js.executeScript("arguments[0].style.border='3px solid red'", logo); //takes
		 * screenshot TakesScreenshot ts = (TakesScreenshot)driver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File target = new
		 * File(".\\screenshots\\logo.png"); FileUtils.copyFile(src, target);
		 */

		// 3. capture title of the web page
		// String title = js.executeScript("return document.title", logo).toString();
		// System.out.println("title of the page: "+title);

		// 4.click action
		// WebElement books =
		// driver.findElement(By.xpath("//a[normalize-space()='Books']"));
		// js.executeScript("arguments[0].click();", books);

		// 5. generate alert
		// js.executeScript("alert('this is a test alert')");

		// 6. refresh a page
		// js.executeScript("history.go(0)");

		// 7. scroll down
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Thread.sleep(2000);

		// 8. scroll up
		// js.executeScript("window.scrollTo(0, -document.body.scollHeight)");

		// 9. zoom page
		// js.executeScript("document.body.style.zoom='50%'");

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}
	}

}
