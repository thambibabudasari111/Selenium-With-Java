package mouse_operations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement min_slider = driver.findElement(By.xpath("//*[@id='slider-range']//span[1]"));
		
		WebElement max_slider = driver.findElement(By.xpath("//*[@id='slider-range']//span[2]"));
		
		System.out.println("Location of the min slider: "+min_slider.getLocation());
		System.out.println("height and size of the min slider: "+min_slider.getSize());
		
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(min_slider, 100, 0).perform();
		
		action.dragAndDropBy(max_slider, -100, 0).perform();
		
		System.out.println("Location of the min slider: "+min_slider.getLocation());
		System.out.println("height and size of the min slider: "+min_slider.getSize()); 
	}

}
