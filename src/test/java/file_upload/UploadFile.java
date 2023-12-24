package file_upload;

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

public class UploadFile {

	public static void main(String[] args) throws AWTException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.foundit.in/");
		driver.manage().window().maximize();

		WebElement uploadBtn = driver.findElement(By.xpath("//*[contains(@class,'secondaryBtn ')]"));
		uploadBtn.click();

		// upload file using sendKeys()
		// driver.findElement(By.xpath("//*[(@id='file-upload')]")).sendKeys("C:\\Users\\thamb\\Downloads\\Automation
		// Assignments.pdf");

		WebElement fileUpload = driver.findElement(By.xpath("//*[(@id='file-upload')]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", fileUpload);

		// upload file using Robot class
		Robot rb = new Robot();

		rb.delay(2000);

		// put the path to file in a clip board
		StringSelection ss = new StringSelection("C:\\Users\\thamb\\Downloads\\Automation Assignments.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// press CTRL + V from keyboard
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release CTRL+V
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// press enter key from keyboard
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
