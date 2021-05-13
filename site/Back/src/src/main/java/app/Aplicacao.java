package app;

import static spark.Spark.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Classe.BigProjectA;
import Empresa.Empresa;
import Pojetos.Projetos;
import Usuario.Usuario;
import spark.utils.IOUtils;

public class Aplicacao {
	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		staticFiles.location("src/main/resources"); // pegar todos os documentos da pasta reources
		RetornaroFront mandarSite = new RetornaroFront();// chamar class que ira mandar nossa pagina html para a tela

		BigProjectA conectar = new BigProjectA(); // conectar com nosso banco de dados
		conectar.conectarPost();
		
		
		/* codigos onde iremos colocar a pagina on */
		get("/", (req, res) -> mandarSite.renderContent("/home.html"));
		get("/login", (req, res) -> mandarSite.renderContent("/login.html"));
		get("/register", (req, res) -> mandarSite.renderContent("/register.html"));
		get("/myprojects", (req, res) -> mandarSite.renderContent("/myprojects.html"));
		get("/creation", (req, res) -> mandarSite.renderContent("/creation.html"));
		get("/project", (req, res) -> mandarSite.renderContent("/project.html"));
		get("/mycomments", (req, res) -> mandarSite.renderContent("/mycomments.html"));
		//Post_JSON();
		// pegar as infomacoes do usuario
		
		get("/mandarRe", (req, res) -> {

			String nomeUU = "";

			System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split(",");
			int x = Integer.parseInt(realocacao[5]);
			Usuario alocar = new Usuario(x, realocacao[0], realocacao[1], realocacao[2], realocacao[3], realocacao[4],
					0);
			//conectar.inserirUsuario(alocar);
			String testarcoisas=alocar.getNome();
			String testarcoisas2=alocar.getSenhaUsuario();
			get("/temtativa1", (request, response) ->"Nome:"+ testarcoisas+" senha: "+testarcoisas2);
			return 200;
		});

		// pegar empresa
		get("/empresaRe", (req, res) -> {

			String nomeUU = "";
			System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split(",");
			int x = Integer.parseInt(realocacao[4]);
			Empresa mandarParaPhpAdmin = new Empresa(x, realocacao[0], realocacao[1], realocacao[2], realocacao[3]);
			conectar.inserirEmpresa(mandarParaPhpAdmin);
			// System.out.println( senhaUU=req.queryParams("query1"));
			return 200;
		});

		// pegar projetos
		get("/projetoRe", (req, res) -> {
			String getProjeto = "";
			LocalDate date = LocalDate.now(); // Gets the current date

			System.out.println(getProjeto = req.queryParams("query"));
			String[] realocarProjeto = getProjeto.split("//");
			int idProjeto = Integer.parseInt(realocarProjeto[6]);
			int custoProjeto = Integer.parseInt(realocarProjeto[2]);
			int dataAsermodificada = Integer.parseInt(realocarProjeto[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			// System.out.println(date.format(formatter));
			String pegarInicio = date.format(formatter);
			date = date.plusDays(dataAsermodificada);
			String pegarFim = date.format(formatter);
			Projetos projeto = new Projetos(idProjeto, realocarProjeto[0], realocarProjeto[4], pegarInicio, pegarFim,
					custoProjeto, realocarProjeto[3], realocarProjeto[7], realocarProjeto[5]);

			 conectar.inserirProjeto(projeto);

			return 200;
		});

		// pegar os comentarios do projeto
		get("/comentarioGet", (req, res) -> {
			String getComentario = "";
			System.out.println(getComentario = req.queryParams("query"));
			String[] realocarProjeto = getComentario.split(",");

			return 200;
		});

	}
	public static void Post_JSON() throws IOException {
        String utlsite = "http://localhost:/testativa1";
        String json = "{  \"vai que vai\", [ \"deubom\" ], }";
        URL url = new URL(utlsite);
        HttpURLConnection conectComHttp = (HttpURLConnection) url.openConnection();
        conectComHttp.setDoOutput(true);
        conectComHttp.setRequestMethod("POST");
        conectComHttp.setRequestProperty("Content-Type", "application/json");
        try (OutputStream outputStream =  conectComHttp.getOutputStream()) { 
         outputStream.write(json.getBytes());
         outputStream.flush();
         outputStream.close();
        } catch (Exception e) {
			System.out.println(e);
		}
	}
	

}

// class para usar a funcao sem static
class RetornaroFront {

	// String renderContent fuciona para colocar os html na pagina
	public String renderContent(String htmlFile) throws IOException, URISyntaxException {
		return new String(Files.readAllBytes(Paths.get(getClass().getResource(htmlFile).toURI())),
				StandardCharsets.UTF_8);
	}
}
