package Testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Central.DSL;
import Central.DriverFactory;


public class TestePrime {

	private DSL dsl;
	
	@Before
	public void inicializa() {
		//DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt726:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt726:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt726:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		
		dsl.selecionarComboPrime("j_idt726:console", "Wii U");
		//dsl.clicarRadio(By.xpath("//select[@id='j_idt726:console_input']/../..//span"));
		//dsl.clicarRadio(By.xpath("//ul[@id='j_idt726:console_items']//li[.='PS4']"));
		Assert.assertEquals("Wii U", dsl.obterTexto("j_idt726:console_label"));

	}
	
}
