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
			<s:form cssClass="centre" theme="css_xhtml" action="addLigne">
				<s:label value="Accueil Commande"></s:label>
				</br>
				<s:select value="Client" class="styled-select orange semi-square"
					list="listClient" listValue="nom" listKey="code" name="client" />
				</br>
				<s:select value="Article" class="styled-select orange semi-square"
					list="listArticle" listValue="designation" listKey="code"
					name="article" />
				</br>
				<s:textfield type="text" placeholder="Quantité" name="quantite" />
				</br>
				<s:submit value="Ajouter" cssClass="bouton" />
				</br>
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px"
					border="1px solid black">
					<tr class="even">
						<th>Designation Article</th>
						<th>Quantité</th>
						<th>Prix</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="commandeList">
						<tr>
							<td><s:property value="article.designation" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="prix" /></td>
							<td><s:a action="deleteLigne?identifiant=%{identifiant}">Supprimer</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			</br>
			<s:label value="Montant de la commande :" />
			<s:property value="montant" />
			<s:label value=" euros" />
			</br>
			<s:form action="validerCommande">
				<s:submit value="Valider la commande" cssClass="bouton" />
			</s:form>
		</div>
	</div>

</body>
</html>