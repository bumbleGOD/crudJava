<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalles del Tratamiento</title>
</head>
<body>
    <h1>Detalles del Tratamiento</h1>
    <ul>
        <li><strong>Número:</strong> ${tratamiento.numero}</li>
        <li><strong>Fecha Asignado:</strong> ${tratamiento.fechaAsignado}</li>
        <li><strong>Descripción:</strong> ${tratamiento.descripcion}</li>
        <li><strong>Fecha Inicio:</strong> ${tratamiento.fechaInicio}</li>
        <li><strong>Fecha Fin:</strong> ${tratamiento.fechaFin}</li>
        <li><strong>Paciente:</strong> ${tratamiento.paciente}</li>
    </ul>
    <a href="<c:url value='/tratamientos/'/>">Volver a la lista</a>
</body>
</html>
