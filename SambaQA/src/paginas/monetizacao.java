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

}
