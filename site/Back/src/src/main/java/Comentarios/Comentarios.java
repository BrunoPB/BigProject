package Comentarios;
import org.json.JSONException;
import org.json.JSONObject;

public class Comentarios {

	private int idComentario;
	private int Ganhador;
	private String Comentario;
	private int likes;
	private String dataComentario;

	
	public Comentarios(int idComentario, int ganhador, String comentario, int likes, String dataComentario) {
		super();
		this.idComentario = idComentario;
		this.Ganhador = ganhador;
		this.Comentario = comentario;
		this.likes = likes;
		this.dataComentario = dataComentario;
	}
	
	
	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getGanhador() {
		return Ganhador;
	}

	public void setGanhador(int ganhador) {
		Ganhador = ganhador;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(String dataComentario) {
		this.dataComentario = dataComentario;
	}
	
	/*
	 * comentarios projeto usuario like vencedor
	 * 
	 */

	/*
		private int idComentario;
		private int Ganhador;
		private String Comentario;
		private int likes;
		private String dataComentario;
	*/
	    
	   public String jsonCreationComentario(){// Chamar no click -> Fazer verificação pre envio -> no Js
	     String json_comentario = "{\"idC\":\"idComentario\",\"ganhadorC\":\"Ganhador\",\"comentarioC\":\"Comentario\",\"likesC\":\"likes\",\"dataComentarioC\":\"dataComentario\"}";//Montagem da string do json -> Composto por 2 slots ({\"Primeiro Slot\":\"Segundo Slot\"})
	     //Primeiro Slot Nome gerado para "variavel" ||-> Segundo Slot Variavel para atribuição

	        JSONObject my_obj = new JSONObject(json_comentario); // iniciação do obj json com passagem de string 

	        Integer idComent = my_obj.getInt("idC");
	        int ganhadorComentario = my_obj.getInt("ganhadorC");
	        String comentarioComent = my_obj.getString("comentarioC");
	        int likesComentario = my_obj.getInt("likesC"); 
	        String dataComentarioComent = my_obj.getString("dataComentarioC");
	        

	        

	        System.out.println(idComent);
	        System.out.println(ganhadorComentario); 
	        System.out.println(comentarioComent);
	        System.out.println(likesComentario);
	        System.out.println(dataComentarioComent);
	       

	        //return da string do json -> pode ser adiquirido por chamada unica por meio do objeto json
	        return json_comentario;//Verificar necessidade
	        }

	
}

/*
 *
 * 
 */