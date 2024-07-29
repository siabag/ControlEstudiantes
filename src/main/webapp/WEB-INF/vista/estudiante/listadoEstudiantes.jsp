<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX"/>

<section id="estudiantes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Estudiantes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>Email</th>
                                <th>Edad</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="estudiante" items="${estudiantes}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${estudiante.nombre}</td>
                                    <td>${estudiante.apellido}</td>
                                    <td>${estudiante.email}</td>
                                    <td>${estudiante.telefono}</td>
                                    <td><fmt:formatNumber value="${estudiante.edad}"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idEstudiante=${estudiante.idEstudiante}" class="btn btn-secondary">
                                            <i class="fas fa-angel-double-right"></i>Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idEstudiante=${estudiante.idEstudiante}" class="btn btn-secondary">
                                            <i class="fas fa-angel-double-right"></i>Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Estudiantes</h3>
                        <h4 class="display-4">
                            <i></i>${totalEstudiantes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="agregarEstudiante.jsp"/>