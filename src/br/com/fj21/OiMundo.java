package br.com.fj21;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {
	

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter output = response.getWriter();

		output.println("<html>");
		output.println("<body>");
		output.println("Primeira servlet");
		output.write("<a href=\"http://www.giran.com.br\" target=\"new\">"
				+ "Wine" + "</a>");
		output.print("<p>For");
		
		output.println("</body>");
		output.println("</html>");
	}
}
