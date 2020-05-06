package com.w2a.ZohoExtended.setup;

import static com.w2a.ZohoExtended.utilities.DriverManager.getDriver;
import static com.w2a.ZohoExtended.utilities.DriverManager.setDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.w2a.ZohoExtended.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);

	@BeforeSuite
	public void setUpFramework() {
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "/src/test/resources/Properties/Config.properties");
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Configuration file loaded !!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setUpBrowser(String browser) {
		DriverFactory.setRemote(false);
		if (DriverFactory.isRemote()) {
			DesiredCapabilities cap = null;
			if (browser.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("ie")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplore");
				cap.setPlatform(Platform.WIN10);
			}
			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			if (browser.equals("chrome")) {
				System.out.println("Launching " + browser);
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver = new ChromeDriver();
			} else if ((browser.equals("firefox"))) {
				System.out.println("Launching " + browser);
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
