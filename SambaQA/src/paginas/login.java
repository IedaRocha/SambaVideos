package paginas;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;
	
	@FindBy (how = How.ID, using = "inputEmail")
	WebElement txtEmail;
	
	@FindBy (how = How.ID, using = "inputPassword")
	WebElement txtSenha;
	
	@FindBy (how = How.ID, using = "login")
	WebElement btnLogin;
	
	@FindBy (how = How.ID, using = "password_incorrect")
	WebElement msgPwsIncorreta;
	

	//construtor
	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //cria os webElements		
	}	

	//preenche email
	public void preencheEmail(String email) {
		this.txtEmail.sendKeys(email);
	}
	
	//preenche senha
	public void preencheSenha(String senha) {
		this.txtSenha.sendKeys(senha);
	}
	
	//aciona botão "Entrar"
	public void acionaBtnEntrar() {
		this.btnLogin.click();
	}	
	
	//preenche senha incorreta
	public void preencheSenhaIncorreta(String senha) {
		this.txtSenha.sendKeys(senha + "a");
	}
	
	//valida mensagem de senha incorreta
	public void validaMsgSenhaIncorreta() {
		boolean apresentouMsg;
		String msg = "Email ou senha incorretos.";
		
		//verifica se foi apresentada a mensagem de erro 'Email ou senha incorretos. '
		apresentouMsg = driver.getPageSource().contains(msg);
		
		Assert.assertTrue(apresentouMsg);
			System.out.println("- Sistema exibiu mensagem '" + msg + "'");
	}
}
