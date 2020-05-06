package com.w2a.ZohoExtended.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.ZohoExtended.utilities.DriverManager;

public abstract class BasePage<T> {

	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverManager.getDriver();
	}

	public T openPage(Class<T> clazz) {
		 T page = null;
		AjaxElementLocatorFactory ajaxElementFactory = new AjaxElementLocatorFactory(driver, 10);
		page = PageFactory.initElements(driver, clazz);
		PageFactory.initElements(ajaxElementFactory,page);
		ExpectedCondition<WebElement> pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondition);
		return page;
	}

	private void waitForPageLoad(ExpectedCondition<WebElement> pageLoadCondition) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);
	}

	protected abstract ExpectedCondition<WebElement> getPageLoadCondition();

}
