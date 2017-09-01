<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="styles/login.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:label value="Accueil"></s:label>
			</br>
			<s:form cssClass="centre" theme="css_xhtml" action="listClient"
				method="post">
				<s:submit name="Valider" cssClass="bouton" value="Client" />
			</s:form>
			<s:form cssClass="centre" theme="css_xhtml" action="article"
				method="post">
				<s:submit name="Valider" value="Article" cssClass="bouton" />
			</s:form>
			<s:form cssClass="centre" theme="css_xhtml" action="commande"
				method="post">
				<s:submit name="Valider" value="Commande" cssClass="bouton" />
			</s:form>
		</div>
	</div>
</body>
</html>