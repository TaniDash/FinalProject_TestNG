package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.CategoryAndDropDownPage;
import util.BrowserFactory;

public class MonthDropDownTest {

	WebDriver driver;
	
	@Test(priority=2)
	public void userShouldBeAbleToValidateMonthsDropdown() {
		driver= BrowserFactory.init();
		
		CategoryAndDropDownPage categoryAndDropDownPage= PageFactory.initElements(driver, CategoryAndDropDownPage.class); 
		categoryAndDropDownPage.validateMonthsFromDropdown();
		
	}
}
