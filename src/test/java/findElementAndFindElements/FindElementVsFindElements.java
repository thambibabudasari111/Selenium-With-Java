package findElementAndFindElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {

	/*
	 * findElement() method returns the first matching element on the current page.
	 * If the element is not found then it throws NoSuchElementFoundException
	 * 
	 * findElements() method returns all the matching web elements on the current
	 * web page and it doesn't throw any exception if the element is not found.
	 * instead it will throw zero elements.
	 */
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// enter url
		driver.get("https://demo.nopcommerce.com/");

		// maximize browser
		driver.manage().window().maximize();

		// find element - return single web element
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("abc");

		// find element - if multiple elements present it return the first element from
		// the list
		WebElement links = driver.findElement(By.xpath("//*[@class='footer-upper']//a"));
		System.out.println(links.getText());

		// find elements - returns all elements
		List<WebElement> footerLinks = driver.findElements(By.xpath("//*[@class='footer-upper']//a"));

		System.out.println(footerLinks.size());

		for (WebElement e : footerLinks) {

			System.out.println("Footer links:" + e.getText());
		}

		// find elements - if element not present it doesn't throw any exception and
		// returns zero elements
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='footer-upper']//a//t"));
		System.out.println(element.size());

		driver.quit();

	}

}
