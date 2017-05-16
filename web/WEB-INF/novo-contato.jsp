<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo contato</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo Contato</h1>
        <div style="color: red;">${mensagem}</div>
        <form method="post">
            <div><label>Nome: <input type="text" name="nome"  placeholder="digite o nome"/></label></div>
            <div><label>Sobrenome: <input type="text" name="sobrenome"  placeholder="digite o sobrenome"/></label></div>
            <div><label>Telefone: <input type="text" name="telefone"  placeholder="digite o telefone"/></label></div>
            <div><input type="submit" /></div>
        </form>
    </body>
</html>
