<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Celulares - Actualizar Datos</title>
        
        <jsp:include page="includes.jsp"></jsp:include>
        
        <script type="text/javascript">
            $(document).ready(function() {
                $('#msgLogueo').hide();
                $("#pass2").keyup(function(e) {
                    var pass = $("#pass1").val();
                    var re_pass=$("#pass2").val();

                    if(pass != re_pass)
                    {
                        $("#msgLogueo").show(); //El input se pone rojo
                        $("#submitLogueo").attr('disabled','true');
                    }
                    else if(pass == re_pass)
                    {
                        $("#msgLogueo").hide();
                        $("#submitLogueo").removeAttr('disabled');
                    }
                });
            
            });
        </script>
            
        
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="container">
            <div class="row">
                <div class="col col-md-12">
                    <div class="form form-horizontal jumbotron col-md-6 col-md-push-3" >
                        <h3>Cambiar contraseña:</h3>
                        <br/>
                        <form name="loginDataCtrl" role="form" action="loginDataCtrl" >
                            <div class="form-group col-md-7">
                                <label>Contraseña nueva:</label>
                                <input type="password" id="pass1" name="password" class="form-control" />
                            </div>
                            <div class="form-group col-md-12">
                            </div>
                            <div class="form-group col-md-7">
                                <label>Reingrese la nueva contraseña:</label>
                                <input type="password" id="pass2" class="form-control" />
                            </div>
                            <div class="form-group col-md-12">
                            </div>
                            <div id="msgLogueo" class="form-group col-md-12 alert alert-danger ">
                                <label>Las contraseñas no coinciden</label>
                            </div>
                            <div class="form-group col-md-12">
                            </div>
                            <div class="form-group pull-right">
                                <input type="submit" id="submitLogueo" class="btn btn-primary form-control" disabled value="Guardar cambios"/>
                            </div>    
                        </form>
                    </div>
                </div>
            </div>
        </div>   
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
</html>
