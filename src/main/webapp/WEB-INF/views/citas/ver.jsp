<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalles de la Cita</title>
</head>
<body>
    <h1>Detalles de la Cita</h1>
    <ul>
        <li><strong>Número:</strong> ${cita.numero}</li>
        <li><strong>Fecha:</strong> ${cita.fecha}</li>
        <li><strong>Hora:</strong> ${cita.hora}</li>
        <li><strong>Paciente:</strong> ${cita.paciente}</li>
        <li><strong>Médico:</strong> ${cita.medico}</li>
        <li><strong>Consultorio:</strong> ${cita.consultorio}</li>
        <li><strong>Estado:</strong> ${cita.estado}</li>
    </ul>
    <a href="<c:url value='/citas/'/>">Volver a la lista</a>
</body>
</html>
