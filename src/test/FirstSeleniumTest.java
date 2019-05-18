package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		
		driver.quit();
	}

}
