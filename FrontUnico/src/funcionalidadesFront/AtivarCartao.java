package funcionalidadesFront;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AtivarCartao {
	public static void main(String[] args) throws Exception {

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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Clicando no menu, na opção "Cartões"
		driver.findElement(By.xpath("//a[contains(@codigomenu, '244')]")).click();
		// Clicando no menu, na opção "Ativar Cartão"
		driver.findElement(By.xpath("//a[contains(@codigomenu, '261')]")).click();
				
		// Criar um Array List que receba os dados da planilha do Excel em que é enviado
		// para a classe "LerExcel" a TERCEIRA COLUNA com os dados (1).
		ArrayList<String> lista = LerExcel.leituraCartao(0);

		// Para inserir todos os dados coletados pela classe LerExcel, criar um loop que
		// vá de 0 até o tamanho do array.
		for (int i = 1; i < lista.size(); i++) {
		driver.findElement(By.xpath("//input[@id='icl_filtroNumeroCartao']")).sendKeys(lista.get(i));
		driver.findElement(By.xpath("//*[contains(text(), 'OK')]")).click();
		
		//Simular impressao de termo para a ativação
		driver.findElement(By.id("dict_ImprimirTermo")).click();
		//Acessar o botão inativar
		driver.findElement(By.id("ict_btnGravar")).click();
		driver.findElement(By.xpath("//button[@type='button' and span='Sim']")).click();
		driver.findElement(By.xpath("//button[@type='button' and span='OK']")).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='button' and value='Fechar']")).click();
		driver.findElement(By.xpath("//button[@type='button' and value='Ativar']")).click();
		driver.findElement(By.xpath("//button[@type='button' and span='Sim']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// Comando para finalizar atendimento
		driver.findElement(By.xpath("//a[@id='icl_FinalizarCliente']")).click();

		// Confirmar fim de atendimento
		driver.findElement(By.xpath("//button[@type='button' and span='Sim']")).click();
		
		
	}

}
}