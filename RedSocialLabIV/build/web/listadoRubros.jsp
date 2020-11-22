<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercio - Rubro</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="text-center">
                <h1>Listado de Rubros</h1>
            </div> <br/>

            <div class="container text-center">
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table">
                            <thead>
                                <tr >
                                    <th class="text-center">Rubro</th>
                                    <th class="text-center">Descripción</th>
                                    <th class="text-center">Estado</th>
                                    <th class="text-center">Modificar</th>
                                    <th class="text-center">Eliminar</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${GBD.obtenerRubro()}">
                                <tr> 
                                    <td>${item.rubro}</td>
                                    <td>${item.descripcion}</td>
                                    <td> <c:choose>
                                            <c:when test="${item.estado == 1}">Activo</c:when>
                                            <c:otherwise>No Activo</c:otherwise>
                                        </c:choose> 
                                    </td>

                                    <td>
                                        <a href="ModificarRubro?id=${item.id}" class="btn btn-success" role="button" >Modificar</a>
                                    </td>
                                    <td>                                          
                                        <a href="EliminarRubro?id=${item.id}" class="btn btn-danger" role="button" >Eliminar</a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                    <br>
                    <a href="registroRubro.jsp" class="btn btn-primary form-control" role="button">Volver al alta rubro</a>
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
