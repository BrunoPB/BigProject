package Comentarios;


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
}

/*
 * comentarios projeto usuario like vencedor
 * 
 */