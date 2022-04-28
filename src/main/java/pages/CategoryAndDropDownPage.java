package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;


public class CategoryAndDropDownPage extends BasePage {

	WebDriver driver;

	public CategoryAndDropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='extra']/input[1]") WebElement categoryDataElement;
	@FindBy(how = How.XPATH, using = "//span[@id='extra']/input[2]") WebElement addCategoryElement;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']") WebElement dueDateDropdownElement;
	

	String insertedCategory;

	public void insertCategoryData(String categoryName) {
		String insertedCategory = categoryName + getRandomNum(99);
		categoryDataElement.sendKeys(insertedCategory);
		addCategoryElement.click();
		System.out.println(driver.getPageSource());
		Assert.assertTrue(driver.getPageSource().contains(insertedCategory), "The iserted category does not exist! ");
		
		
		
//Trial and error codes:

//	List<WebElement>categoryList= driver.findElements(By.xpath("/html/body/div[3]/a[@title='Remove this category']"));
//	List<WebElement>categoryList= driver.findElements(By.tagName("a"));
//	List<String>actualCategory=new ArrayList<String>();
//	
//	for (WebElement el: categoryList) {
//		String list= el.getText();
//		System.out.println(list);
//		Assert.assertEquals(list.contains(insertedCategory), insertedCategory);

//		List<String>insertOneCategory=new ArrayList<String>();
//		insertOneCategory.add(insertedCategory);		
//		for(int i=0; i<actualCategory.size(); i++) {
//			Assert.assertTrue(actualCategory.get(i).equals(expectdDropdownValues.get(i)));
//		}


	}

	public void validateDuplicatedCategory(String cName) {
		categoryDataElement.sendKeys(cName);
		addCategoryElement.click();
		
		
	WebElement we=driver.findElement(By.tagName("body"));
	String message= we.getText().split(":")[0];
	String actualMessage= message +":";
	
	WebElement we2= driver.findElement(By.xpath("/html/body/span[1]"));
	String actualText= we2.getText()+".";
	String actualDuplicateMessage= actualMessage +" "+actualText;
	
	Assert.assertEquals("The category you want to add already exists: myTest.", actualDuplicateMessage);

	}

//Trial & error codes:
//		waitForElement(driver, 10, we);
//		String[] str= we.getAttribute("innerHTML").split(":");
//		System.out.println(Arrays.toString(str));
	
//	String actualInsertedCategory= driver.findElement(By.xpath("/html/body/span[1]")).getText();
//	String duplicatedCategoryMessage= "The category you want to add already exists: "+ actualInsertedCategory +".";
//	WebDriverWait wait= new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions.visibilityOf(we)).getAttribute("innerHTML").splitlines()[1];
	



	public void validateMonthsFromDropdown() {
		Select sel = new Select(dueDateDropdownElement);

		List<WebElement> myDropdown = sel.getOptions();
		List<String> actualDropdownValues = new ArrayList<String>();

		for (WebElement w : myDropdown) {
			String allMonths = w.getText();
			actualDropdownValues.add(allMonths);
		}

		List<String> expectdDropdownValues = new ArrayList<String>();
		expectdDropdownValues.add("None");
		expectdDropdownValues.add("Jan");
		expectdDropdownValues.add("Feb");
		expectdDropdownValues.add("Mar");
		expectdDropdownValues.add("Apr");
		expectdDropdownValues.add("May");
		expectdDropdownValues.add("Jun");
		expectdDropdownValues.add("Jul");
		expectdDropdownValues.add("Aug");
		expectdDropdownValues.add("Sep");
		expectdDropdownValues.add("Oct");
		expectdDropdownValues.add("Nov");
		expectdDropdownValues.add("Dec");

		for (int i = 0; i < actualDropdownValues.size(); i++) {
	//		System.out.println("Actual: " + actualDropdownValues + "& Expected: " + expectdDropdownValues);
			Assert.assertTrue(actualDropdownValues.get(i).equals(expectdDropdownValues.get(i)));
		}

	}

}
