<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de connexion</title>
<link rel="stylesheet" type="text/css" href="styles/login.css"
	media="all" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<s:form cssClass="centre" theme="css_xhtml">
				<s:label value="SARL LUNA"></s:label>
				<s:label value="Connexion"></s:label>
				<s:textfield type="text" placeholder="username" />
				<s:textfield type="password" placeholder="password" />
				<s:submit value="Login" cssClass="bouton" />
			</s:form>
		</div>
	</div>
</body>
</html>