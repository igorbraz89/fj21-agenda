<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="topo.jsp"%>

<body>
	<%@include file="menu.jsp"%>


	<jsp:useBean id="dao" class="br.com.fj21.TabContatos" />

	<div align="justify" draggable="true"
		style="margin-top: 30px; margin-left: 25px;">

		<p>Lista de contatos Agenda Fj-21:</p>
		<br />
		<table border="2" cellspacing="7">
			<c:forEach var="contato" items="${dao.lista}">

				<tr>
					<td>${contato.nome}</td>
					<td>${contato.email}</td>
					<td>${contato.endereco}</td>
					<td>${contato.dataNascimento}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@include file="rodape.jsp"%>