<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Consultorios</title>
</head>
<body>
    <h1>Lista de Consultorios</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Número</th>
                <th>Nombre</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listConsultorios}" var="consultorio">
                <tr>
                    <td>${consultorio.numero}</td>
                    <td>${consultorio.nombre}</td>
                    <td>
                        <a href="<c:url value='/consultorios/edit?numero=${consultorio.numero}'/>">Editar</a>
                        <a href="<c:url value='/consultorios/delete?numero=${consultorio.numero}'/>">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/consultorios/new'/>">Nuevo Consultorio</a>
</body>
</html>