package handle_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownsUsingSelectClass {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		WebElement countryDropdown = driver.findElement(By.xpath("//*[@class='resp-tabs-container']//select"));
		
		
		Select select = new Select(countryDropdown);
		
		//select.selectByVisibleText("Israel");
		//select.selectByIndex(10);
		select.selectByValue("COL");
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
