package Testes;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Central.DSL;
import Central.DriverFactory;

public class TesteCampoTreinamento {
	
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
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void testeTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "Kauan");
		Assert.assertEquals("Kauan", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Palmeiras");
		Assert.assertEquals("Palmeiras", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveIntergirComTextArea() {
		dsl.escreve("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:1");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:1"));
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:1"));
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "Doutorado");
		Assert.assertEquals("Doutorado", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void verificarValoresCombo() {
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	@Test
	public void verificarValoresComboMutiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Futebol", "O que eh esporte?")));
	}
	
	@Test
	public void interagirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValorElemento("buttonSimple"));	
	}
	
	@Test
	public void interagirComLinks() {
		dsl.clicarLink("Voltar");
		//Assert.fail();
		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void buscarTextosNaPagina() {
		//Assert.assertTrue(DriverFactory.getDriver().findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));;
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
	
	@Test
	public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		//js.executeScript("alert('Testando js via selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value= 'Escrito via js!!'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type= 'radio'");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela () {
	dsl.deveClicarBotaoTabela("Nome", "Doutorado", "Radio", "elementosForm:tableUsuarios");
	}
	
	
}

	
