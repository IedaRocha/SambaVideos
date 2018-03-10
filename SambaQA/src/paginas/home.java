package paginas;

import org.openqa.selenium.WebDriver;

public class home {
	WebDriver driver;
	String pagina = "http://web1.qa.sambatech.com:10000/";

	public home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;		
	}
	
	public void acessaHome() {
		
		driver.get(pagina); //carrega a página Home
		driver.manage().window().maximize(); //maximiza a janela
	}

}
