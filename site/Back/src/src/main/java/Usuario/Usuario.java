package Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import dao.BigProjectA;

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

	// contrutor
	public Usuario(int id, String nome, String senha, String email, String imagem, String tag, int reputacao) {
		this.idUsuario = id;
		this.nome = nome;
		this.senhaUsuario = senha;
		this.eMailUsuario = email;
		this.reputacaoUsuario = reputacao;
		this.imagem = imagem;
		this.tagUsuario = tag;

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
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", senhaUsuario=" + senhaUsuario
				+ ", eMailUsuario=" + eMailUsuario + ", reputacaoUsuario=" + reputacaoUsuario + ", curriculoUsuario="
				+ curriculoUsuario + ", tagUsuario=" + tagUsuario + ", imagem=" + imagem + "]";
	}

	public String jsonCreationUsuario(Usuario usuario) {// Chamar no click -> Fazer verificação pre envio -> no Js

		JSONObject jasonUsuario = new JSONObject(); // iniciação do obj json com passagem de string
		jasonUsuario.put("idUsuario",usuario.getIdUsuario());
		jasonUsuario.put("nomeUsuario",usuario.getNome());
		jasonUsuario.put("senhaUsuario",usuario.getSenhaUsuario());
		jasonUsuario.put("emailUsuario",usuario.geteMailUsuario());
		jasonUsuario.put("reputacaoUsuario",usuario.getReputacaoUsuario());
		jasonUsuario.put("tagUsuario",usuario.getTagUsuario());
		jasonUsuario.put("imagem",usuario.getImagem());
		return jasonUsuario.toString();// Verificar necessidade
	}
	
	public JSONObject ErrorUsuario() {// Chamar no click -> Fazer verificação pre envio -> no Js

		JSONObject jasonUsuarioError = new JSONObject(); // iniciação do obj json com passagem de string
		
		jasonUsuarioError.put("Erro","Erro");
		return jasonUsuarioError;// Verificar necessidade
	}

}
