<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Tratamiento</title>
</head>
<body>
    <h1>Editar Tratamiento</h1>
    <form action="<c:url value='/tratamientos/update'/>" method="post">
        Número: <input type="text" name="numero" value="${tratamiento.numero}" readonly /><br/>
        Fecha Asignado: <input type="date" name="fechaAsignado" value="${tratamiento.fechaAsignado}" /><br/>
        Descripción: <textarea name="descripcion">${tratamiento.descripcion}</textarea><br/>
        Fecha Inicio: <input type="date" name="fechaInicio" value="${tratamiento.fechaInicio}" /><br/>
        Fecha Fin: <input type="date" name="fechaFin" value="${tratamiento.fechaFin}" /><br/>
        Paciente: <input type="text" name="paciente" value="${tratamiento.paciente}" /><br/>
        <input type="submit" value="Actualizar" />
    </form>
</body>
</html>
