package Pojetos;
import Classe.BigProjectA;

public class Projetos {
	private int idProjeto;
	private String nomeProjeto;
	private String descricaoPojeto;
	private String dataInicio;
	private String dataFim;
	private int valorProjeto;
	
	public Projetos(int idProjeto, String nomeProjeto, String descricaoPojeto, String dataInicio, String dataFim,
			int valorProjeto) {
		super();
		this.idProjeto = idProjeto;
		this.nomeProjeto = nomeProjeto;
		this.descricaoPojeto = descricaoPojeto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorProjeto = valorProjeto;
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
	

	
}
/*
 * data comentarios custo likes
 */