package upload_files;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile_RobotClass {

	public static void main(String[] args) throws AWTException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.foundit.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[contains(@class,'secondaryBtn')]")).click();

		WebElement upload = driver.findElement(By.id("file-upload"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", upload);

		/*
		 * 1. copy file path 2. CTRL + V 3. Enter
		 */

		Robot robot = new Robot();
		robot.delay(2000);

		StringSelection filepath = new StringSelection("C:\\Users\\thamb\\OneDrive\\Desktop\\Patient_details.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		// CTRL + V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);

		// ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
