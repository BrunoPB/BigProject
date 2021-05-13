package Pojetos;
import Classe.BigProjectA;

public class Projetos {
	private int idProjeto;
	private String nomeProjeto;
	private String descricaoPojeto;
	private String dataInicio;
	private String dataFim;
	private int valorProjeto;
	private String tag;
	private String imagem;
	private String rec;

	
	 public Projetos(int idProjeto1, String nomeProjeto1, String descricaoPojeto1, String dataInicio1, String dataFim1,
		      int valorProjeto1, String tag1, String imagem1,String rec) {
		    this.idProjeto = idProjeto1;
		    this.nomeProjeto = nomeProjeto1;
		    this.descricaoPojeto = descricaoPojeto1;
		    this.dataInicio = dataInicio1;
		    this.dataFim = dataFim1;
		    this.valorProjeto = valorProjeto1;
		    this.tag = tag1;
		    this.imagem = imagem1;
		    this.rec=rec;
		    
		  }

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getDescricaoPojeto() {
		return descricaoPojeto;
	}

	public void setDescricaoPojeto(String descricaoPojeto) {
		this.descricaoPojeto = descricaoPojeto;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getValorProjeto() {
		return valorProjeto;
	}

	public void setValorProjeto(int valorProjeto) {
		this.valorProjeto = valorProjeto;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

	
}
/*
 * data comentarios custo likes
 */