package br.com.fj21;

import java.sql.Date;
import java.util.Calendar;

public class Contato {

	
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	// métodos get e set para id, nome, email, endereço e dataNascimento

	public Date getDataNascimento() {
	    return new Date(this.dataNascimento.getTimeInMillis());
	    
	  }
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Contato(){
		
	}
	public Contato(String nome, String email, String endereco) {
		
		
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novo) {
		this.nome = novo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String novo) {
		this.email = novo;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String novo) {
		this.endereco = novo;
	}


	public String toString() {
		return this.nome + this.endereco;
	}
}
