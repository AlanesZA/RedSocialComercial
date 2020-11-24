<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GDB" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Respuesta</title>

        <jsp:include page="includes.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <div class="form form-horizontal jumbotron col-md-6 col-md-push-3" >
                            <h3>Agregar Respuesta</h3>
                            <br/>
                            <form action="Respuestas" method="post">
                                <input type="hidden" value="${idComercio}" name="idComercio">
                                <input type="hidden" value="${idComentario}" name="idComentario">
                                
                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group col-md-7">
                                    <label>Respuesta al comentario</label>
                                    <input type="text" name="respuesta" class="form-control" placeholder="Ingrese respuesta..."/>
                                </div>                               


                                <div class="form-group col-md-12">
                                </div>
                                <div class="form-group justify-content-end">
                                    <input type="submit" class="btn btn-primary form-control" value="Guardar Respuesta"/>
                                    <br>                                    
                                    <br>
                                    <a href="home.jsp" class="btn btn-primary form-control" role="button">Volver al Menu</a>
                                </div> 

                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>   

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
