package keyboard_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement inputText1 = driver.findElement(By.id("inputText1"));
		inputText1.sendKeys("thie is keyboard actions program");

		WebElement inputText2 = driver.findElement(By.id("inputText2"));

		Actions action = new Actions(driver);

		// CTRL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL).perform();

		// CTRL + C
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL).perform();

		// TAB - shift to input2 box
		action.sendKeys(Keys.TAB).perform();

		// CTRL + V
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL).perform();
		
		//compare text
		if(inputText1.getAttribute("value").equals(inputText2.getAttribute("value")))
		{
			System.out.println("text copied successfully...");
		}
		else
		{
			System.out.println("text not copied");
		}

		driver.close();
	}

}
