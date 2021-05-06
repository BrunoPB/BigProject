package Classe;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import Comentarios.Comentarios;
import Empresa.Empresa;
import Pojetos.Projetos;
import Usuario.Usuario;

public class BigProjectA {
	private Object alocacao = new Object();
	private Connection conexao;

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

	public boolean  conectarPost() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "ti2cc";
		String password = "eric321";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;

	}

	public void pegarUsuario() {

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario ");
			if (rs.next()) {
				rs.last();
							rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					System.out.println(rs.getString("Login"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
/*
 * set / gets costrutor clone toString
 * 
 */
