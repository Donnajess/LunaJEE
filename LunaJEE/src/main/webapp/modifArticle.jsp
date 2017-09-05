<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Article</title>
<link rel="stylesheet" type="text/css" href="styles/article.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml" action="majArticle">
				<s:label  cssClass="labelTitre" value="Modification Article"></s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Designation" name="article.designation"/>
				<s:textfield type="text" placeholder="Quantité" name="article.quantite" />
				<s:textfield type="text" placeholder="Prix Unitaire" name="article.prixUnitaire" />
				<s:select list="listCategories" class="styled-select green rounded" listValue="designation" name="cat" listKey="code" />
				<s:submit value="Modifier" cssClass="bouton" />
			</s:form>
		</div>
	</div>

</body>
</html>