<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Paciente</title>
</head>
<body>
    <h1>Editar Paciente</h1>
    <form action="<c:url value='/pacientes/update'/>" method="post">
        Identificación: <input type="text" name="identificacion" value="${paciente.identificacion}" readonly /><br/>
        Nombres: <input type="text" name="nombres" value="${paciente.nombres}" /><br/>
        Apellidos: <input type="text" name="apellidos" value="${paciente.apellidos}" /><br/>
        Fecha de Nacimiento: <input type="date" name="fechaNacimiento" value="${paciente.fechaNacimiento}" /><br/>
        Sexo:
        <select name="sexo">
            <option value="M" <c:if test="${paciente.sexo eq 'M'}">selected</c:if>>Masculino</option>
            <option value="F" <c:if test="${paciente.sexo eq 'F'}">selected</c:if>>Femenino</option>
        </select><br/>
        <input type="submit" value="Actualizar" />
    </form>
</body>
</html>
