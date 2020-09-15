package Suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Central.DriverFactory;
import Testes.TestarRegrasCadastro;
import Testes.TesteCadastro;


@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class, 
	TestarRegrasCadastro.class
})
public class SuiteTeste {
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}

}