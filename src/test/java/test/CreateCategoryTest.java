package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CategoryAndDropDownPage;
import util.BrowserFactory;

public class CreateCategoryTest {

	WebDriver driver;
	
	@Test(priority=0)
	@Parameters({"categoryName"})
	public void userShouldBeAbleToAddCategory(String strName) {
		driver= BrowserFactory.init();
		
		CategoryAndDropDownPage categoryAndDropDownPage= PageFactory.initElements(driver, CategoryAndDropDownPage.class); 
		categoryAndDropDownPage.insertCategoryData(strName);
		
	}
	
	
}
