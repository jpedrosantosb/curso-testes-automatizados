package Testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Central.DSL;
import Central.DriverFactory;

public class TesteAlert {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void interagirComAlertSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		
		dsl.escreve("elementosForm:nome", texto);
	}
	
	@Test
	public void interagirComAlertConfirm() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
	
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertObterTextoENega());
	}
	
	@Test
	public void interagirComAlertPrompt() {
		
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
		
	}
}
