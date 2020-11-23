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
                <h1>Listado de Ofertas</h1>
            </div> 
            <br/>
            <div class="container">
                <div class="row">
                    <div class="col col-md-12">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Cantidad</th>
                                    <th>Precio Oferta</th>
                                    <th>Fecha Inic. Oferta</th>
                                    <th>Dias Vigencia</th>
                                    <th>Titulo</th>
                                    <th>Estado</th>
                                    <th>Comercio</th>
                                    <th>Modificar</th>
                                    <th>Eliminar</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="oferta" items="${GBD.obtenerOferta()}">
                                <tr>
                                    <td>${oferta.cantidad}</td>
                                    <td>${oferta.precio}</td>
                                    <td>${oferta.fechaInicioOferta}</td>
                                    <td>${oferta.diasVigencia}</td>
                                    <td>${oferta.titulo}</td>
                                    <td class="text-center">
                                        <c:choose>
                                            <c:when test="${oferta.estado == 1}">Activo</c:when>
                                            <c:otherwise>No Activo</c:otherwise>
                                        </c:choose> 
                                    </td>
                                    <td> <c:forEach items="${GBD.obtenerComercios()}" var="comercio">          
                                            <c:if test="${oferta.comercio.id == comercio.id}">${comercio.nombre}</c:if> 
                                        </c:forEach>
                                    </td>
                                    <td> 
                                        <a href="EditarOferta?estado=3&id=${oferta.id} "class="btn btn-success" role="button">Editar</a>
                                    </td>
                                    <td>                                          
                                        <a href="EditarOferta?estado=5&id=${oferta.id}" class="btn btn-danger" role="button">Eliminar</a>
                                    </td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                    <a class="btn btn-primary" href="registroOferta.jsp" role="button">Volver a Alta de Oferta</a>
                    <a class="btn btn-primary" href="home.jsp" role="button">Volver inicio</a>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
