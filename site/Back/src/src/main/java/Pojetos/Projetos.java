package Pojetos;
import Classe.BigProjectA;
import org.json.JSONException;
import org.json.JSONObject;
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
	
	  public String jsonCreationProjeto(){// Chamar no click -> Fazer verificação pre envio -> no Js
		     String json_projeto = "{\"idP\":\"idProjeto\",\"nomeP\":\"nomeProjeto\",\"descricaoP\":\"descricaoPojeto\",\"dataIP\":\"dataInicio\",\"dataFP\":\"dataFim\",\"valorP\":\"valorProjeto\",\"tagP\":\"tag\",\"imagemP\":\"imagem\",\"recP\":\"rec\"}";//Montagem da string do json -> Composto por 2 slots ({\"Primeiro Slot\":\"Segundo Slot\"})
		     //Primeiro Slot Nome gerado para "variavel" ||-> Segundo Slot Variavel para atribuição

		        JSONObject my_obj = new JSONObject(json_projeto); // iniciação do obj json com passagem de string 

		        Integer idProjeto = my_obj.getInt("idP");
		        String nomeProjeto = my_obj.getString("nomeP");
		        String descricaoProjeto = my_obj.getString("descricaoP");
		        String dataIProjeto = my_obj.getString("dataIP"); 
		        String dataFProjeto = my_obj.getString("dataFP");
		        String valorProjeto = my_obj.getString("valorP");
		        String tagProjeto = my_obj.getString("tagP");
		        String imagemProjeto = my_obj.getString("imagemP");

		        

		        System.out.println(idProjeto);
		        System.out.println(nomeProjeto); 
		        System.out.println(descricaoProjeto);
		        System.out.println(dataIProjeto);
		        System.out.println(dataFProjeto);
		        System.out.println(valorProjeto);
		        System.out.println(tagProjeto);
		        System.out.println(imagemProjeto);

		        //return da string do json -> pode ser adiquirido por chamada unica por meio do objeto json
		        return json_projeto;//Verificar necessidade
		        }
	

	
}
/*
 * data comentarios custo likes
 */