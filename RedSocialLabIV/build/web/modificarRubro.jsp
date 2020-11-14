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
            <h1>Modificar Rubro</h1>

            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <div class="form form-horizontal jumbotron col-md-6 col-md-push-3" >
                            <h3>Modificar datos de ${rubroupdate.rubro}</h3>
                        <br/>

                        <form action="ModificarRubro" method="post">
                            <input type="hidden" name="txtIdRubro" value="<jsp:getProperty name="rubroupdate" property="id"></jsp:getProperty>"/>

                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Rubro: </label>
                                        <input class="form-control" type="text" name="txtRubro" value="<jsp:getProperty name="rubroupdate" property="rubro"></jsp:getProperty>"/>
                                </div>

                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Descripción: </label>
                                        <input class="form-control" type="text" name="txtDescripcion" value="<jsp:getProperty name="rubroupdate" property="descripcion"></jsp:getProperty>"/>
                                </div>

                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Estado: </label>  
                                        <input class="form-control" type="number" name="txtEstado" value="<jsp:getProperty name="rubroupdate" property="estado"></jsp:getProperty>"/>
                                </div>

                                <div class="form-group col-md-12">
                                </div>
 
                                <div class="form-group col-md-7">

                                    <button  href="listadoRubros"  class="btn btn-success" type="submit">
                                        Registrar cambios
                                    </button>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>



    </div>
</div>
</div>
</div>   

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
