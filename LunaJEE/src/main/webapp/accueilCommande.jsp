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
			<s:form cssClass="centre" theme="css_xhtml">
				<s:label value="Accueil Commande"></s:label>
				<s:label></s:label>
				<s:select value="Client" class="styled-select orange rounded" list="{'Client'}"/>
				<s:select value="Article" class="styled-select orange rounded" list="{'Article'}"/>
				<s:textfield type="text" placeholder="Quantité" />
				<s:submit value="Ajouter" cssClass="bouton"/>
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px" border="1px solid black">
					<tr class="even">
						<th>Designation Article</th>
						<th>Quantité</th>
						<th>Prix</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="commandeList">
						<tr>
							<td><s:property value="designation" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="prixttc" /></td>
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