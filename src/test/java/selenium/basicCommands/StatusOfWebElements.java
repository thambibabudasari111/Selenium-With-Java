package selenium.basicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusOfWebElements {

	
	// how to check the WebElement is displayed, selected, and enabled?
	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		driver.manage().window().maximize();
		
		WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));
		System.out.println(firstname.isDisplayed());
		System.out.println(firstname.isEnabled());
		
		WebElement femaleRadioBtn = driver.findElement(By.xpath("//*[text()='Female']"));
		System.out.println(femaleRadioBtn.isSelected());
		
		femaleRadioBtn.click();
		Thread.sleep(1000);
		System.out.println(femaleRadioBtn.isSelected());
		
		driver.close();
	}

}
