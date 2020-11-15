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


            <div class="container">
                <div class="row">
                    <div class="col col-md-12">

                        <table class="table">

                            <thead>
                                <tr>

                                    <th>Fecha Inicio</th>
                                    <th>Rubro</th>
                                    <th>Nombre</th>
                                    <th>Estado</th>
                                    <th>Modificar</th>
                                    <th>Eliminar</th>

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
                                    <th>
                                        <c:choose>
                                            <c:when test="${comercio.estado == 1}">Activo</c:when>
                                            <c:otherwise>No Activo</c:otherwise>
                                        </c:choose> 
                                    </th>
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
                    <a class="btn btn-primary" href="registroComercio.jsp" role="button">Volver al alta Comercio</a>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
