<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="includes.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="headerC.jsp"></jsp:include>
            <div class=" text-center ">
                <h1>Ofertas </h1>
            </div>
            <br>
            <div class="container">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="text-center">
                            <th>Cantidad</th>
                            <th>Fecha Inicio</th>
                            <th>Precio Oferta</th>
                            <th>Fecha Inic. Oferta</th>
                            <th>Dias Vigencia</th>
                            <th>Titulo</th>
                            <th>Comercio</th>
                            <th>Rubro</th>
                        </tr>
                    </thead>            
                    <tbody>
                    <c:forEach var="oferta" items="${lista}">
                        <tr>
                            <td>${oferta.cantidad}</td>
                            <td>${oferta.fecha_inicio}</td>
                            <td>${oferta.precio_oferta}</td>
                            <td>${oferta.fecha_inicio_oferta}</td>
                            <td>${oferta.dias_vigencia}</td>
                            <td>${oferta.titulo}</td>
                            <td>${oferta.comercio}</td>
                            <td>${oferta.rubro}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            
            <div class="text-center">
                <h1>Comentarios</h1>
            </div>
            <form id="comentarios" method="post" action="ABMComentario?modo=alta">
                <input type="hidden" name="idComercio" value="${idComercio}"/>
                <div class="form-group">                            
                    <label for="comentario" class="col-form-label">Nombre:</label>
                    <input class="form-control" name="txtNombre" placeholder="">
                </div>
                <div class="form-group">                            
                    <label for="comentario" class="col-form-label">Comentario:</label>
                    <textarea class="form-control" name="txtComentario"></textarea>
                </div>
                
                
                <div class="form-group">
                    <label for="comercio" class="col-form-label">Valoración:</label>                
                    <select class="form-control" name="cboValoracion" id="comercio">
                        <option value="">Todas las valoraciones</option>
                        <option value="5">Cinco estrellas</option>
                        <option value="4">Cuatro estrellas</option>
                        <option value="3">Tres estrellas</option>
                        <option value="2">Dos estrellas</option>
                        <option value="1">Una estrella</option>
                    </select>
                    <div class="validate"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">                            
                        <input type="submit" class="btn btn-primary btn-block" value="Registrar Comentario">                            
                    </div>
                </div>
            </form>
            <br>
            <br>
            <div class="text-center">
                <h1>Listado de Comentarios</h1>
            </div>
            <br>
            <br>
            <table class="table table-bordered table-hover">
                <thead>
                    <tr class="text-center">
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Comercio</th>
                        <th>Valoracion</th>
                    </tr>
                </thead>            
                <tbody>
                    <c:forEach var="comentario" items="${GBD.obtenerComentario()}">
                        <tr>
                            <td>${comentario.nombre}</td>
                            <td>${comentario.descripcion}</td>  
                            <td> <c:forEach items="${GBD.obtenerComentarioXComercio(idComercio)}" var="comercio">          
                                    ${comercio.nombre}
                                </c:forEach>
                            </td>
                            <td>${comentario.valoracion}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
               
         <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
