package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CategoryAndDropDownPage;
import util.BrowserFactory;

public class DuplicateCategoryTest {
	WebDriver driver;
	
	@Test(priority=1)
	@Parameters({"categoryName"})
	public void userShouldNotBeAbleToAddDuplicateCategory(String name) {
		driver= BrowserFactory.init();
		
		CategoryAndDropDownPage categoryAndDropDownPage= PageFactory.initElements(driver, CategoryAndDropDownPage.class); 
		categoryAndDropDownPage.validateDuplicatedCategory(name);
		
	}
	
}
