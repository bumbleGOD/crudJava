<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalles del Médico</title>
</head>
<body>
    <h1>Detalles del Médico</h1>
    <ul>
        <li><strong>Identificación:</strong> ${medico.identificacion}</li>
        <li><strong>Nombres:</strong> ${medico.nombres}</li>
        <li><strong>Apellidos:</strong> ${medico.apellidos}</li>
    </ul>
    <a href="<c:url value='/medicos/'/>">Volver a la lista</a>
</body>
</html>
