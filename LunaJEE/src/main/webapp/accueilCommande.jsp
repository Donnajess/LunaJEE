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
						action="listerCommande">
						<s:submit value="Liste des commandes" cssClass="boutonCommande" />
					</s:form></td>
			</tr>
		</table>
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml" action="addLigne">
				<s:label cssClass="labelTitre" value="Accueil Commande">
					<img src="images/commande.png" />
				</s:label>
				</br>
				<s:select label="Client" class="styled-select orange semi-square"
					list="listClient" listValue="nom" listKey="code" name="client" />
				<br>
				<s:select label="Mode de Reglement"
					class="styled-select orange semi-square" list="listReglements"
					name="modeReglement" />
				<b>--------------------------------------------------------------</b>
				<s:select value="Article" class="styled-select orange semi-square"
					list="listArticle" listValue="designation" listKey="code"
					name="article" />
				</br>
				<s:textfield type="text" placeholder="Quantit�" name="quantite" />
				</br>
				<s:submit value="Ajouter" cssClass="bouton" />
				</br>
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Designation Article</th>
						<th>Quantit�</th>
						<th>Prix</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="commandeList">
						<tr>
							<td><s:property value="article.designation" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="prix" /></td>
							<td><s:a action="deleteLigne?identifiant=%{identifiant}"
									onclick="javascript: if (confirm('Voulez-vous supprimer cet article ?'))  
														return true; else return false; ">
									<img src="images/delete.png" />
								</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			</br>
			<s:label value="Montant de la commande :" />
			<s:property value="montant" />
			<s:label value=" euros" />
			<s:form cssClass="centre" theme="css_xhtml" action="validerCommande">
				<s:submit value="Valider la commande" cssClass="bouton" />
			</s:form>
		</div>
	</div>

</body>
</html>