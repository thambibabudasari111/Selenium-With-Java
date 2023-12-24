package download_files;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadWordFile_Firefox {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "\\Downloads";

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", location);

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		WebDriver driver = new FirefoxDriver();

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement downloadFile = driver.findElement(By.xpath("//*[@class='text-right file-link']//a[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", downloadFile);
		js.executeScript("arguments[0].click();", downloadFile);
		System.out.println("file downloaded");
	}

}
