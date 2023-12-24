package tooltips_and_windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltips {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/tooltip/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		WebElement age = driver.findElement(By.id("age"));
		System.out.println(age.getAttribute("title"));
		
		driver.close();
	}

}
