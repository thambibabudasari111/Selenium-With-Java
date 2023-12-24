package upload_files;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile_Sendkeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.foundit.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[contains(@class,'secondaryBtn')]")).click();

		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\thamb\\OneDrive\\Desktop\\Patient_details.pdf");

	}

}
