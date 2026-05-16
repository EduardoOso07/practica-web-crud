<%-- 
    Document   : editar
    Created on : 15 may 2026, 11:13:25 p.m.
    Author     : eduos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Contacto</title>
    <meta charset="UTF-8">
    <style>
        body { font-family: Arial; margin: 20px; }
        .formulario { background: #f0f0f0; padding: 20px; border-radius: 10px; max-width: 400px; }
        input, button { margin: 5px; padding: 8px; width: 90%; }
        button { background: #4CAF50; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h2>✏️ Editar Contacto</h2>
    <div class="formulario">
        <form action="AddContacto" method="post">
            <input type="hidden" name="accion" value="actualizar">
            <input type="hidden" id="id" name="id" value="<%= request.getParameter("id") %>">
            <label>Nombre:</label><br>
            <input type="text" id="nom" name="nom" value="<%= request.getParameter("nom") %>" required><br>
            <label>Teléfono:</label><br>
            <input type="text" id="tel" name="tel" value="<%= request.getParameter("tel") %>"><br>
            <label>Dirección:</label><br>
            <input type="text" id="dir" name="dir" value="<%= request.getParameter("dir") %>"><br>
            <label>Email:</label><br>
            <input type="email" id="mail" name="mail" value="<%= request.getParameter("mail") %>" required><br><br>
            <button type="submit">Actualizar</button>
            <a href="index.jsp.html">Cancelar</a>
        </form>
    </div>
</body>
</html>
