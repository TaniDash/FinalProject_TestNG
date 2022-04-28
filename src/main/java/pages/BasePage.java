package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int getRandomNum(int boundaryNum) {
		Random rn= new Random();
		int generatedRandom= rn.nextInt(boundaryNum);
		return generatedRandom;
	}
	
	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
