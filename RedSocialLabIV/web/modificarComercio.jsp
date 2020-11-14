<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GestorBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comercio</title>

        <jsp:include page="includes.jsp"></jsp:include>

            <script type="text/javascript">
                $(document).ready(function () {
                    $("#fechainicio").datepicker({
                        dateFormat: "dd-mm-yy"
                    });
                    $("#fechainicio").val(getToday());
                })
            </script>  

        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <div class="form form-horizontal jumbotron col-md-6 col-md-push-3" >
                            <h3>Editar Comercio:</h3>
                            <br/>
                            <form action="EditarComercio?estado=4&id=${comercio.id}" method="post">
                                <input type="hidden" name="id" value="<jsp:getProperty name="comercio" property="id"></jsp:getProperty>" />


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Fecha Inicio: </label>  
                                    <input class="form-control" type="text" name="txtFechaInicio" value="<jsp:getProperty name="comercio" property="fechainicio"></jsp:getProperty>"/>
                                </div>


                                
                                
                                <div class="col-sm-3">
                                    <select name="tipodocumento" class="form-control"/>
                                    <c:forEach var="td" items="${GS.tipoDocumentos}">
                                        <option value=${td.idtipodoc}<c:if test="${td.idtipodoc==socio.tipodocumento}"> selected</c:if>>${td.detalle}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                
                                
                                
                                
                                
                                
                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Rubro: </label>
                                    <select id="rubro" name="cboRubro" class="form-control">
                                        <option>-- Seleccione --</option>

                                    <c:forEach var="item" items="${GestorBD.obtenerRubro()}">
                                         <option value=${item.getId()}<c:if test="${item.id==Rubro.item.nombre}"> selected</c:if>>${td.detalle} </option>
                                        <option value=${item.getId()}<c:if test="${td.idtipodoc==socio.tipodocumento}"> selected</c:if>>${td.detalle} </option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group col-md-12">
                            </div>
                            <div class="form-group col-md-7">
                                <label>Nombre: </label>  
                                <input class="form-control" type="text" name="txtNombre" value="<jsp:getProperty name="comercio" property="nombre"></jsp:getProperty>"/>
                                </div>


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group pull-right">
                                    <input type="submit" value="Actualizar"> <br>
             
                                    
                                    <a href="ListadoComercios">Regresar</a> <br>
                                 
                                </div>

                            </form>
                                
                                 <a href="home.jsp" class="btn btn-primary form-control" role="button">Volver al Menu</a>
                        </div>
                    </div>
                </div>
            </div>   

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
