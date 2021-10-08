<%-- 
    Document   : index
    Created on : 21/06/2021, 22:56:46
    Author     : welton
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minha Pagina Inicial</title>
    </head>
    <body>
        <jsp:forward page="/CadastroController?acao=listar" />
    </body>
</html>
