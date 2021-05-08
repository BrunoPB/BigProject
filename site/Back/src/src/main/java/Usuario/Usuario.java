package Usuario;

import Classe.BigProjectA;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String senhaUsuario;
	private String eMailUsuario;
	private int reputacaoUsuario;
	private String curriculoUsuario;
	private String tagUsuario; // creio que seria melhor fazer uma lista
	/* Fim usuario */

	public Usuario(int id, String nome, String senha, String email, int reputacao) {
		this.idUsuario = id;
		this.nome = nome;
		this.senhaUsuario = senha;
		this.eMailUsuario = email;
		this.reputacaoUsuario = reputacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

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

	public static void main(String[] args) {
		Usuario eric = new Usuario(1, "davi", "456", "quebec@yahoo.com", 4);

		BigProjectA vai = new BigProjectA();
		vai.conectarPost(); // para conectar 
		// vai.pegarUsuario(); // para pugar o usuario
		//vai.inserirUsuario(eric); // colocar um usuario
		//vai.atualizarUsuario(eric); // mudar usuario

	}

}
