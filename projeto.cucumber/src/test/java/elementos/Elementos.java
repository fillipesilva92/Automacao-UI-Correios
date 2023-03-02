package elementos;

import org.openqa.selenium.By;

public class Elementos {

	public By fieldCEP = By.xpath("//input[@id='relaxation']");
	public By btnBuscar = By.xpath("//div[@style='order: 1']//button[@class='bt-link-ic']//i");
	public By mensagemOk = By.xpath("//div[@id='mensagem-resultado']//h5");
	public By mensagemErro = By.xpath("//div[@id='mensagem-resultado-alerta']//h6");
	public By btnCookies = By.xpath("//a[@id='btnCookie']");
	public By btnNovaBusca = By.xpath("//button[@id='btn_nbusca']");
}
