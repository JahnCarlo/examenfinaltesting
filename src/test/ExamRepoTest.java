package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamRepoTest {
	private WebDriver driver;
	@Before
	public void setUp() {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://cse.uprm.edu");
	}
	@Test
	void testCanVisitFacultyPageMenu() throws InterruptedException {
		driver.manage().window().setSize(new Dimension(2528,1339));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			// Find the People menu by its name and hover over it
			WebElement peopleMenu = driver.findElement(By.xpath("//span[text()='People']"));
//			Actions myActions = new Actions(driver);
//			myActions.moveToElement(peopleMenu).perform();
		
			Thread.sleep(1000);
			
			peopleMenu.click();
						
			// Find the Faculty menu item and click it
			WebElement facultyMenuItem = driver.findElement(By.xpath("//span[text()='Faculty']"));
			
			Thread.sleep(1000);
			
			facultyMenuItem.click();	

		}
		catch (NoSuchElementException e) {
			// Some menu item not found
			fail(e.getMessage());
		}

		// Verify that you are in the Faculty page
		assertEquals("https://www.uprm.edu/cse/faculty/", driver.getCurrentUrl());
	}
	
	@Test
	void testAllMenusExist()  throws InterruptedException {
		fail("Test under construction");
	}
	
	@Test
	void testRequiredCoursesInCatalog()  throws InterruptedException {
		fail("Test under construction");
	}
	
	@Test
	void testCIIC3011HasSyllabus()  throws InterruptedException {
		fail("Test under construction");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}

