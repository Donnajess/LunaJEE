<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Article</title>
<link rel="stylesheet" type="text/css" href="styles/article.css"
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
						action="donneListes">
						<s:submit value="Commande" cssClass="boutonCommande" />
					</s:form></td>
			</tr>
		</table>
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml" action="addArticle">
				<s:label cssClass="labelTitre" value="Accueil Article">
					<img src="images/article.png" />
				</s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Designation"
					name="article.designation" />
				<s:textfield type="text" placeholder="Quantité"
					name="article.quantite" />
				<s:textfield type="text" placeholder="Prix Unitaire"
					name="article.prixUnitaire" />
				<s:select list="listCategories" class="styled-select green rounded"
					listValue="designation" name="cat" listKey="code" />
				<br>
				<s:submit value="Créer" cssClass="bouton" />
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Designation</th>
						<th>Categorie</th>
						<th>Quantité</th>
						<th>Prix_Unitaire</th>
						<th></th>
						<th></th>
					</tr>
					<s:iterator value="listArticles">
						<tr>
							<td><s:property value="designation" /></td>
							<td><s:property value="categorie.designation" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="prixUnitaire" /></td>
							<td><s:a action="updateArticle?code=%{code}">
									<img src="images/modif.png" />
								</s:a></td>
							<td><s:a action="deleteArticle?code=%{code}"
									onclick="javascript: if (confirm('Voulez-vous supprimer cet article ?'))  
														return true; else return false; ">
									<img src="images/delete.png" />
								</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>