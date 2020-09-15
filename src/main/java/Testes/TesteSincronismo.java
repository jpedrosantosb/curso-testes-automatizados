package Testes;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Central.DSL;
import Central.DriverFactory;



public class TesteSincronismo {

	private DSL dsl;
	
	@Before
	public void inicializa() {
		//DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escreve("novoCampo", "Palmeiras tem Mundial");
		Assert.assertEquals("Palmeiras tem Mundial", dsl.obterValorCampo("novoCampo"));
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.escreve("novoCampo", "Palmeiras tem Mundial");
		Assert.assertEquals("Palmeiras tem Mundial", dsl.obterValorCampo("novoCampo"));
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escreve("novoCampo", "Palmeiras tem Mundial");
		Assert.assertEquals("Palmeiras tem Mundial", dsl.obterValorCampo("novoCampo"));
	}
	
	
}
