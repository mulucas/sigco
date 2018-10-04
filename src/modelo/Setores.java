package modelo;

public class Setores {
	private String nome,cotasDisponiveis;
	private int id,  cotasUsadas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCotasDisponiveis() {
		return cotasDisponiveis;
	}
	public void setCotasDisponiveis(String cotasDisponiveis) {
		this.cotasDisponiveis = cotasDisponiveis;
	}
	public int getCotasUsadas() {
		return cotasUsadas;
	}
	public void setCotasUsadas(int cotasUsadas) {
		this.cotasUsadas = cotasUsadas;
	}
}
