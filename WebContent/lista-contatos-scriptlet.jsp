<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="topo.jsp"/>

<body>
	<c:import url="menu.jsp" />


	<jsp:useBean id="dao" class="br.com.fj21.TabContatos" />

	<div align="justify" draggable="true"
		style="margin-top: 30px; margin-left: 25px;">

		<p>Lista de contatos Agenda Fj-21:</p>
		<br />
		<table border="2" cellspacing="3">
			<c:forEach var="contato" items="${dao.lista}">

				<tr>

					<td>${contato.nome}</td>
					<td><c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if></td>
					<td>${contato.endereco}</td>
					<td>${contato.dataNascimento}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="rodape.jsp"/>