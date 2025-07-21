<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.mycompany.primerservlet.servlets.Mascota" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Mascotas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #999;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        h1 {
            color: #333;
        }
        .acciones {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>

    <h1>Listado de Mascotas - Historial Médico</h1>

    <a href="formularioMascota.jsp">➕ Agregar nueva mascota</a> | <a href="index.jsp">🏠 Volver al menú principal</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Mascota</th>
                <th>ID Mascota</th>
                <th>ID Propietario</th>
                <th>Edad</th>
                <th>Especie</th>
                <th>Raza</th>
                <th>Sexo</th>
                <th>Fecha</th>
                <th>Procedimiento</th>
                <th>Fecha Proced.</th>
                <th>Responsable</th>
                <th>Medicamento</th>
                <th>Dosis</th>
                <th>Frecuencia</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${not empty listaMascotas}">
        <c:forEach var="m" items="${listaMascotas}">
            <tr>
                <td>${m.id}</td>
                <td>${m.nombreMascota}</td>
                <td>${m.idMascota}</td>
                <td>${m.idPropietario}</td>
                <td>${m.edad}</td>
                <td>${m.especie}</td>
                <td>${m.raza}</td>
                <td>${m.sexo}</td>
                <td><fmt:formatDate value="${m.fecha}" pattern="yyyy-MM-dd"/></td>
                <td>${m.nombreProcedimiento}</td>
                <td><fmt:formatDate value="${m.fechaProcedimiento}" pattern="yyyy-MM-dd"/></td>
                <td>${m.responsableProcedimiento}</td>
                <td>${m.nombreMedicamento}</td>
                <td>${m.dosis}</td>
                <td>${m.frecuencia}</td>
                <td class="acciones">
                    <a href="MascotaServlet?action=editar&id=${m.id}">✏️ Editar</a>
                    <a href="MascotaServlet?action=eliminar&id=${m.id}" onclick="return confirm('¿Eliminar esta mascota?')">🗑 Eliminar</a>
                </td>
            </tr>
            </c:forEach>
                </c:if>
                    <c:if test="${empty listaMascotas}">
                    <tr><td colspan="16">No hay mascotas registradas.</td></tr>
                </c:if>
        </tbody>
    </table>

</body>
</html>
