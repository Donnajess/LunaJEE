<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Client</title>
<link rel="stylesheet" type="text/css" href="styles/client.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml" action="majClient">
				<s:label value="Modification Client"></s:label>
				<s:label></s:label>
				<s:textfield type="text" placeholder="Nom" value="%{client.nom}" name="client.nom"/>
				<s:textfield type="text" placeholder="Prénom" value="%{client.prenom}" name="client.prenom"/>
				<s:textfield type="text" placeholder="Rue" value="%{client.adresse.rue}" name="adresse.rue"/>
				<s:textfield type="text" placeholder="Code Postal" value="%{client.adresse.codePostal}" name="adresse.codePostal"/>
				<s:textfield type="text" placeholder="Ville" value="%{client.adresse.ville}" name="adresse.ville"/>
				<s:submit cssClass="bouton" value="Modifier" />
			</s:form>
		</div>
	</div>

</body>
</html>