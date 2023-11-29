package handle_dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropdownWithoutSelectClass {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		
		List<WebElement> countryDropdown = driver.findElements(By.xpath("//*[@class='resp-tabs-container']//select//option"));
		
		for(WebElement option: countryDropdown)
		{
			if(option.getText().equals("Israel"))
			{
				option.click();
				break;
			}
		}
		
		driver.close();
		
		
	}

}
