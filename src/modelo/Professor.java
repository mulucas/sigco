package modelo;

public class Professor {

	private int id,cotasDisponiveis, cotasUsadas;;

	public int getCotasUsadas() {
		return cotasUsadas;
	}

	public void setCotasUsadas(int cotasUsadas) {
		this.cotasUsadas = cotasUsadas;
	}

	public int getCotasDisponiveis() {
		return cotasDisponiveis;
	}

	public void setCotasDisponiveis(int cotasDisponiveis) {
		this.cotasDisponiveis = cotasDisponiveis;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nome, matricula,qntdAlunos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getQntdAlunos() {
		return qntdAlunos;
	}

	public void setQntdAlunos(String qntdAlunos) {
		this.qntdAlunos = qntdAlunos;
	}
}
