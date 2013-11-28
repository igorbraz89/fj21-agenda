package br.com.fj21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TabContatos {
	private Connection connection;

	public TabContatos() {

	}

	public void adciona(Contato contato) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		String sql_insertIntoContatos = "insert into agendaContatos"
				+ " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		PreparedStatement stmt_insert = this.connection
				.prepareStatement(sql_insertIntoContatos);
		// preenche os valores

		stmt_insert.setString(1, contato.getNome());
		stmt_insert.setString(2, contato.getEmail());
		stmt_insert.setString(3, contato.getEndereco());
		stmt_insert.setDate(4, contato.getDataNascimento());

		// executa
		stmt_insert.execute();

		stmt_insert.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex�o encerrada");
	}

	public void altera(Contato contato) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
		// cria um preparedStatement
		
		String sql_direto = "UPDATE agendaContatos SET nome='"
				+ contato.getNome() + "'," + " email='" + contato.getEmail()
				+ "'," + " endereco='" + contato.getEndereco() + "'"
				+ ", dataNascimento='" + contato.getDataNascimento() + "'"
				+ " WHERE Id='" + contato.getId() + "'";

		System.out.println("id->>>>" + contato.getId());
		System.out.println(sql_direto);
		PreparedStatement stmt_insert = this.connection
				.prepareStatement(sql_direto);

		// executa
		stmt_insert.execute();

		stmt_insert.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex�o encerrada");
	}

	public ArrayList showTabelaContatos() throws SQLException {
		// pega a conex�o e o Statement
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		this.connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt_selectAllContatos = this.connection
				.prepareStatement("select * from agendaContatos");

		// executa um select
		ResultSet rs_querySelect = stmt_selectAllContatos.executeQuery();

		// itera no ResultSet
		while (rs_querySelect.next()) {
			int id = Integer.parseInt(rs_querySelect.getString("Id"));
			String nome = rs_querySelect.getString("nome");
			String email = rs_querySelect.getString("email");
			String endereco = rs_querySelect.getString("endereco");
			Calendar data = Calendar.getInstance();
			data.setTime(rs_querySelect.getDate("dataNascimento"));
			Contato contato = new Contato(id, nome, email, endereco);
			contato.setDataNascimento(data);
			contatos.add(contato);
		}

		rs_querySelect.close();
		stmt_selectAllContatos.close();
		this.connection.close();
		return contatos;
	}

	public List<Contato> getLista() {
		this.connection = new ConnectionFactory().getConnection();
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select Id,nome,email,endereco,dataNascimento from agendaContatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("Id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// adicionando o objeto � lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			this.connection.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}// classe
