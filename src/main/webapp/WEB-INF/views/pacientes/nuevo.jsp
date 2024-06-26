<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Paciente</title>
</head>
<body>
    <h1>Nuevo Paciente</h1>
    <form action="<c:url value='/pacientes/insert'/>" method="post">
        Identificación: <input type="text" name="identificacion" /><br/>
        Nombres: <input type="text" name="nombres" /><br/>
        Apellidos: <input type="text" name="apellidos" /><br/>
        Fecha de Nacimiento: <input type="date" name="fechaNacimiento" /><br/>
        Sexo:
        <select name="sexo">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
        </select><br/>
        <input type="submit" value="Guardar" />
    </form>
</body>
</html>
