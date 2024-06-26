<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Consultorio</title>
</head>
<body>
    <h1>Editar Consultorio</h1>
    <form action="<c:url value='/consultorios/update'/>" method="post">
        Número: <input type="text" name="numero" value="${consultorio.numero}" readonly /><br/>
        Nombre: <input type="text" name="nombre" value="${consultorio.nombre}" /><br/>
        <input type="submit" value="Actualizar" />
    </form>
</body>
</html>
