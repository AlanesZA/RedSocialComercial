<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercio</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body >
        <jsp:include page="header.jsp"></jsp:include>

         <div class="col col-lg-6">
                    <h1>Reportes</h1>
                </div> 
                
                <div class="container">
                    <div class="col-lg-12">
                        <div class="accordion" id="accordionExample">

                            <div class="card">
                              <div class="card-header">
                                <h2 class="mb-0">
                                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseCero">
                                    Valoracion general
                                  </button>
                                </h2>
                              </div>
                              <div id="collapseCero" class="collapse"  data-parent="#accordionExample">
                                <div class="card-body">
                                  <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text" id="basic-addon1">Valoracion general</span>
                                    </div>
                                    <button type="button" class="btn btn-secondary btn-lg" disabled > ${ ValoracionGeneral } </button>
                                  </div>
                                </div>
                              </div>
                            </div>

                            <div class="card">
                              <div class="card-header">
                                <h2 class="mb-0">
                                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne">
                                    Comentarios sin respuesta
                                  </button>
                                </h2>
                              </div>
                              <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                                <div class="card-body">
                                  <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr class="text-center">
                                            <th>Valoracion</th>
                                            <th>Descripcion</th>
                                            
                                            <th>Comercio</th>
                                        </tr>
                                    </thead>            
                                    <tbody>
                                        <c:forEach items="${ComentariosSinRespuesta}" var="r">
                                            <tr class="text-center">
                                                <td>${ r.getValoracion() }</td>
                                                <td>${ r.getDescripcion()}</td>
                                             
                                                <td>${ r.getComercio() }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                </div>
                              </div>
                            </div>

                            <div class="card">
                              <div class="card-header" id="headingTwo">
                                <h2 class="mb-0">
                                  <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    Promedio de Valoracion por comercio
                                  </button>
                                </h2>
                              </div>
                              <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                <div class="card-body">                          
                                  <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr class="text-center">
                                            <th>Comercio</th>
                                            <th>Valoracion</th>
                                        </tr>
                                    </thead>            
                                    <tbody>
                                        <c:forEach items="${ValoracionxComercio}" var="r">
                                            <tr class="text-center">
                                                <td>${ r.getComercio() }</td>
                                                <td>${ r.getPromedio() }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                </div>
                              </div>
                            </div>

                            <div class="card">
                              <div class="card-header" id="headingThree">
                                <h2 class="mb-0">
                                  <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    Comercios por cantidad de comentarios
                                  </button>
                                </h2>
                              </div>
                              <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                <div class="card-body">
                                  <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr class="text-center">
                                            <th>Comercio</th>
                                            <th>Cantidad de comentarios</th>
                                        </tr>
                                    </thead>            
                                    <tbody>
                                        <c:forEach items="${ComerciosxCantComentarios}" var="r">
                                            <tr class="text-center">
                                                <td>${ r.getComercio() }</td>
                                                <td>${ r.getCant_Comentarios() }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </div>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
