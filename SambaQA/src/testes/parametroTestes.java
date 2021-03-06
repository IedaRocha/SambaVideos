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
		System.out.println();
	}
	
	
	@After	
	//fecha instancia do browser
	public void tearDown() {
		System.out.println();
		System.out.println();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@Test
	//Teste 1 : Logar em Samba V�deos com sucesso
	public void login() {
		String email;
		String senha;
		
		System.out.println("IN�CIO - Teste 1 : Logar em Samba V�deos com sucesso");
		//obt�m dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
		
		//acessa p�gina Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na p�gina
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenha(senha);
		log.acionaBtnEntrar();
		System.out.println("- Login efetuado com sucesso");		
		System.out.println("FIM - Teste 1 : Logar em Samba V�deos com sucesso");
	}	


	@Test
	//Teste 2 : Logar com usu�rio v�lido e senha inv�lida
	public void loginInvalido() {
		String email;
		String senha;
		
		System.out.println("IN�CIO - Teste 2 : Logar com usu�rio v�lido e senha inv�lida");
		//obt�m dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
				
		//acessa p�gina Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na p�gina
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenhaIncorreta(senha);
		log.acionaBtnEntrar();
		log.validaMsgSenhaIncorreta();
		System.out.println("FIM - Teste 2 : Logar com usu�rio v�lido e senha inv�lida");
	}  

	@Test
	//Teste 3 : Validar campo 'In�cio' desabilitado
	public void validaDtInicioCampanha() {
		String email; //email para login
		String senha; //senha para login
		
		System.out.println("IN�CIO - Teste 3 : Validar campo 'In�cio' desabilitado");
		//obt�m dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
		
		//acessa p�gina Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na p�gina
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenha(senha);
		log.acionaBtnEntrar();
		System.out.println("- Login efetuado com sucesso");	
		
		//acessa menu 'Monetiza��o'
		monetizacao mnMonet = new monetizacao(driver);
		mnMonet.acessaMenuMonetizacao();
		
		//abre primeira campanha para altera��o
		mnMonet.acessaCampanha();
		mnMonet.acessaMenuEdicaoCamp();
		mnMonet.editaCampanha();
		System.out.println("- Campanha aberta para edi��o");	
		
		//verifica se campo 'In�cio' � somente leitura
		mnMonet.verificaSomenteLeitura("In�cio");
		System.out.println("FIM - Teste 3 : Validar campo 'In�cio' desabilitado");
	}
	
	@Test
	//Test 4 : Validar campo 'Impress�es' desabilitado
	public void criaCanal() {
		String email; //email para login
		String senha; //senha para login
		
		System.out.println("IN�CIO - Teste 4 : Validar campo 'Impress�es' desabilitado");
		//obt�m dados de acesso
		dadosAcesso dados = new dadosAcesso();
		email = dados.usuarioEmail();
		senha = dados.usuarioSenha();
		
		//acessa p�gina Home
		home h = new home(driver);
		h.acessaHome();
				
		//loga na p�gina
		login log = new login(driver);
		log.preencheEmail(email);
		log.preencheSenha(senha);
		log.acionaBtnEntrar();
		System.out.println("- Login efetuado com sucesso");
		
		//acessa menu 'Monetiza��o'
		monetizacao mnMonet = new monetizacao(driver);
		mnMonet.acessaMenuMonetizacao();
		
		//abre primeira campanha para altera��o
		mnMonet.acessaCampanha();
		mnMonet.acessaMenuEdicaoCamp();
		mnMonet.editaCampanha();
		System.out.println("- Campanha aberta para edi��o");	
			
		//verifica se campo 'Impress�o' � somente leitura
		mnMonet.verificaSomenteLeitura("Por impress�o");
		
		System.out.println("FIM - Teste 4 : Validar campo 'Impress�es' desabilitado");
	}	
}
