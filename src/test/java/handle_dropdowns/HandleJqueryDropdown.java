package handle_dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJqueryDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		//selectDropdownValues(driver, "choice 1");
		//selectDropdownValues(driver, "choice 1", "choice 2", "choice 6", "choice 6 2 1", "choice 6 2 2");
		selectDropdownValues(driver, "all");
	}

	public static void selectDropdownValues(WebDriver driver, String...value)
	{
		List<WebElement> choiceList = driver.findElements(By.xpath("//*[@class='col-lg-6']/descendant::*[contains(@class,'comboTree')]//input[@type='checkbox']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement choice:choiceList)
			{
				String text = choice.getText();
				
				for(String val:value)
				{
					if(text.equals(val))
					{
						choice.click();
						break;
					}
				}
			}
		}
		else
		{
			try {
				for(WebElement choice:choiceList)
				{
					choice.click();
				}
			}catch(Exception e)
			{
			}
			
		}
		
		driver.close();
	}
}
