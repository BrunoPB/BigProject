package Usuario;

import Classe.BigProjectA;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String senhaUsuario;
	private String eMailUsuario;
	private int reputacaoUsuario;
	private String curriculoUsuario;
	private String tagUsuario; 
	private String imagem;
	/* Fim usuario */

	//contrutor
	public Usuario(int id, String nome, String senha, String email, String imagem,String tag,int reputacao ) {
		this.idUsuario = id;
		this.nome = nome;
		this.senhaUsuario = senha;
		this.eMailUsuario = email;
		this.reputacaoUsuario = reputacao;
		this.imagem=imagem;
		this.tagUsuario=tag;
		
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



	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
