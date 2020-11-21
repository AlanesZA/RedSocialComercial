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
                <h1>Listado de Comercios:</h1>
            </div>         
            <form action="ListaOfertas" method="post">
                <div class="container">
                    <div class="col-lg-11">

                        <div class="br-3">
                            <div class="container">
                                <div class="col-lg-12">
                                    <div class="accordion" id="accordionExample">
                                        <div class="card">
                                            <div class="card-header">
                                                <h2 class="mb-0">
                                                    <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseCero">
                                                        Filtrar por Nombre
                                                    </button>
                                                </h2>
                                            </div>
                                            <div id="collapseCero" class="collapse"  data-parent="#accordionExample">
                                                <div class="card-body">
                                                    <div class="input-group mb-3">
                                                        <div class="input-group-prepend mb-3">
                                                            <span class="input-group-text" id="basic-addon1">Primer palabra</span>
                                                        </div>
                                                        <input type="text" class="form-control" name="txtPalabra1" placeholder="Primera palabra" />
                                                        <div class="input-group-prepend mb-3">
                                                            <span class="input-group-text" id="basic-addon1">Segunda palabra</span>
                                                        </div>
                                                        <input type="text" class="form-control" name="txtPalabra2" placeholder="Segunda palabra"/>
                                                        <button class="btn btn-primary" type="submit"> Filtrar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                           
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr class="text-center">
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Comercio</th>
                                <th>Estado</th>
                                <th>Valoracion</th>
                            </tr>
                        </thead>            
                        <tbody>
                        <c:forEach var="comentario" items="${GBD.obtenerComentarios(idCome)}">
                            <tr>
                                <td>${comentario.nombre}</td>
                                <td>${comentario.descripcion}</td>  
                                <td> <c:forEach items="${GBD.obtenerComercios()}" var="comercio">          
                                        <c:if test="${comentario.comercio.id == comercio.id}">${comercio.comercio}</c:if> 
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
                                    <a href="EditarComercio?estado=3&id=${comentario.id}" class="btn btn-success" role="button" >Listado de ofertas</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="col col-lg-6">
                    <h1>Registrar Comentario</h1>
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




                        </div>

                        </form>









                        <jsp:include page="footer.jsp"></jsp:include>

                        </body>
                        </html>

