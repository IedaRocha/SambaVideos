package testes;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.dadosAcesso;
import paginas.home;
import paginas.login;
import paginas.monetizacao;


public class parametroTestes {
	WebDriver driver;
	
	@Before
	//cria instancia do chrome driver
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/IEDA/Documents/Chrome Driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Teste iniciado.");
		System.out.println();
	}
	
	
	@After
	
	//fecha instancia do browser
	public void tearDown() {
		System.out.println();
		System.out.println("Teste finalizado.");
		System.out.println();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
	//	driver.quit();
	}
/*	
	@Test
	//Teste 1 : Logar em Samba Vídeos com sucesso
	public void login() {
		String email;
		String senha;
		
		System.out.println("INÍCIO - Teste 1 : Logar em Samba Vídeos com sucesso");
		//obtém dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
		
		//acessa página Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na página
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenha(senha);
		log.acionaBtnEntrar();
		System.out.println("- Login efetuado com sucesso");		
		System.out.println("FIM - Teste 1 : Logar em Samba Vídeos com sucesso");
	}	


/*	@Test
	//Teste 2 : Logar com usuário válido e senha inválida
	public void loginInvalido() {
		String email;
		String senha;
		
		System.out.println("INÍCIO - Teste 2 : Logar com usuário válido e senha inválida");
		//obtém dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
				
		//acessa página Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na página
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenhaIncorreta(senha);
		log.acionaBtnEntrar();
		log.validaMsgSenhaIncorreta();
		System.out.println("FIM - Teste 2 : Logar com usuário válido e senha inválida");
	}  */

	@Test
	//Teste 3 : Alterar data de início da campanha
	public void alteraDtInicioCampanha() {
		String email;
		String senha;
		
		System.out.println("INÍCIO - Teste 3 : Alterar data de início da campanha");
		//obtém dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
		
		//acessa página Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na página
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenha(senha);
		log.acionaBtnEntrar();
		System.out.println("- Login efetuado com sucesso");	
		
		//acessar menu 'Monetização'
		monetizacao mnMonet = new monetizacao(driver);
		mnMonet.acessaMenuMonetizacao();
		
		//abre primeira campanha para alteração
		mnMonet.acessaCampanha();
		mnMonet.acessaMenuEdicaoCamp();
		mnMonet.editaCampanha();
		System.out.println("- Campanha aberta para edição");	
		
		
	}
	
}
