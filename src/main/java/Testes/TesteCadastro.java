package Testes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Central.BaseTest;
import Central.DriverFactory;
import Page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@Test
	public void desafioCadastro() {
		page.setNome("João Pedro");
		page.setSobrenome("Bastos");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!" ,page.obterResultadoCadastro());
		Assert.assertEquals("João Pedro", page.obterNomeCadastro());
		Assert.assertEquals("Bastos", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Frango", page.obterComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Futebol", page.obterEsporteCadastro());
		
	}
	/*
	@Test
	public void validarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void validarSobrenomeObrigatorio() {
		page.setNome("João Pedro");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void validarSexoObrigatorio() {
		page.setNome("João Pedro");
		page.setSobrenome("Bastos");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void validarComidaFavorita() {
		page.setNome("João Pedro");
		page.setSobrenome("Bastos");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	
	@Test
	public void validarEsportistaIndeciso() {
		
		page.setNome("João Pedro");
		page.setSobrenome("Bastos");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsporte("Futebol", "O que eh esporte?");
		page.setEsporte("O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}*/
	
}