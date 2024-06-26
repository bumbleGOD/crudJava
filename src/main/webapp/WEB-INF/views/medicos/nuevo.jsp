<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Médico</title>
</head>
<body>
    <h1>Nuevo Médico</h1>
    <form action="<c:url value='/medicos/insert'/>" method="post">
        Identificación: <input type="text" name="identificacion" /><br/>
        Nombres: <input type="text" name="nombres" /><br/>
        Apellidos: <input type="text" name="apellidos" /><br/>
        <input type="submit" value="Guardar" />
    </form>
</body>
</html>
