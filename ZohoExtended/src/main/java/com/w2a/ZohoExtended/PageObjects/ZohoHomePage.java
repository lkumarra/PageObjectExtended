package com.w2a.ZohoExtended.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.ZohoExtended.utilities.DriverManager;

public class ZohoHomePage extends BasePage{

	@FindBy(css = ".zh-login")
	private WebElement loginLink;

	public ZohoHomePage open(String url) {
		DriverManager.getDriver().get(url);
		return (ZohoHomePage) openPage(ZohoHomePage.class);
	}

	public ZohoLoginPage goToLogin() {
		loginLink.click();
		return (ZohoLoginPage) openPage(ZohoLoginPage.class);
	}

	@Override
	protected ExpectedCondition<WebElement> getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginLink);
	}

}
