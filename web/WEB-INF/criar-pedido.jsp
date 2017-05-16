<%-- 
    Document   : criar-pedido
    Created on : 08/05/2017, 21:38:34
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <fieldset>
                <div style="color: red;">${mensagem}</div>
                <legend><h4>Cadastrar Pedido!</h4></legend>
                <div>
                    <label for="pedido">Pedido: </label>
                    <input type="number" name="pedido" id="pedido" placeholder="Numero do Pedido" required>
                </div>
                <div>
                    <label for="dono">Dono: </label>
                    <input type="text" name="dono" id="dono" placeholder="Dono do Pedido" required>
                </div>
                <div>
                    <label for="valor">Valor: </label>
                    <input type="number" name="valor" id="valor" placeholder="Valor do Pedido" required>
                </div>
                <div>
                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="nome" placeholder="Nome do Pedido" required>
                </div>
                <div>
                    <input type="submit" value="Cadastrar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
