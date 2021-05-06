package Usuario;

import Classe.BigProjectA;

class PegarInformacoes {
	private int idUsuario;
	private String senhaUsuario;
	private String eMailUsuario;
	private int reputacaoUsuario;
	private String curriculoUsuario;
	private String tagUsuario; // creio que seria melhor fazer uma lista
	/* Fim usuario */

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String geteMailUsuario() {
		return eMailUsuario;
	}

	public void seteMailUsuario(String eMailUsuario) {
		this.eMailUsuario = eMailUsuario;
	}

	public int getReputacaoUsuario() {
		return reputacaoUsuario;
	}

	public void setReputacaoUsuario(int reputacaoUsuario) {
		this.reputacaoUsuario = reputacaoUsuario;
	}

	public String getCurriculoUsuario() {
		return curriculoUsuario;
	}

	public void setCurriculoUsuario(String curriculoUsuario) {
		this.curriculoUsuario = curriculoUsuario;
	}

	public String getTagUsuario() {
		return tagUsuario;
	}

	public void setTagUsuario(String tagUsuario) {
		this.tagUsuario = tagUsuario;
	}

}

public class Usuario {
	public static void main(String[] args) {
		
		BigProjectA vai= new BigProjectA();
		vai.conectarPost();
		vai.pegarUsuario();
	}

}
