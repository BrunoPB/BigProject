package Empresa;


import org.json.JSONException;
import org.json.JSONObject;

public class Empresa {

	private int idEmpresa;
	private String nomeEmpresa;
	private String eMailEmpresa;
	private String senhaEmpresa;
	private String imagemEmpresa;

	public String getImagemEmpresa() {
		return imagemEmpresa;
	}

	public void setImagemEmpresa(String imagemEmpresa) {
		this.imagemEmpresa = imagemEmpresa;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String geteMailEmpresa() {
		return eMailEmpresa;
	}

	public void seteMailEmpresa(String eMailEmpresa) {
		this.eMailEmpresa = eMailEmpresa;
	}

	public String getSenhaEmpresa() {
		return senhaEmpresa;
	}

	public void setSenhaEmpresa(String senhaEmpresa) {
		this.senhaEmpresa = senhaEmpresa;
	}

	public Empresa(int idEmpresa, String nomeEmpresa, String eMailEmpresa, String senhaEmpresa, String img) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.eMailEmpresa = eMailEmpresa;
		this.senhaEmpresa = senhaEmpresa;
		this.imagemEmpresa = img;
	}

	public Empresa() {
		this(0, " ", " ", " ", " ");
	}

	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", eMailEmpresa=" + eMailEmpresa
				+ ", senhaEmpresa=" + senhaEmpresa + ", imagemEmpresa=" + imagemEmpresa + "]";
	}

	public String jsonCreation() {// Chamar no click -> Fazer verificação pre envio -> no Js
		String json_prep = "{\"EmpresaId\":\"idEmpresa\",\"nomeDaEmpresa\":\"nomeEmpresa\",\"emailDaEmpresa\":\"eMailEmpresa\","
				+ "\"senhaDaEmpresa\":\"senhaEmpresa\",\"imagemDaEmpresa\":\"imagemEmpresa\"}";// Montagem// da string do json Composto  por 2 slots ({\"Primeiro slot\":\"Segundo Slot\"})
																																																			

		JSONObject my_obj = new JSONObject(json_prep); // iniciação do obj json com passagem de string

		Integer idEmp = my_obj.getInt("idEmpresa");// Unico elemento com Int type
		String nomeEmp = my_obj.getString("nomeDaEmpresa");// Tipaçao String
		String emailEmp = my_obj.getString("emailDaEmpresa");// Tipaçao String
		String senhaEmp = my_obj.getString("senhaDaEmpresa"); // Tipaçao String
		String imagemEmp = my_obj.getString("imagemDaEmpresa");// Tipaçao String

		System.out.println(idEmp);// Print Id da empresa
		System.out.println(nomeEmp);// print Nome da empresa
		System.out.println(emailEmp);// Print email da empresa
		System.out.println(senhaEmp);// Print senha da empresa
		System.out.println(imagemEmp);// Print Imagem da empresa

		// return da string do json -> pode ser adiquirido por chamada unica por meio do
		// objeto json
		return json_prep;// Verificar necessidade
	}

}
