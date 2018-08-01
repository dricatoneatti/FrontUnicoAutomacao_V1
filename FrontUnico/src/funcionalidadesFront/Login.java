package funcionalidadesFront;

import static org.openqa.selenium.By.id;
import org.openqa.selenium.By;


public class Login extends AbstractRobot {

	public void login(String user, String password) {

//Clase AbstractRobot que possui os métodos click e sendKeys
		By cpf = id("LoginModel_Usuario");
		click(cpf);
		sendKeys(cpf, user);
		
		By senha = id("LoginModel_Senha");
		click(senha);
		sendKeys(senha, password);
		
		By dominio  = id("rdDominio");
		click(dominio);
		
		By buttonLogin = id("btnEfetuarLogin");
		click(buttonLogin);	

	}
	
	

}
