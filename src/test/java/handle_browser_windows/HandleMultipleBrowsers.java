package handle_browser_windows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleMultipleBrowsers {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// 1. return the ID of the single window ID
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);

		driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();

		// 2. return ID's of multiple windows

		// first method - using iterator()
		Set<String> windowIDs = driver.getWindowHandles();

		/*
		 * Iterator<String> it = windowIDs.iterator();
		 * 
		 * String parentID = it.next();
		 * 
		 * String childID = it.next();
		 * 
		 * System.out.println(parentID); System.out.println(childID);
		 * 
		 * driver.switchTo().window(parentID);
		 * System.out.println("parent window title:"+driver.getTitle());
		 * 
		 * driver.switchTo().window(childID);
		 * System.out.println("child window title: "+driver.getTitle()); ; /* //second
		 * method - using List/ArrayList
		 * 
		 * List<String> windowsList = new ArrayList<>(windowIDs);
		 * 
		 * String parent = windowsList.get(0); String child = windowsList.get(1);
		 * 
		 * driver.switchTo().window(child);
		 * 
		 * driver.switchTo().window(parent);
		 */

		// third method using for-each loop
		for (String windows : windowIDs) {
			String title = driver.switchTo().window(windows).getTitle();
			System.out.println(title);
		}

	}

}
