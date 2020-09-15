package Testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteGoogle {
	 
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\joão Pedro\\Downloads\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joão Pedro\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void teste() {
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
}
