package com.w2a.ZohoExtended.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;
import com.w2a.ZohoExtended.PageObjects.ZohoHomePage;
import com.w2a.ZohoExtended.PageObjects.ZohoLoginPage;
import com.w2a.ZohoExtended.setup.BaseTest;
import com.w2a.ZohoExtended.utilities.Constants;
import com.w2a.ZohoExtended.utilities.DataProviders;
import com.w2a.ZohoExtended.utilities.DataUtil;
import com.w2a.ZohoExtended.utilities.DriverManager;
import com.w2a.ZohoExtended.utilities.ExcelReader;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void loginTest(Hashtable<String, String> data) {
		ExcelReader reader = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("RunMode"), reader);
		setUpBrowser(data.get("browser"));
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
		ZohoLoginPage login = home.goToLogin();
		login.doLogin(data.get("userName"), data.get("password"));
		DriverManager.quitBrowser();
	}

}
