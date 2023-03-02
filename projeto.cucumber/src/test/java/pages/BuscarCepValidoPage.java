package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import metodos.MetodosDeTestes;

public class BuscarCepValidoPage {

	MetodosDeTestes metodos = new MetodosDeTestes();

	public void escreverCep(By elemento, String texto, String campo, String nomeEvidencia, String diretorio) throws IOException {
		metodos.escrever(elemento, texto, campo);
		metodos.tirarEvidencia(nomeEvidencia, diretorio);
	}

	public void aceitarCookies(By elemento, String campo) {
		metodos.clicar(elemento, campo);
	}

	public void clicarBusca(By elemento, String campo) {
		metodos.espera(elemento);
		metodos.clicar(elemento, campo);
	}

	public void printarAbaAtiva(String nomeEvidencia, String diretorio) throws IOException {
		metodos.trocarAba();
		metodos.tirarEvidencia(nomeEvidencia, diretorio);
	}

	public void validarMensagem(By elemento, String textoEsperado, String campo, String nomeEvidencia) {
		metodos.validarTexto(elemento, textoEsperado, campo);

	}

}
