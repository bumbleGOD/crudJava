<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Consultorio</title>
</head>
<body>
    <h1>Nuevo Consultorio</h1>
    <form action="<c:url value='/consultorios/insert'/>" method="post">
        Número: <input type="text" name="numero" /><br/>
        Nombre: <input type="text" name="nombre" /><br/>
        <input type="submit" value="Guardar" />
    </form>
</body>
</html>
