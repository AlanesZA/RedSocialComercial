<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercios - Comentarios</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body >
        <jsp:include page="headerC.jsp"></jsp:include>

            <div class="col col-lg-6">
                <h1>Comercios</h1>
            </div>


            <div class="container text-center">
                <div class="row">
                    <div class="col col-md-12">
                        <table class="table text-center">

                            <thead >
                                <tr>
                                    <th class="text-center">Nombre Comercio</th>
                                    <th class="text-center">Rubro</th>
                                    <th class="text-center">Ver Ofertas</th>

                                </tr>
                            </thead>
                            <tbody >
                            <c:forEach var="comercio" items="${GBD.obtenerComercios()}">
                                <tr>
                                    <td>${comercio.nombre}</td>
                                    <td> <c:forEach items="${GBD.obtenerRubro()}" var="rubro">          
                                            <c:if test="${comercio.rubro.id == rubro.id}">${rubro.rubro}</c:if> 
                                        </c:forEach>
                                    </td>

                                    <td>
                                        <a href="homeUsuarioComertarios.jsp" class="btn btn-success" role="button" >Mostrar</a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody> 
                    </table> 
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>

