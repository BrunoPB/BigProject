package Classe;

import Comentarios.Comentarios;
import Empresa.Empresa;
import Pojetos.Projetos;
import Usuario.Usuario;

public class BigProjectA {
	private Object alocacao = new Object();

	public Object getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(Object alocacao) {

		this.alocacao = alocacao;
	}

	public void receberUsuario(Usuario usuario) {
		this.setAlocacao(usuario);
	}

	public void receberProjetos(Projetos projetos) {
		this.setAlocacao(projetos);
	}

	public void receberEmpresa(Empresa empresa) {
		this.setAlocacao(empresa);
	}

	public void receverComentarios(Comentarios comentario) {
		this.setAlocacao(comentario);
	}
}
/*
 * set / gets costrutor clone toString
 * 
 */
