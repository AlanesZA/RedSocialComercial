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
                    $("#fechaInicio").datepicker({
                        dateFormat: "dd-mm-yy"
                    });
                    $("#fechaInicio").val(getToday());
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
                            <form action="ListadoComerciosActivos" method="post">
                                <input type="hidden" name="idComercio" value="<jsp:getProperty name="EditComercio" property="idComercio"></jsp:getProperty>" />


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Fecha Inicio: </label>  
                                    <input class="form-control" type="text" name="txtFechaInicio" value="<jsp:getProperty name="EditComercio" property="fechaInicio"></jsp:getProperty>"/>
                                </div>


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Rubro: </label>
                                    <select id="rubro" name="cboRubro" class="form-control">
                                        <option>-- Seleccione --</option>

                                    <c:forEach var="item" items="${GestorBD.obtenerRubro()}">
                                        <option value="${item.getId()}"> ${item}</option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group col-md-12">
                            </div>
                            <div class="form-group col-md-7">
                                <label>Nombre: </label>  
                                <input class="form-control" type="text" name="txtNombre" value="<jsp:getProperty name="EditComercio" property="nombre"></jsp:getProperty>"/>
                                </div>


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group pull-right">
                                    <input type="submit" name="accion" value="Actualizar"> <br>
                                    
                                    <a href="ListadoComerciosActivos?accion=listar">Regresar</a> <br>
                                    
                                    <input href="listadoComerciosActivos"  type="submit" class="btn btn-primary form-control" value="Guardar comercio"/>
                                </div>

                                <a href="home.jsp" class="btn btn-primary form-control" role="button">Volver al Menu</a>

                            </form>
                        </div>
                    </div>
                </div>
            </div>   

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
