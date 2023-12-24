package links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//get total number links available in a web page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("no.of links: "+links.size());
		
		//get all the URL's of links
		List<String> urlList = new ArrayList<String>();
		
		for(WebElement e: links)
		{
			//store all link in a string 
			String url = e.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
		}
		
		long startTime  = System.currentTimeMillis();
		urlList.parallelStream().forEach(e -> checkBrokenLink(e));
		long endTime = System.currentTimeMillis();
		
		System.out.println("total time taken: "+(endTime-startTime));
		driver.quit();
		
	}
	
	public static void checkBrokenLink(String linkUrl)
	{
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConncetion = (HttpURLConnection)url.openConnection();
			httpUrlConncetion.setConnectTimeout(5000);
			httpUrlConncetion.connect();
			
			if(httpUrlConncetion.getResponseCode() >= 400)
			{
				System.out.println(linkUrl+" ---> "+httpUrlConncetion.getResponseMessage()+" is a broken link");
			}
			else
			{
				System.out.println(linkUrl+" ---> "+httpUrlConncetion.getResponseMessage());
			}
		}catch(Exception e)
		{
			
		}
	}

}
