<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Médicos</title>
</head>
<body>
    <h1>Lista de Médicos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listMedicos}" var="medico">
                <tr>
                    <td>${medico.identificacion}</td>
                    <td>${medico.nombres}</td>
                    <td>${medico.apellidos}</td>
                    <td>
                        <a href="<c:url value='/medicos/edit?identificacion=${medico.identificacion}'/>">Editar</a>
                        <a href="<c:url value='/medicos/delete?identificacion=${medico.identificacion}'/>">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/medicos/new'/>">Nuevo Médico</a>
</body>
</html>
