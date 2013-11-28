package br.com.fj21;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlteraContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-scriptlet.jsp");
		
		// writer
		PrintWriter out = response.getWriter();
		// BUSCANDO PARAMETROS
		int id =Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataText = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		try {
			Date data = new SimpleDateFormat("yyyy-dd-MM").parse(dataText);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (java.text.ParseException e) {
			rd.forward(request,response);
			
			return;// para execu��o do metodo
		}

		// criando contato
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		TabContatos salvaContato = new TabContatos();
		try {
			salvaContato.altera(contato);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao tentar salvar o contato");
		}
		//redireciona para outra pagina
		rd.forward(request,response);
		

	}// fim classe
}
