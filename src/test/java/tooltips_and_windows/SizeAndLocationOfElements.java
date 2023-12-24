package tooltips_and_windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocationOfElements {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));

		// location - method 1
		System.out.println("location (x,y): " + register.getLocation());
		System.out.println("location (x,y): " + register.getLocation().getX());
		System.out.println("location (y): " + register.getLocation().getY());

		// location - method 2
		System.out.println("location (x): " + register.getRect().getX());
		System.out.println("location (y): " + register.getRect().getY());

		// size - method 1
		System.out.println("size (width, height): " + register.getSize());
		System.out.println("size (height): " + register.getSize().getHeight());
		System.out.println("size (width): " + register.getSize().getWidth());

		// size - method 2
		System.out.println("size (width): " + register.getRect().getDimension().getWidth());
		System.out.println("size (height): " + register.getRect().getDimension().getHeight());

		driver.close();

	}

}
