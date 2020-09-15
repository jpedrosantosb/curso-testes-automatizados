package Testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Central.DSL;
import Central.DriverFactory;


public class TesteFrames {

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
	public void interagirComFrames () {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void interagirComJanela () {	
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		DriverFactory.getDriver().close();
		dsl.trocarJanela("");
		dsl.escreve(By.tagName("textarea"), "E agora?");
	}
	
	@Test
	public void interagirComJanelaSemTitulo () {
		DriverFactory.getDriver().findElement(By.id("buttonPopUpHard")).click();
		System.out.println(DriverFactory.getDriver().getWindowHandle());
		System.out.println(DriverFactory.getDriver().getWindowHandles());
		DriverFactory.getDriver().switchTo().window((String)DriverFactory.getDriver().getWindowHandles().toArray()[1]);
		DriverFactory.getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		DriverFactory.getDriver().switchTo().window((String)DriverFactory.getDriver().getWindowHandles().toArray()[0]);
		DriverFactory.getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
}
