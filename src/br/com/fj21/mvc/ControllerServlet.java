package br.com.fj21.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
String parametro=req.getParameter("logica");
String nomeDaClasse="br.com.fj21.mvc."+parametro;

try {
	Class classe= Class.forName(nomeDaClasse);
	Logica logica= (Logica) classe.newInstance();
	logica.executa(req, res);
	
} catch (Exception e) {
	throw new ServletException("A lógica de negócios causou uma execeção ",e);
	// TODO Auto-generated catch block
}

}
}
