package screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Take screenshot of full page
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\fullpage.png");
		FileUtils.copyFile(src, target);
		
		
		//Screenshot of portion of a web page
		WebElement portionOfPage = driver.findElement(By.xpath("//*[@class='page login-page']"));
		File src = portionOfPage.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\portionOfPage.png");
		FileUtils.copyFile(src, target);
		*/
		
		//screenshot of a web element
		WebElement element = driver.findElement(By.xpath("//button[text()='Register']"));
		File src = element.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\webelement.png");
		FileUtils.copyFile(src, target);
		Thread.sleep(1000);
		driver.close();
	}

}
