<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Tratamientos</title>
</head>
<body>
    <h1>Lista de Tratamientos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Número</th>
                <th>Fecha Asignado</th>
                <th>Descripción</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Paciente</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listTratamientos}" var="tratamiento">
                <tr>
                    <td>${tratamiento.numero}</td>
                    <td>${tratamiento.fechaAsignado}</td>
                    <td>${tratamiento.descripcion}</td>
                    <td>${tratamiento.fechaInicio}</td>
                    <td>${tratamiento.fechaFin}</td>
                    <td>${tratamiento.paciente}</td>
                    <td>
                        <a href="<c:url value='/tratamientos/edit?numero=${tratamiento.numero}'/>">Editar</a>
                        <a href="<c:url value='/tratamientos/delete?numero=${tratamiento.numero}'/>">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/tratamientos/new'/>">Nuevo Tratamiento</a>
</body>
</html>
