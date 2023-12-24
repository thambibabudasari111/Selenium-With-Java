package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Sample {

	
	@Test
	public void test()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
