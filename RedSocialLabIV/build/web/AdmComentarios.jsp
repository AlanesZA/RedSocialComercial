<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comentarios</title>
        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>


            <div class="text-center">
                <h1>Listado de Comentarios</h1>
            </div> <br/>
            
            <div class="container">

                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="text-center">
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Comercio</th>
                            <th>Estado</th>
                            <th>Valoracion</th>
                            <th>Modificar</th>

                        </tr>
                    </thead>            
                    <tbody>
                    <c:forEach var="comentario" items="${GBD.obtenerComentario()}">
                        <tr>
                            <td>${comentario.nombre}</td>
                            <td>${comentario.descripcion}</td>  
                            <td> <c:forEach items="${GBD.obtenerComercios()}" var="comercio">          
                                    <c:if test="${comentario.comercio.id == comercio.id}">${comercio.nombre}</c:if> 

                                </c:forEach>
                            </td>

                            <th>
                                <c:choose>
                                    <c:when test="${comentario.estado == 1}">Activo</c:when>
                                    <c:otherwise>No Activo</c:otherwise>
                                </c:choose> 
                            </th>
                            <td>${comentario.valoracion}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${ comentario.estado == 1}"><a href="EditarComercio?estado=5&id=${comercio.id}" class="btn btn-danger" role="button" >Desactivar</a></c:when>
                                    <c:otherwise>  <a href="EditarComercio?estado=3&id=${comercio.id}" class="btn btn-success" role="button" >Activar</a></c:otherwise>
                                </c:choose> 
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
