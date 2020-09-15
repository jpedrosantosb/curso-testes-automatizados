package Testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Central.DSL;
import Central.DriverFactory;

public class TesteAjax {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escreve("j_idt725:name", "teste JP");
		dsl.clicarBotao("j_idt725:j_idt728");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt725:display"), "teste JP"));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt803_start")));
		Assert.assertEquals("teste JP", dsl.obterTexto(By.id("j_idt725:display")));
	}

}
