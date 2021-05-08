package Classe;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import Comentarios.Comentarios;
import Empresa.Empresa;
import Pojetos.Projetos;
import Usuario.Usuario;

public class BigProjectA {
	
	private Connection conexao;

	

	public boolean conectarPost() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "bigprojet";
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
//-------------------------------------------------------------------------------------------------------------
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

	public void inserirUsuario(Usuario usuario) {
		boolean saberVerdade = false;
		
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuario (idusuario,nome,senha,email)" 
					 + "VALUES ("+usuario.getIdUsuario()+ ", '" +  usuario.getNome()+ "', '"  
				       + usuario.getSenhaUsuario()+ "', '" + usuario.geteMailUsuario() + "');");
				
			
			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}
	
	public boolean atualizarUsuario(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET email = '" + usuario.geteMailUsuario() + "', nome = '"  
				       + usuario.getNome() + "', senha = '" + usuario.getSenhaUsuario() + "'"
					   + " WHERE idusuario = " + usuario.getIdUsuario();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
   /* Fim Usuario  */ 
//-------------------------------------------------------------------------------------------------------------------	
	public void pegarProjeto() {

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM projetos ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					System.out.println(rs.getString("idprojeto"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	public void inserirProjeto(Projetos projeto) {
		boolean saberVerdade = false;
		
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO projetos (idprojeto,nome,datainicio,datafim)" 
					 + "VALUES ("+ projeto.getIdProjeto()+ ", '" +  projeto.getNomeProjeto()+ "', '"  
				       + projeto.getDataInicio()+ "', '" + projeto.getDataFim()+ "');");
				
			
			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}
	
	public boolean atualizarProjeto(Projetos projeto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE projetos SET descricao = '" + projeto.getDescricaoPojeto() + "', nome = '"  
				       + projeto.getNomeProjeto() + "', valor = '" + projeto.getValorProjeto() + "'"
					   + " WHERE idprojeto = " + projeto.getIdProjeto();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
/* fim  Projetos */
//--------------------------------------------------------------------------------------------------------------------
	public Empresa pegarEmpresa() {
		Empresa pegar = new Empresa();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM empresa ");
			if (rs.last()) {
					pegar.setIdEmpresa(rs.getInt("idempresa"));
					pegar.setNomeEmpresa(rs.getString("nome"));
					pegar.seteMailEmpresa(rs.getString("email"));
					pegar.setSenhaEmpresa(rs.getString("senha"));
					;
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pegar;

	}
	
	public void inserirEmpresa(Empresa empresa) {
		boolean saberVerdade = false;
		
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO empresa (idempresa,nome,email,senha)" 
					 + "VALUES ("+ empresa.getIdEmpresa() + ", '" + empresa.getNomeEmpresa()+ "', '"  
				       + empresa.geteMailEmpresa()+ "', '" + empresa.getSenhaEmpresa()+ "');");
							
			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}
	
	public boolean atualizarEmpresa(Empresa empresa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE empresa SET email = '" + empresa.geteMailEmpresa() + "', nome = '"  
				       +  empresa.getNomeEmpresa() + "', senha = '" + empresa.getSenhaEmpresa() + "'"
					   + " WHERE idempresa = " +  empresa.getIdEmpresa();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
}
/*
 * set / gets costrutor clone toString blop ou usar o link como text banco de
 * dados em nuvem
 * 
 * 
 * azure aprender a rank
 */
