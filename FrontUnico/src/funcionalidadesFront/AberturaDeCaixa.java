package funcionalidadesFront;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AberturaDeCaixa {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\640244\\eclipse-workspace\\FrontUnico\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Instanciar o site do Front Unico com o WebDriver
		driver.get("http://10.113.75.9/FUN/Principal.mvc/");

		// Efetuando o Login
		WebElement user = driver.findElement(By.id("LoginModel_Usuario"));
		user.click();
		user.sendKeys("44786992836");

		// Efetuando o Login
		WebElement password = driver.findElement(By.id("LoginModel_Senha"));
		password.click();
		password.sendKeys("Cog2018@");

		driver.findElement(By.id("rdDominio")).click();

		driver.findElement(By.id("btnEfetuarLogin")).click();

		// Identificando a popup onde esta dentro da div de id selecaoHierarquias:
		WebElement popupUnidade = driver.findElement(By.id("selecaoHierarquias"));

		// No combo de class inputText valid, escolher a opção pelo nome visivel
		WebElement campoUnidade = popupUnidade.findElement(By.name("LoginModel.Hierarquia"));
		new Select(campoUnidade).selectByVisibleText("Lojas > SP1 > 2SPP - Pinheiros");

		driver.findElement(By.id("btnConcluirAutenticacao")).click();

		// Espera
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@codigomenu,'251')]")).click();

		// Mouse Over function: para localizar a opção que só é visivel pelo mouse
		Actions action = new Actions(driver);
		WebElement opçao = driver.findElement(By.xpath("//a[contains(@codigomenu,'431')]"));
		action.moveToElement(opçao).moveToElement(driver.findElement(By.xpath("//a[contains(@codigomenu,'433')]")))
				.click().build().perform();

		//Condição para verificar se o caixa esta aberto
		if (driver.findElement(
				By.xpath("//*[contains(text(), '1.02.01.46.01.01.00006 - Para realizar a abertura do caixa,"
						+ " o fechamento deve ser realizado.')]")) != null) {
			System.out.println("O caixa já esta aberto!");
			
		//Aguardando caixa fechado para inserir um "ELSE" com os comandos para abertura
			}

	}
}
