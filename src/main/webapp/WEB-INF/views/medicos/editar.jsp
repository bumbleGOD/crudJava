<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Médico</title>
</head>
<body>
    <h1>Editar Médico</h1>
    <form action="<c:url value='/medicos/update'/>" method="post">
        Identificación: <input type="text" name="identificacion" value="${medico.identificacion}" readonly /><br/>
        Nombres: <input type="text" name="nombres" value="${medico.nombres}" /><br/>
        Apellidos: <input type="text" name="apellidos" value="${medico.apellidos}" /><br/>
        <input type="submit" value="Actualizar" />
    </form>
</body>
</html>
