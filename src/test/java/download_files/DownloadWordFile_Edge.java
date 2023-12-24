package download_files;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DownloadWordFile_Edge {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "\\Downloads";

		HashMap<String, Object> preferences = new HashMap<>();
		preferences.put("download.default_directory", location);
		preferences.put("download.prompt_for_download", true);
		preferences.put("plugins.always_open_pdf_externally", true);

		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);

		WebDriver driver = new EdgeDriver(options);

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
