<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Client</title>
<link rel="stylesheet" type="text/css" href="styles/client.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml">
				<s:label value="Accueil Client"></s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Nom" />
				<s:textfield type="password" placeholder="Prénom" />
				<s:textfield type="text" placeholder="Rue" />
				<s:textfield type="text" placeholder="Code Postal" />
				<s:textfield type="text" placeholder="Ville" />
				<s:submit value="Créer" cssClass="bouton"/>
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px" border="1px solid black">
					<tr class="even">
						<th>Nom</th>
						<th>Prenom</th>
						<th>Carte Fidelité</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="clientList">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="prenom" /></td>
							<td><s:property value="carte_fidele" /></td>
							<td> <a href="https://www.w3schools.com">Modifier</a> </td>
							<td> <a href="https://www.w3schools.com">Supprimer</a> </td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>