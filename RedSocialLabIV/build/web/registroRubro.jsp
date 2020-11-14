<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="jdbcConn" class="Controlador.GestorBD" scope="session"/>
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
                        <div class="form form-horizontal jumbotron col-md-6 col-md-push-3" >
                            <h3>Registrar nuevo Rubro:</h3>
                            <br/>
                            <form action="AltaRubro" method="post">


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Rubro:</label>
                                    <input type="text" name="txtRubro" class="form-control" placeholder="Ingrese rubro..."/>
                                </div>

                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Descripción:</label>
                                    <input type="text" id="modelo" class="form-control" name="txtDescripcion" placeholder="Ingrese descripcion.."/>
                                </div>


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group pull-right">
                                    <input type="submit" href="listadoRubros" class="btn btn-primary form-control" value="Guardar rubro"/>
                                </div> 

                                <a href="listadoRubros.jsp" class="btn btn-primary form-control" role="button">Rubros Registrados</a>
                                <br>
                                <br>
   
                                <a href="home.jsp" class="btn btn-primary form-control" role="button">Volver al Menu</a>



                            </form>
                        </div>
                    </div>
                </div>
            </div>   

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
