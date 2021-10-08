<%-- 
    Document   : listar
    Created on : 21/06/2021, 22:58:10
    Author     : welton
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cadastro</title>
    </head>
    <body>
        <h3> Lista de Cadastro </h3>
        <form method="GET" action='CadastroController' name="listar">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>   
                        <th>CPF</th>
                        <th>Data Nascimento</th>
                        <th>Data Primeira Dose</th>
                        <th>Data segunda Dose</th>
                        <th>vacinou</th>                        
                        <th colspan="2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cadastro}" var="cadastro">
                        <tr>
                            <td><c:out value="${cadastro.codigo}"/></td>
                            <td><c:out value="${cadastro.nome}"/></td>
                            <td><c:out value="${cadastro.cpf}"/></td>
                            <td><c:out value="${cadastro.anoNacimento}"/></td>
                            <td><c:out value="${cadastro.dataPrimeiraDose}"/></td>
                            <td><c:out value="${cadastro.dataSegundaDose}"/></td>
                            <td><c:out value="${cadastro.vacinou}"/></td>
                            <td><a href="CadastroController?acao=alterar&codigo=<c:out value="${cadastro.codigo}"/>">Alterar</td>
                            <td><a href="CadastroController?acao=excluir&codigo=<c:out value="${cadastro.codigo}"/>" onclick="return confirm('Confirma a exclusão?')">Excluir</td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                <td align="center">
                    <a href="CadastroController?acao=incluir">Novo Cadastro</a>
                </td>
                </tfoot>
            </table>
        </form>
    </body>
</html>
