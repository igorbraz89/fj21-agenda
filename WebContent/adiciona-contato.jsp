<%@include file="topo.jsp" %>
<body>
<%@include file="menu.jsp" %><br /><br />
	<div align="left" style="margin-left: 20px; margin-top: 10px;">
		<form action="adicionaContato" method="post">
			Nome:				<input type="text" name="nome"/><br />
			E-mail: 			<input type="text" name="email"/><br />
			Endere��o: 		<input type="text" name="endereco"/><br />
			Data de Nascimento: <input type="date" name="dataNascimento"/><br />
								<input type="submit" value="Salvar" />
		</form>
	</div>
<%@include file="rodape.jsp" %>