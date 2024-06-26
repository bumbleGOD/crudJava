<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Citas</title>
</head>
<body>
    <h1>Lista de Citas</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Número</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Paciente</th>
                <th>Médico</th>
                <th>Consultorio</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listCitas}" var="cita">
                <tr>
                    <td>${cita.numero}</td>
                    <td>${cita.fecha}</td>
                    <td>${cita.hora}</td>
                    <td>${cita.paciente}</td>
                    <td>${cita.medico}</td>
                    <td>${cita.consultorio}</td>
                    <td>${cita.estado}</td>
                    <td>
                        <a href="<c:url value='/citas/edit?numero=${cita.numero}'/>">Editar</a>
                        <a href="<c:url value='/citas/delete?numero=${cita.numero}'/>">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/citas/new'/>">Nueva Cita</a>
</body>
</html>
