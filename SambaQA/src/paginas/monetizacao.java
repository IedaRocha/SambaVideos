package paginas;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class monetizacao {
	WebDriver driver;
	
	@FindBy (how = How.ID, using = "mn-monetization")
	WebElement mnMonetizacao; //menu Monetização
		
	@FindBy (how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/section/table/tbody/tr[1]/td[1]/dl/dt/a")
	WebElement lknCampanha; //link primeira campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"monetization-statistics\"]/tbody/tr[1]/td/div/div[2]/a/span")
	WebElement mnConfigCamp; //menu de configuração da campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"monetization-statistics\"]/tbody/tr[1]/td/div/div[2]/ul/li[1]/a")
	WebElement mnEditCampanha; //subMenu Editar Campanha
	
	@FindBy (how = How.ID, using = "publishDate")
	WebElement dtInicio; //data de início de veiculação da campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[2]/form/div/div[1]/div/div[1]/div/label/input")
	WebElement categoria; //radio Categorias da campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[2]/form/div/div[1]/div/div[2]/div/label/input")
	WebElement genero; //radio Gênero da campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[3]/form/div[2]/div/div[2]/div/select")
	WebElement garantiaEntrega; //Combo Garantia de entrega da campanha
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[1]/form/div[2]/div/div/div[1]/div/input")
	WebElement preRoll; //radio Pre roll
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[1]/form/div[2]/div/div/div[2]/div/input")
	WebElement postRoll; //radio Post roll	

	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[3]/form/div[1]/div/div/div[1]/div[2]/div/label/input")
	WebElement impressao; //radio do campo 'Por impressão'
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"new-campaign\"]/article[3]/form/div[1]/div/div/div[2]/div[2]/div/label/input")
	WebElement clique; //radio do campo 'Por clique'
	
	
	//construtor
	public monetizacao(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //cria os webElements
	}

	//acessa menu Monetização
	public void acessaMenuMonetizacao() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.mnMonetizacao.click();
	}
	
	//acessar campanha
	public void acessaCampanha() {
		this.lknCampanha.click();		
	}
	
	//abre menu para edição da campanha
	public void acessaMenuEdicaoCamp() {
		this.mnConfigCamp.click();
	}
	
	//editar campanha
	public void editaCampanha() {
		this.mnEditCampanha.click();
	}
	
	/*
	 * verifica se campo é somente leitura; 
	 * Campo/cmp deve ser identificado pelo label da página monetização
	 */
	public void verificaSomenteLeitura(String cmp) {
		boolean habilitado = false;
		String campo = cmp;
		
		switch (campo) {
		case "Início": 
			habilitado = this.dtInicio.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);			
			break;
		case "Categorias":	
			habilitado = this.categoria.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Pre Roll":	
			habilitado = this.preRoll.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Post Roll":	
			habilitado = this.postRoll.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Gênero":	
			habilitado = this.genero.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Por impressão":	
			habilitado = this.impressao.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Por clique":	
			habilitado = this.clique.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		case "Garantia de entrega":
			habilitado = this.garantiaEntrega.isEnabled();
			//Exibe 'true' se campo está habilitado; exibe 'false' se campo está desabilitado
			System.out.println("- '" + campo + "' habilitado(a): "+ habilitado);
			break;
		default: System.out.println("Não foi possível verificar o campo" + campo); 
			break;
		}		
	}
}











