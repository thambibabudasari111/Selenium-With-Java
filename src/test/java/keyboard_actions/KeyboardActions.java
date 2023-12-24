package keyboard_actions;
import org.openqa.selenium.Keys;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/key_presses");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(2000);
		
		action.sendKeys(Keys.BACK_SPACE).perform();
		
		driver.close();
	
	}

}
