<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>

        <% if (usuario == null) { %>
            <p style="color:red;">
                No se encontró el usuario para editar. Por favor vuelve a intentarlo desde el formulario principal.
            </p>
        <% } else { %>
            <form action="SvActualizar" method="POST">
                <input type="hidden" name="id" value="<%= usuario.getId() %>"/>

                <label>Nombre:</label>
                <input type="text" name="nombre" value="<%= usuario.getNombre() %>"/><br><br>

                <label>Apellido:</label>
                <input type="text" name="apellido" value="<%= usuario.getApellido() %>"/><br><br>

                <input type="submit" value="Guardar Cambios"/>
            </form>
        <% } %>
    </body>
</html>
                                                                            