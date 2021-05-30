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

import Empresa.Empresa;
import Pojetos.Projetos;
import Usuario.Usuario;
import dao.BigProjectA;
import spark.utils.IOUtils;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.textanalytics.models.*;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.TextAnalyticsClient;

public class Aplicacao {
	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		staticFiles.location("src/main/resources"); // pegar todos os documentos da pasta reources
		RetornaroFront mandarSite = new RetornaroFront();// chamar class que ira mandar nossa pagina html para a tela

		BigProjectA conectar = new BigProjectA(); // conectar com nosso banco de dados
		conectar.conectarPost();
		/*
		 * TextAnalyticsSamples pegarPalavraschaves = new TextAnalyticsSamples(); //
		 * fazer a ia funcionar TextAnalyticsSamples.fazerIA(" Ruim esse negocio");
		 */

		/* codigos onde iremos colocar a pagina on */
		get("/", (req, res) -> mandarSite.renderContent("/home.html"));
		get("/login", (req, res) -> mandarSite.renderContent("/login.html"));
		get("/register", (req, res) -> mandarSite.renderContent("/register.html"));
		get("/myprojects", (req, res) -> mandarSite.renderContent("/myprojects.html"));
		get("/creation", (req, res) -> mandarSite.renderContent("/creation.html"));
		get("/project", (req, res) -> mandarSite.renderContent("/project.html"));
		get("/mycomments", (req, res) -> mandarSite.renderContent("/mycomments.html"));
		get("/logout", (req, res) -> mandarSite.renderContent("/logout.html"));

		// Post_JSON();
		// pegar as infomacoes do usuario

		// mandar os ids para o front end
		get("/Ids", (req, res) -> {

			String[] idsget = conectar.retornarOsids();
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");

			return conectar.jasonIds(idsget);
		});

		get("/imgs", (req, res) -> {
			String[] idsget = conectar.retornarOsids();
			int idUser = Integer.parseInt(idsget[2]);
			String[] recebertudo = conectar.pegarImagensProjetoTelalogin(idUser);
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");

			return conectar.jasonprojetos(recebertudo, idUser);
		});
		// http://localhost:4567/imgs

		// mandar Usuario para o front e para o bd
		get("/mandarRe", (req, res) -> {

			String nomeUU = "";
			boolean verdade = true;
			System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split(",");
			String[] idsget = conectar.retornarOsids();
			int idUser = Integer.parseInt(idsget[1]);
			idUser++;
			Usuario alocar = new Usuario(idUser, realocacao[0], realocacao[1], realocacao[2], realocacao[3],
					realocacao[4], 0);
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");

			String[] receber = conectar.pegarNomeUsuario();
			int foo = Integer.parseInt(idsget[1]);
			for (int i = 0; i < foo; i++) {
				if (receber[i].equals(realocacao[0])) {
					verdade = false;
					return alocar.ErrorUsuario();
				}

			}

			if (verdade) {
				conectar.inserirUsuario(alocar);
			}
			return alocar.jsonCreationUsuario(alocar);
		});

		get("/imgsProjeto", (req, res) -> {

			String[] idsget = conectar.retornarOsids();
			int idUser = Integer.parseInt(idsget[2]);
			String[] recebertudo = conectar.pegarImagensProjetoTelaComentario(idUser);
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");
			System.out.println(conectar.jasonprojetosProjeto(recebertudo, idUser));
			return conectar.jasonprojetosProjeto(recebertudo, idUser);

		});

		// mandar empresa para o back end
		get("/empresaRe", (req, res) -> {

			String nomeUU = "";
			System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split(",");
			
			String[] idsget = conectar.retornarOsids();
			int idUser = Integer.parseInt(idsget[0]);
			Empresa mandarParaPhpAdmin = new Empresa(idUser + 1, realocacao[0], realocacao[2], realocacao[1],
					realocacao[3]);
			conectar.inserirEmpresa(mandarParaPhpAdmin);

			// System.out.println( senhaUU=req.queryParams("query1"));
			return 200;
		});

		// pegar projetos para o back end
		get("/projetoRe", (req, res) -> {
			String getProjeto = "";
			LocalDate date = LocalDate.now(); // Gets the current date

			System.out.println(getProjeto = req.queryParams("query"));
			String[] realocarProjeto = getProjeto.split("///");
			String[] idsget = conectar.retornarOsids();
			int idProjeto1 = Integer.parseInt(idsget[2]);
			int custoProjeto = Integer.parseInt(realocarProjeto[2]);
			int dataAsermodificada = Integer.parseInt(realocarProjeto[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			// System.out.println(date.format(formatter));
			String pegarInicio = date.format(formatter);
			date = date.plusDays(dataAsermodificada);
			String pegarFim = date.format(formatter);
			Projetos projeto = new Projetos(idProjeto1 + 1, realocarProjeto[0], realocarProjeto[4], pegarInicio,
					pegarFim, custoProjeto, realocarProjeto[3], realocarProjeto[7], realocarProjeto[5]);
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");
			byte[] bytes = realocarProjeto[7].getBytes();
			String s = new String(bytes, "ISO-8859-1");
			System.out.println(s);
			conectar.inserirProjeto(projeto, bytes);

			return projeto.jsonCreationProjeto(projeto);
		});

		get("/pegarlog", (req, res) -> {
			String getComentario = "";
			System.out.println(getComentario = req.queryParams("query"));
			String[] realocarComentarios = getComentario.split("//");

			String[] receberT = conectar.fazerloginNoSite(realocarComentarios);
			if (receberT[0].equals("Usuario")) {
				res.header("Access-Control-Allow-Origin", "*");
				res.header("Access-Control-Allow-Methods", "POST,GET");
				res.header("Access-Control-Allow-Headers", "*");
				res.header("Access-Control-Max-Age", "86400");
				Usuario alocar = new Usuario();
				System.out.println(alocar.paginadeLogin(receberT));
				return alocar.paginadeLogin(receberT);
			} else if (receberT[0].equals("Empresa")) {
				res.header("Access-Control-Allow-Origin", "*");
				res.header("Access-Control-Allow-Methods", "POST,GET");
				res.header("Access-Control-Allow-Headers", "*");
				res.header("Access-Control-Max-Age", "86400");
				Empresa alocar = new Empresa();
				System.out.println(alocar.paginadeLogin(receberT));
				return alocar.paginadeLogin(receberT);
			}
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");
			return 200;
		});

		// pegar os comentarios do projeto
		get("/comentarioRe", (req, res) -> {
			String getComentario = "";
			System.out.println(getComentario = req.queryParams("query"));
			String[] realocarComentarios = getComentario.split("//");

			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Methods", "POST,GET");
			res.header("Access-Control-Allow-Headers", "*");
			res.header("Access-Control-Max-Age", "86400");
			return 200;
		});

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

class TextAnalyticsSamples {
	private static String KEY = "f1ac82243b374ad2999f41b053f93b30";
	private static String ENDPOINT = "https://ti2textanalyse.cognitiveservices.azure.com/";

	public static void fazerIA(String receber) {
		TextAnalyticsClient client = authenticateClient(KEY, ENDPOINT);
		extractKeyPhrasesExample(client, receber);
		sentimentAnalysisExample(client, receber);
	}

	public static TextAnalyticsClient authenticateClient(String key, String endpoint) {
		return new TextAnalyticsClientBuilder().credential(new AzureKeyCredential(key)).endpoint(endpoint)
				.buildClient();
	}

	public static void extractKeyPhrasesExample(TextAnalyticsClient client, String pato) {
		// The text that need be analyzed.

		for (String keyPhrase : client.extractKeyPhrases(pato)) {
			System.out.printf("%s%n", keyPhrase);
		}
	}

	public static void sentimentAnalysisExample(TextAnalyticsClient client, String pato) {
		// The text that need be analyzed.

		DocumentSentiment documentSentiment = client.analyzeSentiment(pato);
		System.out.printf(
				"Recognized document sentiment: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
				documentSentiment.getSentiment(), documentSentiment.getConfidenceScores().getPositive(),
				documentSentiment.getConfidenceScores().getNeutral(),
				documentSentiment.getConfidenceScores().getNegative());

		for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
			System.out.printf("Recognized sentence sentiment: %s %n", sentenceSentiment.getSentiment(),
					sentenceSentiment.getConfidenceScores().getNegative());
		}
	}

	
}
