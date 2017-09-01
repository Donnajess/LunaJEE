<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="0;URL=listClient">
<title>Accueil Client</title>
<link rel="stylesheet" type="text/css" href="styles/client.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml" action="addClient">
				<s:label value="Accueil Client"></s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Nom" name="nom" />
				<s:textfield type="password" placeholder="Pr�nom" name="prenom" />
				<s:checkbox name="carte_fidele" label="Souhaitez vous une carte de fid�lit� ?" />
				<s:submit value="Cr�er" cssClass="bouton" />
			</s:form>

			<div class="content">
				<table align="center" class="clientTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Nom</th>
						<th>Prenom</th>
						<th>Carte Fidelit�</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="clientList">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="prenom" /></td>
							<td><s:property value="carte_fidele" /></td>
							<td><a href="https://www.w3schools.com">Modifier</a></td>
							<td><s:a action="deleteClient_code">Supprimer</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>