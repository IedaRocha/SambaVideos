
package config;


public class dadosAcesso {

	private String email;
	private String senha;
	
	//construtor
	public dadosAcesso() {
		
	}

	public String usuarioEmail(){
		
		this.email = "avaliacao_qa_samba@sambatech.com.br";
		
		return email;
	}
	
	public String usuarioSenha() {		
		
		this.senha = "123456789";
		
		return senha;
	}

}
