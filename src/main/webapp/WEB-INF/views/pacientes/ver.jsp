<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalles del Paciente</title>
</head>
<body>
    <h1>Detalles del Paciente</h1>
    <ul>
        <li><strong>Identificación:</strong> ${paciente.identificacion}</li>
        <li><strong>Nombres:</strong> ${paciente.nombres}</li>
        <li><strong>Apellidos:</strong> ${paciente.apellidos}</li>
        <li><strong>Fecha de Nacimiento:</strong> ${paciente.fechaNacimiento}</li>
        <li><strong>Sexo:</strong> ${paciente.sexo}</li>
    </ul>
    <a href="<c:url value='/pacientes/'/>">Volver a la lista</a>
</body>
</html>
