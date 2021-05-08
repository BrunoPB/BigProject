package Empresa;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import Classe.BigProjectA;

public class Empresa {

	private int idEmpresa;
	private String nomeEmpresa;
	private String eMailEmpresa;
	private String senhaEmpresa;

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String geteMailEmpresa() {
		return eMailEmpresa;
	}

	public void seteMailEmpresa(String eMailEmpresa) {
		this.eMailEmpresa = eMailEmpresa;
	}

	public String getSenhaEmpresa() {
		return senhaEmpresa;
	}

	public void setSenhaEmpresa(String senhaEmpresa) {
		this.senhaEmpresa = senhaEmpresa;
	}

	public Empresa(int idEmpresa, String nomeEmpresa, String eMailEmpresa, String senhaEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.eMailEmpresa = eMailEmpresa;
		this.senhaEmpresa = senhaEmpresa;
	}

	public Empresa() {
		this(0, " ", " ", " ");
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", eMailEmpresa=" + eMailEmpresa
				+ ", senhaEmpresa=" + senhaEmpresa + "]";
	}

	public static void main(String[] args) {
		
		 Teste oia = new Teste();
		 get("/site", (req, res) -> oia.renderContent("home.html"));
		Scanner ler = new Scanner(System.in);
		BigProjectA conectar = new BigProjectA();
		conectar.conectarPost(); // para conectar
		int x = ler.nextInt();
		if (x == 1) {
			Empresa empresaPhpAdmin = conectar.pegarEmpresa();
			// System.out.println(empresaPhpAdmin.toString());
			fazerteste(empresaPhpAdmin);
		} else if (x == 2) {
			Empresa mandarParaPhpAdmin = new Empresa();
			conectar.inserirEmpresa(mandarParaPhpAdmin);
		} else {
			Empresa empresaPhpAdmin = conectar.pegarEmpresa();

			String receberSenha = "ttt";
			if (receberSenha == empresaPhpAdmin.getSenhaEmpresa()) {
				System.out.println("Mesma senha");
			}
			String receberEmail = "bruno@gmail.com";
			if (receberEmail == empresaPhpAdmin.geteMailEmpresa()) {
				System.out.println("Mesmo email");
			}
			Empresa atualizarEmpresa = new Empresa(empresaPhpAdmin.getIdEmpresa(), empresaPhpAdmin.getNomeEmpresa(),
					receberEmail, receberSenha);
			conectar.atualizarEmpresa(atualizarEmpresa);
		}
		ler.close();

	}

	public static void fazerteste(Empresa empresaPhpAdmin) {
		System.out.println("ola22");
		get("/empresa1", (request, response) -> empresaPhpAdmin.toString());

	}

}

class Teste {

	public String renderContent(String htmlFile) throws IOException, URISyntaxException {
		return new String(Files.readAllBytes(Paths.get(getClass().getResource(htmlFile).toURI())),
				StandardCharsets.UTF_8);
	}
}

/*
 * id/empresa senha projetos dinheiro
 */