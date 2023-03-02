package steps;

import java.io.IOException;

import elementos.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BuscarCepInexistentePage;
import runner.Executa;

public class BuscarCepInexistenteTest {

	BuscarCepInexistentePage page = new BuscarCepInexistentePage();
	Elementos elementos = new Elementos();
	Executa executa = new Executa();

	@Given("que esteja na homepage")
	public void queEstejaNaHomepage() {
		executa.abrirNavegador();
	}

	@Given("digito cep inexistente")
	public void digitoCepInexistente() throws IOException {
		page.aceitarCookies(elementos.btnCookies, "Aceitar Cookies");
		page.escreverCep(elementos.fieldCEP, "00000000", "Campo CEP", "Escrever CEP Inexistente", "./evidencias/BuscarCepInexistente/");
	}

	@When("clico no botao pesquisar")
	public void clicoNoBotaoPesquisar() {
		page.clicarBusca(elementos.btnBuscar, "Botão Buscar");
	}

	@Then("sistema retorna erro")
	public void sistemaRetornaErro() throws IOException, InterruptedException {
		page.printarAbaAtiva("Resultado Busca com Erro", "./evidencias/BuscarCepInexistente/");
		page.validarMensagem(elementos.mensagemErro, "Dados não encontrado", "Label mensagem de erro",
				"Resultado Busca com Erro");
	}

}
