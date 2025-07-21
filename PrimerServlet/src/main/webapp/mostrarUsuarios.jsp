<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios registrados</h1>
        <%
            List<Usuario> listUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
            if (listUsuarios != null) {
                int cont = 1;
                for (Usuario usu : listUsuarios) {
        %>
                    <p><b>Usuario N° <%= cont %></b></p>
                    <p>Id: <%= usu.getId() %></p> <!-- <-- AGREGADO -->
                    <p>Dni: <%= usu.getDni() %></p>
                    <p>Nombre: <%= usu.getNombre() %></p>
                    <p>Apellido: <%= usu.getApellido() %></p>
                    <p>Telefono: <%= usu.getTelefono() %></p>
                    <p>------------------------------------</p>
        <%
                    cont++;
                }
            } else {
        %>
                <p>No hay usuarios registrados en la sesión.</p>
        <%
            }
        %>
    </body>
</html>
