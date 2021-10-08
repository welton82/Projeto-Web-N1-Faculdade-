<%-- 
    Document   : manter
    Created on : 21/06/2021, 23:18:15
    Author     : welton
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Manter Cadastro</title>
    </head>
    <body>
        <h3> Manter Cadastros </h3>
        <form method="POST" action='CadastroController' name="manter">

            <c:if test="${not empty erro}"> 
                <script language='javascript' type='text/javascript'>alert('<c:out value="${erro}" />');</script>
            </c:if>
               
            <table>
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" readonly="readonly" name="codigo" 
                               STYLE="font-family: Verdana; font-size: 12px; background-color: #e0e0d1;" size="10" maxlength="10"
                               value="<c:out value="${cadastro.codigo}" />"</td>
                </tr>               
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" value="<c:out value="${cadastro.nome}" />"/></td>
                </tr>
                <tr>
                    <td>Ano Nascimento</td>
                    <td><input type="text" name="anoNascimento" value="<c:out value="${cadastro.anoNascimento}" />"/></td>
                </tr>
                <tr>
                    <td>Cpf</td>
                    <td><input type="text" name="cpf" value="<c:out value="${cadastro.cpf}" />"/></td>
                </tr>
                <tr>
                    <td>Data Primeira Dose</td>
                    <td><input type="text" name="dataPrimeiraDose" value="<c:out value="${cadastro.dataPrimeiraDose}" />"/></td>
                </tr>
                <tr>
                    <td>Data Segunda Dose</td>
                    <td><input type="text" name="dataSegundaDose" value="<c:out value="${cadastro.dataSegundaDose}" />"/></td>
                </tr>
                <tr>
                    <td>Vacinou</td>
                    <td><input type="text" name="vacinou" value="<c:out value="${cadastro.vacinou}" />"/></td>
                </tr>
                <tr align="center">
                    <td><input type="submit" value="Salvar"/></td>
                    <td><input type="button" value="Voltar" onclick="history.go(-1)"/></td>
                </tr>          

            </table>
        </form>
    </body>
</html>
