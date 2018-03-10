
package config;

//import org.openqa.selenium.WebDriver;

public class dadosAcesso {
	//WebDriver driver;

	//construtor
	public dadosAcesso() {
		
	}

	protected String usuarioEmail(){
		final String email;
		
		email = "avaliacao_qa_samba@sambatech.com.br";
		
		return email;
	}
	
	protected String usuarioSenha() {
		final String senha;
		
		senha = "123456789";
		
		return senha;
	}

}
