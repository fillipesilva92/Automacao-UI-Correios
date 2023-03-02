package metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import conexoes.DriversFactory;

public class MetodosDeTestes extends DriversFactory {

	public void clicar(By elemento, String campo) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("*********Erro ao tentar clicar no campo*********" + campo);
			System.err.println("*********Causa do erro*********" + e.getCause());
			System.err.println("*********Mensagem de erro*********" + e.getMessage());
		}

	}

	public void escrever(By elemento, String texto, String campo) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("*********Erro ao tentar escrever no campo*********" + campo);
			System.err.println("*********Causa do erro*********" + e.getCause());
			System.err.println("*********Mensagem de erro*********" + e.getMessage());
		}
	}

	public void validarTexto(By elemento, String textoEsperado, String campo) {
		try {
			String textoCapturado = driver.findElement(elemento).getText();
			assertTrue(textoCapturado.contains(textoEsperado));
		} catch (Exception e) {
			System.err.println("*********Erro ao tentar escrever no campo*********" + campo);
			System.err.println("*********Causa do erro*********" + e.getCause());
			System.err.println("*********Mensagem de erro*********" + e.getMessage());
		}

	}

	public void tirarEvidencia(String nomeEvidencia, String diretorio) throws IOException {
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(diretorio + nomeEvidencia + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public void espera(By elemento) {
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public void trocarAba() {
		Set<String> handles = driver.getWindowHandles();
		Iterator it = handles.iterator();
		String parentId = (String) it.next();
		String childId = (String) it.next(); 
		driver.switchTo().window(childId);
	}

}
