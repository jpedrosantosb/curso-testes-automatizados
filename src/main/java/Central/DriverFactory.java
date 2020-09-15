package Central;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\joão Pedro\\Downloads\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\joão Pedro\\Downloads\\geckodriver.exe");
			switch(Propriedades.browser) {
				case CHROME: driver = new ChromeDriver();
				case FIREFOX: driver = new FirefoxDriver();
			}
			driver.manage().window().setSize(new Dimension(1300, 1200));
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
