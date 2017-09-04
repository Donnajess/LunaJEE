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
				<s:textfield type="text" placeholder="Nom" name="client.nom" />
				<s:textfield type="text" placeholder="Prénom" name="client.prenom" />
				<s:label>"Souhaitez vous une carte de fidélité ?"</s:label>
				<s:checkbox name="client.carte_fidele" fieldValue="true" />
				<s:textfield type="text" placeholder="Rue" name="adresse.rue" />
				<s:textfield type="text" placeholder="Code" name="adresse.codePostal" />
				<s:textfield type="text" placeholder="Ville" name="adresse.ville" />
				<s:submit value="Créer" cssClass="bouton" />
			</s:form>

			<div class="content">
				<table align="center" class="clientTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Nom</th>
						<th>Prenom</th>
						<th>carte_fidelite</th>
						<th>Ville</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="clientList">
						<tr>
							<td><s:property value="nom" /></td>
							<td><s:property value="prenom" /></td>
							<td><s:property value="carte_fidele" /></td>
							<td><s:property value="adresse.ville" /></td>
							<td><s:a action="updateClient?code=%{code}">Modifier</s:a></td>
							<td><s:a action="deleteClient?code=%{code}">Suppression</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>