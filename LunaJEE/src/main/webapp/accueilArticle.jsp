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
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml">
				<s:label value="Accueil Article"></s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Designation" />
				<s:textfield type="password" placeholder="Quantité" />
				<s:textfield type="text" placeholder="Prix Unitaire" />
				<s:textfield type="text" placeholder="Categorie" />
				<s:select value="Categorie" class="styled-select green rounded" list="{'Jouet'}"/>
				<s:submit value="Créer" cssClass="bouton" />
			</s:form>

			<div class="content">
				<table align="center" class="userTable" cellpadding="5px" border="1px solid black">
					<tr class="even">
						<th>Designation</th>
						<th>Categorie</th>
						<th>Quantité</th>
						<th>Prix_Unitaire</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<s:iterator value="articleList">
						<tr>
							<td><s:property value="designation" /></td>
							<td><s:property value="categorie" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="prixUnitaire" /></td>
							<td><s:property value="mail" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>