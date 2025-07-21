<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de prueba</title>
    </head>
    <body>
        <h1>Registro de usuario</h1>
       
        <!-- Formulario para CREAR usuario -->
        <form action="SvUsuarios" method="POST">
            <label for="dni">DNI:</label>
            <input type="text" name="dni" required><br>
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required><br>
            <label for="apellido">Apellido:</label>
            <input type="text" name="apellido" required><br>
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" required><br><br>
            <input type="submit" value="Guardar usuario">
        </form>
        <br>


        <!-- Título y párrafo para ver lista de usuarios -->
        <h2>Ver lista de usuarios</h2>
        <p>Para ver los datos de los usuarios cargados haga click en el siguiente botón</p>


        <!-- Formulario para MOSTRAR usuarios -->
        <form action="SvUsuarios" method="GET">
            <input type="submit" value="Mostrar usuarios">
        </form>
        <br>


        <!-- Título y párrafo para eliminar usuario -->
        <h2>Eliminar Usuario</h2>
        <p>Ingrese la id del usuario que quiere eliminar</p>


        <!-- Formulario para ELIMINAR usuario -->
        <form action="SvEliminar" method="POST">
            <label for="id_usuario">Id:</label>
            <input type="text" name="id_usuario" required><br><br>
            <input type="submit" value="Eliminar usuario">
        </form>
        <br>


        <!-- Título y párrafo para editar usuario -->
        <h2>Editar Usuario</h2>
        <p>Ingrese la id del usuario que quiere editar</p>


        <!-- Formulario para EDITAR usuario -->
        <form action="SvEditar" method="GET">
            <label for="id_usuarioEdit">Id:</label>
            <input type="text" name="id_usuarioEdit" required><br><br>
            <input type="submit" value="Editar usuario">
        </form>
        <!-- Seccion mascotas -->
        <h2>Gestión de Mascotas</h2>
        <p>Ir al listado y registro de mascotas</p>
        <form action="MascotaServlet" method="GET">
             <input type="hidden" name="action" value="listar">
             <input type="submit" value="Ir al módulo de mascotas">
        </form>
    </body>
</html>
