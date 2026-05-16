<%@ page import="Model.Contacto, Model.ContactoDAO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agenda de Contactos</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Agenda de Contactos</h1>
    
    <%
        String msg = request.getParameter("msg");
        if (msg != null && msg.equals("guardado")) {
            out.println("<p style='color:green'>Contacto guardado</p>");
        }
    %>
    
    <h3>Nuevo Contacto</h3>
    <form action="AddContacto" method="post">
        <input type="hidden" name="accion" value="guardar">
        Nombre: <input type="text" name="nom" required><br>
        Telefono: <input type="text" name="tel"><br>
        Direccion: <input type="text" name="dir"><br>
        Email: <input type="email" name="mail" required><br>
        <button type="submit">Guardar</button>
    </form>
    
    <h3>Lista de Contactos</h3>
    <%
        ContactoDAO dao = new ContactoDAO();
        List<Contacto> contactos = dao.listar();
        out.println("<p>Numero de contactos: " + contactos.size() + "</p>");
    %>
    <table border="1">
        <tr>
            <th>ID</th><th>Nombre</th><th>Telefono</th><th>Direccion</th><th>Email</th><th>Acciones</th>
        </tr>
        <%
            for (Contacto c : contactos) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNom() %></td>
            <td><%= c.getTel() != null ? c.getTel() : "" %></td>
            <td><%= c.getDir() != null ? c.getDir() : "" %></td>
            <td><%= c.getMail() %></td>
            <td>
                <a href="AddContacto?accion=editar&id=<%= c.getId() %>">Editar</a>
                <a href="AddContacto?accion=eliminar&id=<%= c.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>