<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Cita</title>
</head>
<body>
    <h1>Nueva Cita</h1>
    <form action="<c:url value='/citas/insert'/>" method="post">
        Fecha: <input type="date" name="fecha" /><br/>
        Hora: <input type="text" name="hora" /><br/>
        Paciente: <input type="text" name="paciente" /><br/>
        Médico: <input type="text" name="medico" /><br/>
        Consultorio: <input type="text" name="consultorio" /><br/>
        Estado:
        <select name="estado">
            <option value="Asignada">Asignada</option>
            <option value="Cumplida">Cumplida</option>
            <option value="Solicitada">Solicitada</option>
            <option value="Cancelada">Cancelada</option>
        </select><br/>
        <input type="submit" value="Guardar" />
    </form>
</body>
</html>
