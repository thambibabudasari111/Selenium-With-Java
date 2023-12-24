package getTextVsgetAttribute;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVsGetAttribute {

	/*
	 * getText() --> the getText() method returns the innerText of an element
	 * 
	 * getAttribute() --> this method returns the text contained by an attribute in
	 * an HTML document.
	 */
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement email = driver.findElement(By.id("Email"));

		// to clear text from input field
		// email.clear();

		// email.sendKeys("abc123@gmail.com");

		// capture text from input field using getAttribute method
		System.out.println("Result from getAttribute() method: " + email.getAttribute("value"));

		// capture text from input field using getText() method
		System.out.println("Result from getText() method: " + email.getText());

		driver.close();

	}

}
