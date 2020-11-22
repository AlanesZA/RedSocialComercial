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

                                                <th class="text-center">Fecha Inicio</th>
                                                <th class="text-center">Rubro</th>
                                                <th class="text-center">Nombre Comercio</th>  
                                                <th class="text-center">Listar Ofertas</th>

                                            </tr>
                                        </thead>
                                        <tbody >
                                            <c:forEach var="comercio" items="${GBD.obtenerComercios()}">
                                                <tr>

                                                    <td>${comercio.fechainicio}</td>
                                                    <td> <c:forEach items="${GBD.obtenerRubro()}" var="rubro">          
                                                            <c:if test="${comercio.rubro.id == rubro.id}">${rubro.rubro}</c:if> 
                                                        </c:forEach>
                                                    </td>
                                                    <td>${comercio.nombre}</td>

                                                    <td>
                                                        <a href="#" class="btn btn-success" role="button" >Mostrar</a>

                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody> 
                                    </table> 
                                </div>
                            </div>
                        </div>

                        <br>
                        <br>

                        <div class="container">

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
                                            <td> <c:forEach items="${GBD.obtenerComercios()}" var="comercio">          
                                                    <c:if test="${comentario.comercio.id == comercio.id}">${comercio.nombre}</c:if> 

                                                </c:forEach>
                                            </td>
                                            <td>${comentario.valoracion}</td>


                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        
                        

               
            <div class="col col-lg-6">
                <h1>Comentarios</h1>
            </div>

            <div class="container shadow-sm p-3 mb-5 bg-white rounded" data-aos="fade-in">
                <div class="row justify-content-center text-center">
                    <div class="col col-lg-6">
                        <h3>${nombre}</h3>
                </div>
            </div>
        </div>

        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col col-lg-6 shadow p-3 mb-5 bg-white rounded">
                    <form id="comentarios" method="post" action="alta">
                        <div class="form-group">                            
                            <label for="comentario" class="col-form-label">Nombre:</label>
                            <input class="form-control" name="txtNombre" placeholder="">
                            <div class="validate"></div>
                        </div>

                        <div class="form-group">                            
                            <label for="comentario" class="col-form-label">Comentario:</label>
                            <textarea class="form-control" aria-label="Comentario"></textarea>
                            <div class="validate"></div>
                        </div>


                        <div class="form-group">
                            <label for="comercio" class="col-form-label">Valoración:</label>                
                            <select class="form-control" name="idValoracion" id="comercio">

                                <option value="">Todas las valoraciones</option>
                                <option value="5">Cinco estrellas</option>
                                <option value="4">Cuatro estrellas</option>
                                <option value="3">Tres estrellas</option>
                                <option value="2">Dos estrellas</option>
                                <option value="1">Una estrella</option>

                            </select>
                            <div class="validate"></div>
                        </div>


                        <div class="form-group">
                            <label for="comercio" class="col-form-label">Comercio:</label>                
                            <select class="form-control" name="idComercio" id="comercio">
                                <option value="0">Seleccione un comercio...</option>
                                <c:forEach var="item" items="${GBD.obtenerComercios()}">
                                    <option value="${item.id}">${item.nombre}</option>
                                </c:forEach>
                            </select>
                            <div class="validate"></div>
                        </div>

                        <div class="form-group">
                            <label for="comercio" class="col-form-label">Ofertas:</label>                
                            <select class="form-control" name="idOferta" id="oferta">
                                <option value="0">Seleccione un comercio...</option>
                                <c:forEach var="item" items="${GBD.obtenerOferta()}">
                                    <option value="${item.id}">${item.titulo}</option>
                                </c:forEach>
                            </select>
                            <div class="validate"></div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-6">                            
                                <input type="submit" class="btn btn-primary btn-block" value="Registrar Comentario">                            
                            </div>
                        </div>
                        <br>
                        <br>



              


                <jsp:include page="footer.jsp"></jsp:include>

                </body>
                </html>

