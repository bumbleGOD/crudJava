<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Editar Cita</title>
    </head>

    <body>
        <h1>Editar Cita</h1>
        <form action="<c:url value='/citas/update'/>" method="post">
            Número: <input type="text" name="numero" value="${cita.numero}" readonly /><br />
            Fecha: <input type="date" name="fecha" value="${cita.fecha}" /><br />
            Hora: <input type="text" name="hora" value="${cita.hora}" /><br />
            Paciente: <input type="text" name="paciente" value="${cita.paciente}" /><br />
            Médico: <input type="text" name="medico" value="${cita.medico}" /><br />
            Consultorio: <input type="text" name="consultorio" value="${cita.consultorio}" /><br />
            Estado:
            <select name="estado">
                <option value="Asignada" <c:if test="${cita.estado eq 'Asignada'}">selected</c:if>>Asignada</option>
                <option value="Cumplida" <c:if test="${cita.estado eq 'Cumplida'}">selected</c:if>>Cumplida</option>
                <option value="Solicitada" <c:if test="${cita.estado eq 'Solicitada'}">selected</c:if>>Solicitada
                </option>
                <option value="Cancelada" <c:if test="${cita.estado eq 'Cancelada'}">selected</c:if>>Cancelada</option>
            </select><br />
            <input type="submit" value="Actualizar" />
        </form>
    </body>

    </html>