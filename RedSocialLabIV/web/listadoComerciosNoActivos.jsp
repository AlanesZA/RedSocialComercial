<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercio No Activo</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>


            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Fecha Inicio</th>
                                    <th>Rubro</th>
                               
                                    <th>Nombre</th>
                                    <th>Modificar</th>
                                    <th>Eliminar</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${GBD.obtenerComerciosNoActivos()}">
                                <tr>
                                    <td>${item.idComercio}</td>
                                    <td>${item.fecha_inicio}</td>
                                    <td>${item.rubro}</td>
                                 
                                    <td>${item.nombre}</td>

                                    <td>

                                        <a href="ModificarComercio?id=${item.id}" class="btn btn-success" role="button" >Modificar</a>
                                    </td>
                                    <td>                                          
                                        <a href="EliminarComercio?id=${item.id}" class="btn btn-danger" role="button" >Eliminar</a>
                                    </td>

                                    <td>
                                        <form action="ListadoComerciosNoActivos" method="post">
                                            <a href="ListadoComerciosNoActivos?id=${item.id}" class="btn btn-primary" >ACTIVAR</a> 
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                    <a class="btn btn-primary" href="listadoComerciosActivos.jsp" role="button">Ver Comercios Activos</a>
                    <a class="btn btn-primary" href="registroComercio.jsp" role="button">Volver al alta Comercio</a>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
