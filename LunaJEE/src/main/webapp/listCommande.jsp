<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Commandes</title>
<link rel="stylesheet" type="text/css" href="styles/commande.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:label value="Liste des commandes"></s:label>
			<div class="content">
				<table align="center" class="commandeTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Client</th>
						<th>PrixTTC</th>
						<th>Reglement</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="commandeList">
						<tr>
							<td><s:property value="designation" /></td>
							<td><s:property value="prixTTC" /></td>
							<td><s:property value="modeReglement" /></td>
							<td><a href="https://www.w3schools.com">Supprimer</a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>