package browser_navigation_commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBackAndForward {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		// to go back to the previous web page
		driver.navigate().back();

		// to move forward to the next page
		driver.navigate().forward();

		driver.quit();

	}

}
