package com.w2a.ZohoExtended.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.w2a.ZohoExtended.utilities.Utilities.*;

public class ZohoLoginPage extends BasePage{

	public ZohoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#login_id")
	private WebElement loginID;

	@FindBy(css = "button[id = 'nextbtn'][class = 'btn blue']")
	private WebElement nextButton;

	@FindBy(css = "#password")
	private WebElement passwordField;

	@FindBy(css = "button[id = 'nextbtn'][class = 'btn blue']")
	private WebElement signInButton;
	
	public ZohoLoginPage doLogin(String userName, String password) {
		loginID.sendKeys(userName);
		sleep(3000);
		nextButton.click();
		sleep(3000);
		passwordField.sendKeys(password);
		sleep(3000);
		signInButton.click();
		return this;
	}

	@Override
	protected ExpectedCondition<WebElement> getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginID);
	}

}
