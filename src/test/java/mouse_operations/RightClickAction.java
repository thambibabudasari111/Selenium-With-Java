package mouse_operations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement rightClickBtn = driver.findElement(By.xpath("//*[@class='context-menu-one btn btn-neutral']"));
		// to perform right click action
		Actions action = new Actions(driver);
		action.contextClick(rightClickBtn).perform();

	}

}
