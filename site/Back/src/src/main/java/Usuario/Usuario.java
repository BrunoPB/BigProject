package Usuario;
import org.json.JSONException;
import org.json.JSONObject;
import Classe.BigProjectA;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String senhaUsuario;
	private String eMailUsuario;
	private int reputacaoUsuario;
	private String curriculoUsuario;
	private String tagUsuario; 
	private String imagem;
	/* Fim usuario */

	//contrutor
	public Usuario(int id, String nome, String senha, String email, String imagem,String tag,int reputacao ) {
		this.idUsuario = id;
		this.nome = nome;
		this.senhaUsuario = senha;
		this.eMailUsuario = email;
		this.reputacaoUsuario = reputacao;
		this.imagem=imagem;
		this.tagUsuario=tag;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String geteMailUsuario() {
		return eMailUsuario;
	}

	public void seteMailUsuario(String eMailUsuario) {
		this.eMailUsuario = eMailUsuario;
	}

	public int getReputacaoUsuario() {
		return reputacaoUsuario;
	}

	public void setReputacaoUsuario(int reputacaoUsuario) {
		this.reputacaoUsuario = reputacaoUsuario;
	}

	public String getCurriculoUsuario() {
		return curriculoUsuario;
	}

	public void setCurriculoUsuario(String curriculoUsuario) {
		this.curriculoUsuario = curriculoUsuario;
	}

	public String getTagUsuario() {
		return tagUsuario;
	}

	public void setTagUsuario(String tagUsuario) {
		this.tagUsuario = tagUsuario;
	}



	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
    
   public String jsonCreationUsuario(){// Chamar no click -> Fazer verificação pre envio -> no Js
     String json_usuario = "{\"idU\":\"idUsuario\",\"nomeU\":\"nome\",\"senhaU\":\"senhaUsuario\",\"eMailU\":\"eMailUsuario\",\"reputacaoU\":\"reputacaoUsuario\","
     		+ "\"curriculoU\":\"curriculoUsuario\",\"tagU\":\"tagUsuario\",\"imagemU\":\"imagem\"}";//Montagem da string do json -> Composto por 2 slots ({\"Primeiro Slot\":\"Segundo Slot\"})
     //Primeiro Slot Nome gerado para "variavel" ||-> Segundo Slot Variavel para atribuição

        JSONObject my_obj = new JSONObject(json_usuario); // iniciação do obj json com passagem de string 

        Integer idUsuario = my_obj.getInt("idU");
        String nomeUsuario = my_obj.getString("nomeU");
        String senhaUsuario = my_obj.getString("senhaU");
        String eMailUsuario = my_obj.getString("eMailU"); 
        String reputacaoUsuario = my_obj.getString("reputacaoU");
        String curriculoUsuario = my_obj.getString("curriculoU");
        String tagUsuario = my_obj.getString("tagU");
        String imagemUsuario = my_obj.getString("imagemU");

        

        System.out.println(idUsuario);
        System.out.println(nomeUsuario); 
        System.out.println(senhaUsuario);
        System.out.println(eMailUsuario);
        System.out.println(reputacaoUsuario);
        System.out.println(curriculoUsuario);
        System.out.println(tagUsuario);
        System.out.println(imagemUsuario);

        //return da string do json -> pode ser adiquirido por chamada unica por meio do objeto json
        return json_usuario;//Verificar necessidade
        }

}
