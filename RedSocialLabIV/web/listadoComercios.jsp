<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercio</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body >
        <jsp:include page="header.jsp"></jsp:include>

            <div class="text-center">
                <h1>Listado de Comercios</h1>
            </div> 
            <br/>
            <div class="container text-center ">
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table table-hover" >
                            <thead>
                                <tr>
                                    <th  class="text-center">Fecha Inicio</th>
                                    <th  class="text-center">Rubro</th>
                                    <th  class="text-center">Nombre</th>
                                    <th  class="text-center">Estado</th>
                                    <th  class="text-center">Modificar</th>
                                    <th  class="text-center">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="comercio" items="${GBD.obtenerComercios()}">
                                <tr>
                                    <td>${comercio.fechainicio}</td>
                                    <td> <c:forEach items="${GBD.obtenerRubro()}" var="rubro">          
                                            <c:if test="${comercio.rubro.id == rubro.id}">${rubro.rubro}</c:if> 
                                        </c:forEach>
                                    </td>
                                    <td>${comercio.nombre}</td>
                                    <td class="text-center">
                                        <c:choose>
                                            <c:when test="${comercio.estado == 1}">Activo</c:when>
                                            <c:otherwise>No Activo</c:otherwise>
                                        </c:choose> 
                                    </td>
                                    <td>
                                        <a href="EditarComercio?estado=3&id=${comercio.id}" class="btn btn-success" role="button" >Modificar</a>
                                    </td>
                                    <td>                                          
                                        <a href="EditarComercio?estado=5&id=${comercio.id}" class="btn btn-danger" role="button" >Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody> 
                    </table> 
                    <a class="btn btn-primary form-control" href="registroComercio.jsp" role="button">Volver al alta Comercio</a>
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
