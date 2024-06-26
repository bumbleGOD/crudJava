<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Pacientes</title>
</head>
<body>
    <h1>Lista de Pacientes</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Fecha de Nacimiento</th>
                <th>Sexo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listPacientes}" var="paciente">
                <tr>
                    <td>${paciente.identificacion}</td>
                    <td>${paciente.nombres}</td>
                    <td>${paciente.apellidos}</td>
                    <td>${paciente.fechaNacimiento}</td>
                    <td>${paciente.sexo}</td>
                    <td>
                        <a href="<c:url value='/pacientes/edit?id=${paciente.identificacion}'/>">Editar</a>
                        <a href="<c:url value='/pacientes/delete?id=${paciente.identificacion}'/>">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/pacientes/new'/>">Nuevo Paciente</a>
</body>
</html>
