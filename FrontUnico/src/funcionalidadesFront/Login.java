package funcionalidadesFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	
	public void login(String user,String password) {
		
		WebDriver driver = new ChromeDriver();
		
	WebElement	user1 = driver.findElement(By.id("LoginModel_Usuario"));
	user1.click();
	user1.sendKeys("44786992836");
		
	WebElement password1 = driver.findElement(By.id("LoginModel_Senha"));
	password1.click();
	password1.sendKeys("Cog2018@");
		
	driver.findElement(By.id("rdDominio")).click();
	driver.findElement(By.id("btnEfetuarLogin")).click();
		
	}
}
