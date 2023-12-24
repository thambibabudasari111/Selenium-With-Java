package images;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisablingImages {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		disableChromeOptions(options);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		
	}
	
	public static ChromeOptions disableChromeOptions(ChromeOptions options)
	{
		HashMap<String, Object> imagesMap = new HashMap<String, Object>();
		imagesMap.put("images", 2);
		
		HashMap<String, Object> prefMap = new HashMap<String, Object>();
		prefMap.put("profile.default_content_setting_values", imagesMap);
		
		options.setExperimentalOption("prefs", prefMap);
		
		return options;
	}

}
