import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ExamPracticeTest {
	
	@DisplayName("Excercise 1")
	@ParameterizedTest
	@MethodSource("menuItemProvider")
	public void menuItemsCheck(String menuItem) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.uprm.edu/cse/");
		driver.manage().window().setSize(new Dimension(2528,1339));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			WebElement element = driver.findElement(By.xpath("//span[text()='"+ menuItem + "']"));
			assertEquals(element.getText(), menuItem);
		} catch(NoSuchElementException e) {
			fail(e.getMessage());
		}
		driver.quit();
	}
	
	static Arguments[] menuItemProvider() {
		return new Arguments[] {
				Arguments.arguments("Home"),
				Arguments.arguments("About Us"),
				Arguments.arguments("Academics"),
				Arguments.arguments("People"),
				Arguments.arguments("Students"),
				Arguments.arguments("News"),
				Arguments.arguments("Donations"),
		};
	}
	

	
	@DisplayName("Excercise 2")
	@ParameterizedTest
	@MethodSource("reqCourseProvider")
	public void requiredCoursesCheck(String course) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.uprm.edu/cse/course_catalog/");
		driver.manage().window().setSize(new Dimension(2528,1339));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			
			//Check if course is present in page h2
			WebElement courseInfoSpace = driver.findElement(By.xpath("//*[contains(text(),'" + course + "')]"));
			assertEquals(courseInfoSpace.getText(), course);
		}catch(NoSuchElementException e) {
			fail(e.getMessage());
		}
		driver.quit();
	}
	static Arguments[]reqCourseProvider() {
		return new Arguments[] {
				Arguments.arguments("CIIC 3011"),
				Arguments.arguments("CIIC 4010"),
				Arguments.arguments("CIIC 3075"),
				Arguments.arguments("CIIC 4020"),
				Arguments.arguments("INSO 4101"),
				Arguments.arguments("CIIC 3081"),
				Arguments.arguments("CIIC 4025"),
				Arguments.arguments("CIIC 4050"),
				Arguments.arguments("CIIC 4030"),
				Arguments.arguments("CIIC 5045"),
				Arguments.arguments("CIIC 4060"),
				Arguments.arguments("CIIC 4070"),
				Arguments.arguments("CIIC 5995"),
				Arguments.arguments("CIIC 4082"),
				Arguments.arguments("INSO 4115"),
				Arguments.arguments("INSO 4116"),
				Arguments.arguments("INSO 4117"),
				Arguments.arguments("INSO 4151")
		};
	}
	
	@DisplayName("Excercise 3")
	@Test
	public void checkIfCIIC3011HasSyllabus() {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.uprm.edu/cse/course_catalog/");
		driver.manage().window().setSize(new Dimension(2528,1339));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		try {
		
		//Check if there is a link that cointains CIIC-3011 in the page and if its showing
		WebElement syllabusLink = driver.findElement(By.cssSelector("a[href*='CIIC-3011']"));
		
		assertTrue(syllabusLink.isDisplayed());
		
		} catch (NoSuchElementException e) {
			fail(e.getMessage());
		}
		
		driver.quit();
	}

}
