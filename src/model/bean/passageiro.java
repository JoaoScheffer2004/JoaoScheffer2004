package model.bean;

public class passageiro {
	
	private int idpassageiro;
	private String nome;
	private boolean genero;
	private String rg;
	private String cpf;
	private String endereco;
	private String email;
	private long telefone;
	
	
	public int getId_passageiro() {
		return idpassageiro;
	}
	public void setId_passageiro(int idpassageiro) {
		this.idpassageiro = idpassageiro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getGenero() {
		return genero;
	}
	public void setGenero(Boolean genero) {
		this.genero = genero;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	

}
