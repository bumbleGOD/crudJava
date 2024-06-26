<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Tratamiento</title>
</head>
<body>
    <h1>Nuevo Tratamiento</h1>
    <form action="<c:url value='/tratamientos/insert'/>" method="post">
        Fecha Asignado: <input type="date" name="fechaAsignado" /><br/>
        Descripción: <textarea name="descripcion"></textarea><br/>
        Fecha Inicio: <input type="date" name="fechaInicio" /><br/>
        Fecha Fin: <input type="date" name="fechaFin" /><br/>
        Paciente: <input type="text" name="paciente" /><br/>
        <input type="submit" value="Guardar" />
    </form>
</body>
</html>
