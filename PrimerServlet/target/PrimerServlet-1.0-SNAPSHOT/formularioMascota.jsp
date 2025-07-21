<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.primerservlet.servlets.Mascota" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
    Mascota mascota = (Mascota) request.getAttribute("mascota");
    boolean esEdicion = (mascota != null);
%>


<!DOCTYPE html>
<html>
<head>
    <title><%= esEdicion ? "Editar" : "Registrar" %> Mascota</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        form { width: 100%; max-width: 800px; }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin-top: 4px; }
        button { margin-top: 20px; padding: 10px 20px; }
    </style>
</head>
<body>


    <h1><%= esEdicion ? "Editar" : "Registrar Nueva" %> Mascota</h1>


    <form action="MascotaServlet" method="post">
        <% if (esEdicion) { %>
         <input type="hidden" name="id" value="<%= mascota.getId() %>">
         <% } %>
     <input type="hidden" name="action" value="<%= esEdicion ? "actualizar" : "insertar" %>">


        <label>Nombre Mascota:</label>
        <input type="text" name="nombreMascota" value="<%= esEdicion ? mascota.getNombreMascota() : "" %>" required>


        <label>ID Mascota:</label>
        <input type="text" name="idMascota" value="<%= esEdicion ? mascota.getIdMascota() : "" %>" required>


        <label>ID Propietario:</label>
        <input type="text" name="idPropietario" value="<%= esEdicion ? mascota.getIdPropietario() : "" %>" required>


        <label>Edad:</label>
        <input type="number" name="edad" value="<%= esEdicion ? mascota.getEdad() : "" %>" required>


        <label>Especie:</label>
        <input type="text" name="especie" value="<%= esEdicion ? mascota.getEspecie() : "" %>" required>


        <label>Raza:</label>
        <input type="text" name="raza" value="<%= esEdicion ? mascota.getRaza() : "" %>" required>


        <label>Sexo:</label>
        <select name="sexo" required>
            <option value="Macho" <%= esEdicion && mascota.getSexo().equals("Macho") ? "selected" : "" %>>Macho</option>
            <option value="Hembra" <%= esEdicion && mascota.getSexo().equals("Hembra") ? "selected" : "" %>>Hembra</option>
        </select>


        <label>Fecha (yyyy-MM-dd):</label>
        <input type="date" name="fecha" value="<%= esEdicion && mascota.getFecha() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(mascota.getFecha()) : "" %>" required>


        <h3>Cirugías</h3>
        <label>Nombre Procedimiento:</label>
        <input type="text" name="nombreProcedimiento" value="<%= esEdicion ? mascota.getNombreProcedimiento() : "" %>">


        <label>Fecha Procedimiento:</label>
        <input type="date" name="fechaProcedimiento" value="<%= esEdicion && mascota.getFechaProcedimiento() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(mascota.getFechaProcedimiento()) : "" %>">


        <label>Responsable Procedimiento:</label>
        <input type="text" name="responsableProcedimiento" value="<%= esEdicion ? mascota.getResponsableProcedimiento() : "" %>">


        <h3>Medicamentos</h3>
        <label>Nombre Medicamento:</label>
        <input type="text" name="nombreMedicamento" value="<%= esEdicion ? mascota.getNombreMedicamento() : "" %>">


        <label>Dosis:</label>
        <input type="text" name="dosis" value="<%= esEdicion ? mascota.getDosis() : "" %>">


        <label>Frecuencia:</label>
        <input type="text" name="frecuencia" value="<%= esEdicion ? mascota.getFrecuencia() : "" %>">


        <button type="submit"><%= esEdicion ? "Actualizar" : "Registrar" %> Mascota</button>
    </form>


    <p><a href="MascotaServlet?action=listar">🔙 Volver al listado</a></p>




</body>
</html>


