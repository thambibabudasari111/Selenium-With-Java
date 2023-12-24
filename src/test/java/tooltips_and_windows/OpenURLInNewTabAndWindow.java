package tooltips_and_windows;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLInNewTabAndWindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//to open a window in new window tab
		//driver.switchTo().newWindow(WindowType.TAB);
		
		//open url in the new browser window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.opencart.com/");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
