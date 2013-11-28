package br.com.fj21;

import java.sql.Date;
import java.util.Calendar;

public class Contato {

	private int id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	// m�todos get e set para id, nome, email, endere�o e dataNascimento

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id =id;
	}

	public Date getDataNascimento() {
		return new Date(this.dataNascimento.getTimeInMillis());

	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Contato() {

	}

	public Contato(int id, String nome, String email, String endereco) {

		this.id = id;
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
