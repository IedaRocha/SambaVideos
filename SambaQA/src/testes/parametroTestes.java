package testes;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.dadosAcesso;
import paginas.home;


public class parametroTestes {
	WebDriver driver;
	
	@Before
	//cria instancia do chrome driver
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/IEDA/Documents/Chrome Driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Teste iniciado.");
	}
	
	
	@After
	
	//fecha instancia do browser
	public void tearDown() {
		System.out.println("Teste finalizado.");
	//	driver.quit();
	}
	
	@Test
	//Teste 1
	public void teste1() {
		
		//acessa página Home
		home h = new home(driver);
		h.acessaHome();
		
	}
	

}
