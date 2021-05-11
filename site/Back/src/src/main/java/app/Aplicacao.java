package app;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import Classe.BigProjectA;
import Empresa.Empresa;
import Usuario.Usuario;
import java.util.Random;

public class Aplicacao {

	public static void main(String[] args) {
		
		staticFiles.location("src/main/resources"); // pegar todos os documentos da pasta reources
		RetornaroFront mandarSite=new RetornaroFront();// chamar   class que ira mandar nossa pagina html para a tela
		
		BigProjectA conectar = new BigProjectA(); // conectar com nosso banco de dados
		conectar.conectarPost();
		
		/* codigos onde iremos colocar a pagina on*/
		get("/", (req, res) -> mandarSite.renderContent("/home.html"));
		get("/login", (req, res) -> mandarSite.renderContent("/login.html"));
		get("/register", (req, res) -> mandarSite.renderContent("/register.html")); 
		get("/myprojects", (req, res) -> mandarSite.renderContent("/myprojects.html")); 
		get("/creation", (req, res) -> mandarSite.renderContent("/creation.html")); 
		get("/project", (req, res) -> mandarSite.renderContent("/project.html"));
		get("/mycomments", (req, res) -> mandarSite.renderContent("/mycomments.html"));
		
		
		// pegar as infomacoes do usuario
		get("/mandarRe", (req, res) -> {
			
			String nomeUU = "";
			
			System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split(",");
			int x= Integer.parseInt(realocacao[5]);
			Usuario alocar = new Usuario(x, realocacao[0],realocacao[1], realocacao[2], 0,realocacao[4]);
			conectar.inserirUsuario(alocar);
			return 200;
		});
		
		
		get("/empresaRe", (req, res) -> {

			String nomeUU = "";
			//System.out.println(nomeUU = req.queryParams("query"));
			String[] realocacao = nomeUU.split("/");
			Empresa mandarParaPhpAdmin = new Empresa(1, realocacao[0], realocacao[1], realocacao[2]);
			conectar.inserirEmpresa(mandarParaPhpAdmin);
			// System.out.println( senhaUU=req.queryParams("query1"));
			return 200;
		});

		

	}
}

class RetornaroFront {

	public String renderContent(String htmlFile) throws IOException, URISyntaxException {
		return new String(Files.readAllBytes(Paths.get(getClass().getResource(htmlFile).toURI())),
				StandardCharsets.UTF_8);
	}
}
