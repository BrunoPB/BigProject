package dao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import org.json.JSONObject;

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
			System.out.println("Conexão com postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;

	}
//-------------------------------------------------------------------------------------------------------------

	// retorna todos os usuarios presentes no bd
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

	public String[] pegarNomeUsuario() {
		int pegarValor = Integer.parseInt(retornarOsids()[1]);
		String[] nomes = new String[pegarValor];
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT nome FROM usuario ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					nomes[i] = rs.getString("nome");
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return nomes;
	}

	// coloca um usuario no bd
	public void inserirUsuario(Usuario usuario) {
		boolean saberVerdade = false;

		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuario (idusuario,nome,senha,email,reputacao,imagem,tag)" + "VALUES ("
					+ usuario.getIdUsuario() + ", '" + usuario.getNome() + "', '" + usuario.getSenhaUsuario() + "', '"
					+ usuario.geteMailUsuario() + "','" + usuario.getReputacaoUsuario() + "','" + usuario.getImagem()
					+ " ' , '" + usuario.getTagUsuario() + "');");

			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	// atualiza o usuario determinado
	public boolean atualizarUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET email = '" + usuario.geteMailUsuario() + "', nome = '" + usuario.getNome()
					+ "', senha = '" + usuario.getSenhaUsuario() + "'" + " WHERE idusuario = " + usuario.getIdUsuario();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	/* Fim Usuario */
//-------------------------------------------------------------------------------------------------------------------	

	// pega todos os ids de projetos
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

	// coloca uma novo projeto no BD
	public void inserirProjeto(Projetos projeto, byte[] img) {
		boolean saberVerdade = false;

		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO projetos (idprojeto,nome,datainicio,datafim,descricao,valor,tag,imagem,idep)"
					+ "VALUES (" + projeto.getIdProjeto() + ", '" + projeto.getNomeProjeto() + "', '"
					+ projeto.getDataInicio() + "', '" + projeto.getDataFim() + "', '" + projeto.getDescricaoPojeto()
					+ "', '" + projeto.getValorProjeto() + "', '" + projeto.getTag() + "', '" + projeto.getImagem()
					+ "' , '" + projeto.getIddaEmpresa() + "');");

			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	public String[] pegarImagensProjetoTelalogin(int id) {
		String[] pegarProjeto = new String[id];
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT nome,imagem FROM projetos ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					pegarProjeto[i] = rs.getString("nome");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("imagem");
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pegarProjeto;

	}

	public String[] pegarImagensProjetoTelaComentario(int id) {
		String[] pegarProjeto = new String[id];
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT nome,imagem , tag,descricao FROM projetos ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					pegarProjeto[i] = rs.getString("nome");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("imagem");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("tag");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("descricao");
					pegarProjeto[i] += "///";
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pegarProjeto;

	}

	public String[] pegarImagensProjetoTelaComentariot(int id) {
		String[] pegarProjeto = new String[30];
		int i = 0;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT nome,imagem , tag,descricao ,datafim, idprojeto FROM projetos ");

			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (; rs.next(); i++) {
					pegarProjeto[i] = rs.getString("nome");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("imagem");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("tag");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("descricao");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("datafim");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("idprojeto");
					pegarProjeto[i] += "///";
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM comentarios ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (; rs.next(); i++) {
					pegarProjeto[i] = rs.getString("idcomentario");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("comentario");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("likes");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("data");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("sentimento");
					pegarProjeto[i] += "///";
					pegarProjeto[i] += rs.getString("idusuario");
					pegarProjeto[i] += "///";
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		// System.out.println( pegarProjeto[0]);
		return pegarProjeto;
	}

	public String jasonprojetosProjeto(String[] projetos) {
		JSONObject jasoNIds = new JSONObject();

		String[] teste = projetos[1].split("///");
		jasoNIds.put("Nome", teste[0]);
		jasoNIds.put("imagem", teste[1]);
		jasoNIds.put("tag", teste[2]);
		jasoNIds.put("descricao", teste[3]);
		jasoNIds.put("dataFim", teste[4]);
		jasoNIds.put("idProjeto", teste[5]);

		String[] teste1 = projetos[7].split("///");
		
		jasoNIds.put("idcomentario", teste1[0]);
		jasoNIds.put("comentario", teste1[1]);
		jasoNIds.put("likes", teste1[2]);
		jasoNIds.put("data", teste1[3]);
		jasoNIds.put("sentimento", teste1[4]);
		jasoNIds.put("idusuario", teste1[5]);
		
		return jasoNIds.toString();
	}

	public String jasonprojetos(String[] projetos, int x) {
		JSONObject jasoNIds = new JSONObject();
		for (int i = 0; i < x; i++) {
			String[] teste = projetos[i].split("///");

			jasoNIds.put("Nome", teste[0]);
			jasoNIds.put("imagem", teste[1]);
		}

		return jasoNIds.toString();
	}

	/* fim Projetos */
//--------------------------------------------------------------------------------------------------------------------
	// retorna todos os elementos presentes na empresa
	public boolean pegarEmpresa(int numero, String nome, String senha) {
		boolean saber = false;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM empresa ");
			if (rs.last()) {
				if (nome.equals(rs.getString("nome")) && senha.equals(rs.getString("senha"))) {
					saber = true;
				}

			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return saber;

	}

	public Empresa pegarEmpresalogin() {
		Empresa pegar = new Empresa();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM empresa ");
			if (rs.last()) {
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

	// inseri uma nova empresa em nosso BD
	public void inserirEmpresa(Empresa empresa) {
		boolean saberVerdade = false;

		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO empresa (idempresa,nome,email,senha,imagem)" + "VALUES ("
					+ empresa.getIdEmpresa() + ", '" + empresa.getNomeEmpresa() + "', '" + empresa.geteMailEmpresa()
					+ "', '" + empresa.getSenhaEmpresa() + "', '" + empresa.getImagemEmpresa() + "');");

			st.close();
			saberVerdade = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

	// atualiza as imformacoes da empresa
	public boolean atualizarEmpresa(Empresa empresa) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE empresa SET email = '" + empresa.geteMailEmpresa() + "', nome = '"
					+ empresa.getNomeEmpresa() + "', senha = '" + empresa.getSenhaEmpresa() + "'"
					+ " WHERE idempresa = " + empresa.getIdEmpresa();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

// fim Empresa	
//************************************************************************************************	

	// pegar todos os comentarios
	public void pegarComentarios() {

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT  FROM comentarios ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					System.out.println(rs.getString("comentario"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	 public void inserirComentario(Comentarios comentario) {
	        boolean saberVerdade = false;

	        try {
	            Statement st = conexao.createStatement();
	            st.executeUpdate("INSERT INTO comentarios (idcomentario,comentario,likes,data,idprojeto,sentimento,idusuario)" + "VALUES ("
	                    + comentario.getIdComentario() + ", '" + comentario.getComentario() + "', '" +
	            		comentario.getLikes() + "', '" + comentario.getDataComentario() + "', '" + 
	                    comentario.getIdProjeto()+ "', '" + comentario.getSentimentos() + "', '" + comentario. getIdUsuario()+  "');");

	            st.close();
	            saberVerdade = true;
	        } catch (SQLException u) {
	            throw new RuntimeException(u);
	        }

	    }

//**********************************************************************************************************
	// ira retornar os ultimos ids de usuarios
	public String[] retornarOsids() {
		String[] idsGet = new String[4];
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT idempresa FROM empresa ");
			if (rs.last()) {
				idsGet[0] = Integer.toString(rs.getInt("idempresa"));
				// System.out.println("ultimo id de empresa =="+idsGet[0]);
			} else {
				idsGet[0] = "0";
				// System.out.println("ultimo id de empresa =="+idsGet[0]);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "em pegar id empresa");
		}

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT idusuario FROM usuario ");
			if (rs.last()) {
				idsGet[1] = Integer.toString(rs.getInt("idusuario"));
				// System.out.println("ultimo id de usuario =="+idsGet[1]);
			} else {
				idsGet[1] = "0";
				// System.out.println("ultimo id de usuario =="+idsGet[1]);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "em pegar id usuario");
		}

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT idprojeto FROM projetos ");
			if (rs.last()) {
				idsGet[2] = Integer.toString(rs.getInt("idprojeto"));
				// System.out.println("ultimo id de projeto =="+idsGet[2]);
			} else {
				idsGet[2] = "0";
				// System.out.println("ultimo id de projeto =="+idsGet[2]);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "em pegar id projeto");
		}

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT idcomentario FROM comentarios ");
			if (rs.last()) {
				idsGet[3] = Integer.toString(rs.getInt("idcomentario"));
				// System.out.println("ultimo id de comentario =="+idsGet[3]);
			} else {
				idsGet[3] = "0";
				// System.out.println("ultimo id de comentario =="+idsGet[3]);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "em pegar id comentario");
		}

		return idsGet;
	}

	public String jasonIds(String[] ids) {

		JSONObject jasoNIds = new JSONObject();
		jasoNIds.put("idEmpresa", ids[0]);
		jasoNIds.put("idUsuario", ids[1]);
		jasoNIds.put("idprojeto", ids[2]);
		jasoNIds.put("idComentario", ids[3]);

		return jasoNIds.toString();
	}

	/// login em nosso site
	public String[] fazerloginNoSite(String[] valores) {
		String[] saber = new String[3];
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					if (rs.getString("nome").equals(valores[0])) {
						if (rs.getString("senha").equals(valores[1])) {
							saber[0] = "Usuario";
							saber[1] = rs.getString("idusuario");
							return saber;
						}
					}
				}
			}

			st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT *FROM empresa ");
			if (rs.next()) {
				rs.last();
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					if (rs.getString("nome").equals(valores[0])) {
						if (rs.getString("senha").equals(valores[1])) {
							saber[0] = "Empresa";
							saber[1] = rs.getString("idempresa");
						}
					}
				}
			}
			st.close();
			return saber;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

}

//****************************************************************************************************
/*
 * set / gets costrutor clone toString blop ou usar o link como text banco de
 * dados em nuvem
 * 
 * 
 * azure aprender a rank
 */
