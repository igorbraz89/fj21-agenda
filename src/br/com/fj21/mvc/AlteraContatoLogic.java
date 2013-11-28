package br.com.fj21.mvc;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		RequestDispatcher rd= req.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(req, res);
		
	}

	

}
