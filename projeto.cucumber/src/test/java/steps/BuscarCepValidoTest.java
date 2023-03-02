package steps;

import java.io.IOException;

import elementos.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BuscarCepValidoPage;
import runner.Executa;

public class BuscarCepValidoTest {

	BuscarCepValidoPage page = new BuscarCepValidoPage();
	Elementos elementos = new Elementos();
	Executa executa = new Executa();

	@Given("que esteja na homepage ok")
	public void queEstejaNaHomepageOk() {
		executa.abrirNavegador();
	}

	@Given("digito cep valido")
	public void digitoCepValido() throws IOException {
		page.aceitarCookies(elementos.btnCookies, "Aceitar Cookies");
		page.escreverCep(elementos.fieldCEP, "01120020", "Campo CEP", "Escrever CEP Valido", "./evidencias/BuscarCepValido/");
	}

	@When("clico no botao pesquisar ok")
	public void clicoNoBotaoPesquisarOk() {
		page.clicarBusca(elementos.btnBuscar, "Botão Buscar");
	}

	@Then("valido busca")
	public void validoBusca() throws IOException, InterruptedException {
		page.printarAbaAtiva("Resultado Busca OK", "./evidencias/BuscarCepValido/");
		page.validarMensagem(elementos.mensagemOk, "Resultado da Busca por Endereço ou CEP", "Label mensagem ok",
				"Resultado Busca Ok");
	}

}
