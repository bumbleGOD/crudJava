<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalles del Consultorio</title>
</head>
<body>
    <h1>Detalles del Consultorio</h1>
    <ul>
        <li><strong>Número:</strong> ${consultorio.numero}</li>
        <li><strong>Nombre:</strong> ${consultorio.nombre}</li>
    </ul>
    <a href="<c:url value='/consultorios/'/>">Volver a la lista</a>
</body>
</html>
