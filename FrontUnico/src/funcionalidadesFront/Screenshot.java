package funcionalidadesFront;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) {
		File screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File(fileWithPath));
		} catch (Exception e) {
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
		}
	}

}
