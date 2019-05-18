package com.RepoExamPractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ExamRepoTest {

	@Test
	void testCanVisitFacultyPageMenu() throws InterruptedException {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface, 
		// not the implementation.
		WebDriver driver = new ChromeDriver();

		// And now use this to visit Google
		driver.get("http://cse.uprm.edu");
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

		//Close the browser
		driver.quit();
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

}

