<%--
  Created by IntelliJ IDEA.
  User: leonardogloria
  Date: 26/09/15
  Time: 11:19
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h1>Bem vindo</h1><br />
<g:if test="${flash.message}">
    <g:message message="${flash.message}"></g:message>
</g:if>

<g:form action="doLogin">
    Login: <g:textField name="login"></g:textField><br />
    Senha: <g:passwordField name="senha"></g:passwordField><br />
    <g:submitButton name="Logar"></g:submitButton>
</g:form>

</body>
</html>