<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Commandes</title>
<link rel="stylesheet" type="text/css" href="styles/commande.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<table>
			<tr>
				<td><s:form cssClass="centre" theme="css_xhtml"
						action="accueil">
						<s:submit value="Accueil" cssClass="boutonAccueil" />
					</s:form></td>
				<td><s:form cssClass="centre" theme="css_xhtml"
						action="listClient">
						<s:submit value="Client" cssClass="boutonClient" />
					</s:form></td>
				<td><s:form cssClass="centre" theme="css_xhtml"
						action="listArticle">
						<s:submit value="Article" cssClass="boutonArticle" />
					</s:form></td>
				<td><s:form cssClass="centre" theme="css_xhtml"
						action="donneListes">
						<s:submit value="Commande" cssClass="boutonCommande" />
					</s:form></td>
			</tr>
		</table>
		<div class="form">
			<s:form class="centre" theme="css_xhtml">
				<s:label cssClass="labelTitre" value="Liste des commandes">
					<img src="images/commande.png" />
				</s:label>
			</s:form>
			</br> </br>
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
							<td><s:property value="client.nom" /></td>
							<td><s:property value="prixTTC" /></td>
							<td><s:property value="modeReglement" /></td>
							<td><s:a action="deleteCommande?code=%{code}"
									onclick="javascript: if (confirm('Voulez-vous supprimer cet article ?'))  
														return true; else return false; ">
									<img src="images/delete.png" />
								</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
</body>
</html>