
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
              crossorigin="anonymous"> 

        <script src="https://kit.fontawesome.com/3556f97ea7.js" crossorigin="anonymous"></script>
        <title>Editar Estudiante</title>
    </head>
    <body>
        <jsp:include page="../componentes/cabecero.jsp" />
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idEstudiante=${estudiante.idEstudiante}" method="POST" class="was-validated">
            <jsp:include page="../componentes/botonesNavegacionEdicion.jsp" />
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Estudiante</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${estudiante.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${estudiante.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Correo</label>
                                        <input type="email" class="form-control" name="email" required value="${estudiante.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${estudiante.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="edad">Edad</label>
                                        <input type="number" class="form-control" name="edad" required value="${estudiante.edad}" step="any">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>
