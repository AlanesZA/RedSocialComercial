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

                <table class="table">
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
                            <td>
                                <c:forEach var="estrellita" begin="1" end="${comentario.valoracion}">
                                    ✩
                                </c:forEach>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${ comentario.estado == 1}">
                                        <a href="ListadoComentarios?estado=1&id=${comentario.idComentario}" class="btn btn-danger" role="button" >Desactivar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="ListadoComentarios?estado=2&id=${comentario.idComentario}" class="btn btn-warning" role="button" >Reactivar</a>
                                    </c:otherwise>  
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
