<%-- 
    Document   : listar
    Created on : 15 may 2026, 11:03:09?p.m.
    Author     : eduos
--%>

<%@ page import="Model.*, java.util.*" %>
<%
    ContactoDAO dao = new ContactoDAO();
    List<Contacto> contactos = dao.listar();
%>

<div class="lista">
    <h3> Lista de Contactos</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th><th>Nombre</th><th>Teléfono</th><th>Dirección</th><th>Email</th><th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% if (contactos.isEmpty()) { %>
                 <tr><td colspan="6">No hay contactos registrados</td></tr>
            <% } else { 
                for(Contacto c : contactos) { 
            %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getNom() %></td>
                    <td><%= c.getTel() != null ? c.getTel() : "" %></td>
                    <td><%= c.getDir() != null ? c.getDir() : "" %></td>
                    <td><%= c.getMail() %></td>
                    <td>
                        <a href="AddContacto?accion=editar&id=<%= c.getId() %>"> Editar</a>
                        <a href="AddContacto?accion=eliminar&id=<%= c.getId() %>" 
                           onclick="return confirm('¿Eliminar este contacto?')">?? Eliminar</a>
                    </td>
                </tr>
            <% } } %>
        </tbody>
    </table>
</div>
