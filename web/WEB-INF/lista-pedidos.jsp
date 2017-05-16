<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pedidos</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Lista de Pedidos</h1>
        <div style="color: red;">${mensagem}</div>
        <table border="2">
            <thead>
                <tr>
                <th>ID</th>
                <th>Pedido</th>
                <th>Dono</th>
                <th>Valor</th>
                <th>Nome</th>
                <th>Data e Hora</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="pedidos" items="${pedidos}">    
                <tr>
                    <td><a href="detalhes.html?id=${pedidos.id}">${pedidos.id}</a></td>
                    <td>${pedidos.pedido}</td>
                    <td>${pedidos.dono}</td>
                    <td>${pedidos.valor}</td>
                    <td>${pedidos.nome}</td>
                    <td>${pedidos.atualizacao}</td>
                </tr>
                </c:forEach>
            </tbody>
    </body>
</html>