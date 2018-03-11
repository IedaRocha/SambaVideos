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


	@Test
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
	}  

	@Test
	//Teste 3 : Validar campo 'Início' desabilitado
	public void validaDtInicioCampanha() {
		String email; //email para login
		String senha; //senha para login
		
		System.out.println("INÍCIO - Teste 3 : Validar campo 'Início' desabilitado");
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
		
		//acessa menu 'Monetização'
		monetizacao mnMonet = new monetizacao(driver);
		mnMonet.acessaMenuMonetizacao();
		
		//abre primeira campanha para alteração
		mnMonet.acessaCampanha();
		mnMonet.acessaMenuEdicaoCamp();
		mnMonet.editaCampanha();
		System.out.println("- Campanha aberta para edição");	
		
		//verifica se campo 'Início' é somente leitura
		mnMonet.verificaSomenteLeitura("Início");
		System.out.println("FIM - Teste 3 : Validar campo 'Início' desabilitado");
	}
	
	@Test
	//Test 4 : Validar campo 'Impressões' desabilitado
	public void criaCanal() {
		String email; //email para login
		String senha; //senha para login
		
		System.out.println("INÍCIO - Teste 4 : Validar campo 'Impressões' desabilitado");
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
		
		//acessa menu 'Monetização'
		monetizacao mnMonet = new monetizacao(driver);
		mnMonet.acessaMenuMonetizacao();
		
		//abre primeira campanha para alteração
		mnMonet.acessaCampanha();
		mnMonet.acessaMenuEdicaoCamp();
		mnMonet.editaCampanha();
		System.out.println("- Campanha aberta para edição");	
			
		//verifica se campo 'Impressão' é somente leitura
		mnMonet.verificaSomenteLeitura("Por impressão");
		
		System.out.println("FIM - Teste 4 : Validar campo 'Impressões' desabilitado");
	}	
}
