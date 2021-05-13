package Empresa;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import Classe.BigProjectA;

public class Empresa {

	private int idEmpresa;
	private String nomeEmpresa;
	private String eMailEmpresa;
	private String senhaEmpresa;
	private String imagemEmpresa;

	public String getImagemEmpresa() {
		return imagemEmpresa;
	}

	public void setImagemEmpresa(String imagemEmpresa) {
		this.imagemEmpresa = imagemEmpresa;
	}

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

	public Empresa(int idEmpresa, String nomeEmpresa, String eMailEmpresa, String senhaEmpresa,String img) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.eMailEmpresa = eMailEmpresa;
		this.senhaEmpresa = senhaEmpresa;
		this.imagemEmpresa=img;
	}

	public Empresa() {
		this(0, " ", " ", " "," ");
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", eMailEmpresa=" + eMailEmpresa
				+ ", senhaEmpresa=" + senhaEmpresa + ", imagemEmpresa=" + imagemEmpresa + "]";
	}
}



/*
 * id/empresa senha projetos dinheiro
 */