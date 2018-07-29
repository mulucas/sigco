package modelo;

public class Professor {

	private String nome, matricula, qntdAlunos,cotasDisponiveis, cotasUsadas;;
	private int id;

	public String getCotasUsadas() {
		return cotasUsadas;
	}

	public void setCotasUsadas(String cotasUsadas) {
		this.cotasUsadas = cotasUsadas;
	}

	public String getCotasDisponiveis() {
		return cotasDisponiveis;
	}

	public void setCotasDisponiveis(String cotasDisponiveis) {
		this.cotasDisponiveis = cotasDisponiveis;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
