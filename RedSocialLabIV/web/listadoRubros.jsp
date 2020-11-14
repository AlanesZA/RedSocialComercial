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


            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Rubro</th>
                                    <th>Descripción</th>
                                    <th>Estado</th>
                                    <th>Modificar</th>
                                    <th>Eliminar</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${GBD.obtenerRubro()}">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.rubro}</td>
                                    <td>${item.descripcion}</td>
                                    <td>${item.estado}</td>

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

                    <a class="btn btn-primary" href="registroRubro.jsp" role="button">Volver al alta rubro</a>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
