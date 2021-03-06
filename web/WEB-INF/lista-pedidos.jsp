<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="valorTotal" class="Long"></jsp:useBean>
    <jsp:setProperty name="valorTotal" value="0" ></jsp:setProperty>
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
                <th>
                    <select onchange="listarPedido();" id="selecionar-pedido">
                        <option value="#">Selecione um Pedido para Detalhar</option>
                        <c:forEach var="lista" items="${lista}">
                            <option value="${lista}">${lista}</option>
                        </c:forEach>
                    </select>
                </th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="pedidos" items="${pedidos}">    
                <tr>
                    <td>${pedidos.id}</td>
                    <td>${pedidos.pedido}</td>
                    <td>${pedidos.dono}</td>
                    <td>${pedidos.valor}</td>
                    <td>${pedidos.nome}</td>
                    <td>${pedidos.atualizacao}</td>
                    ${valorTotal += pedidos.valor}
                </tr>
                </c:forEach>
            <span ><strong>Valor Total: </strong><%= valorTotal %></span>
            </tbody>
            <script>
                
                function listarPedido()
                {
                    var lista = document.getElementById("selecionar-pedido");
                    var id = lista.options[lista.selectedIndex].value;
                    window.location.href = "Listar?pedido="+id;
                }
            </script>
    </body>
</html>