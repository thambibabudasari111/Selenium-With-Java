package cookies;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCookies {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// capture cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("cookies size: " + cookies.size());

		// print cookies from browser
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}

		// add cookie to the browser
		Cookie cookieObj = new Cookie("mycookie123", "123456");

		driver.manage().addCookie(cookieObj);

		cookies = driver.manage().getCookies();
		System.out.println("cookie size after adding: " + cookies.size());

		// delete specific cookie from browser
		driver.manage().deleteCookie(cookieObj);

		cookies = driver.manage().getCookies();
		System.out.println("cookie size after deletion of specific cookie: " + cookies.size());

		// delete all cookies
		driver.manage().deleteAllCookies();

		cookies = driver.manage().getCookies();
		System.out.println("cookie size after deletion of all cookies: " + cookies.size());
	}

}
