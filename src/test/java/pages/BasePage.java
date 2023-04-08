package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static utilities.DriverSetup.getDriver;

import java.time.Duration;
import java.util.List;

public class BasePage {
	
	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}
	
	public void clickOnElement(By locator) {
		getElement(locator).click();
	}
	
	public String getElementText(By locator) {
	    return getElement(locator).getText();
	}
	
	public void writeTextOnElement(By locator, String text) {
		getElement(locator).sendKeys(text);
	}

	public List<WebElement> getVisibleElements(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

}
