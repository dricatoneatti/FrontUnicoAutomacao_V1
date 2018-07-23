package funcionalidadesFront;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ConsultaDadosCartao {
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

		// No combo de class inputText valid, escolher a op��o pelo nome visivel
		WebElement campoUnidade = popupUnidade.findElement(By.name("LoginModel.Hierarquia"));
		new Select(campoUnidade).selectByVisibleText("Lojas > SP1 > 2SPP - Pinheiros");

		driver.findElement(By.id("btnConcluirAutenticacao")).click();

		// Espera
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Inicio do Teste, onde esta identificando o cliente por pesquisa do numero de
		// cartao

		driver.findElement(By.xpath("//a[contains(@id,'icl_IdentificaCliente')]")).click();

		// Criar um Array List que receba os dados da planilha do Excel em que � enviado
		// para a classe "LerExcel" a PRIMEIRA COLUNA com os dados (0).
		ArrayList<String> lista = LerExcel.leituraCartao(0);

		// Para inserir todos os dados coletados pela classe LerExcel, criar um loop que
		// v� de 0 at� o tamanho do array.
		for (int i = 1; i < lista.size(); i++) {
			driver.findElement(By.xpath("//input[@id='icl_filtroNumeroCartao']")).sendKeys(lista.get(i));
			driver.findElement(By.xpath("//*[contains(text(), 'OK')]")).click();

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
			// Acessando no menu da tabela, os dados do cart�o
			driver.findElement(By.xpath("//a[contains(@id,'tabDadosCartao')]")).click();
			driver.findElement(By.xpath("//a[contains(@id,'tabDadosCartao')]")).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Evidencia que recebe o comando das classes: Screenshot e Generator
			Screenshot.takeSnapShot(driver, "C:\\Users\\640244\\Documents\\IniciativaCSF\\Screenshots\\ConsultaDadosCartao\\"
					+ GeneratorScr.dataHoraArquivo() + " ConsultaDadosCartao.png");

			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			// Comando para finalizar atendimento
			driver.findElement(By.xpath("//a[@id='icl_FinalizarCliente']")).click();

			// Confirmar fim de atendimento
			driver.findElement(By.xpath("//button[@type='button' and span='Sim']")).click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Comando para iniciar o preenchimento do proximo cartao da lista do excel
			driver.findElement(By.xpath("//a[@id='icl_IdentificaCliente']")).click();

		}

		driver.close();
		driver.quit();
	}
}
