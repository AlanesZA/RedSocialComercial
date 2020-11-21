
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Comercios</title>
        <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" href="libs/jquery-ui-1.11.2/jquery-ui.css"/>
        <link rel="stylesheet" href="css/style.css"/>   

        <script src="libs/jquery-1.11.1.js"></script>
        <script src="libs/jquery-ui-1.11.2/jquery-ui.js"></script>
        <script src="libs/bootstrap/js/bootstrap.js"></script>
        <script src="js/scripts.js"></script>
         
        
    </head>
    <body style="background-color: #1c1e21; ">

            <div class="nav navbar-fixed-top navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="homeUsuario.jsp">Comercios</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">

                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </div>
            <div class="container">
                <div class="row">
                    <div class="col col-md-12">
                        <div id="contentLogin" class="form jumbotron col-md-6 col-md-push-3" >
                            <h1>¡Bienvenido!</h1>
                            <br/>
                            <form name="loginForm" role="form" action="loginCtrl">
                                <div class="form-group">
                                    <label>Usuario:</label>
                                    <input type="text" id="userName" name="txtUsuario" class="form-control" placeholder="Ingrese nombre de  usuario.."/>
                                </div>
                                <div class="form-group">
                                    <label>Contraseña:</label>
                                    <input type="password" id="password" name="txtPassword" class="form-control" placeholder="Ingrese su contraseña.."/>
                                </div>
                                <div class="form-group">
                                    <input type="submit" id="submit" class="btn btn-primary form-control" value="Entrar"/>
                                </div>   

                            </form>
                        </div>
                    </div>
                </div>
            </div>   
            <div class="nav navbar-fixed-bottom navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand">2do Examen Parcial de Laboratorio de Computación IV - <b>2020</b></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse pull-right">
                        <ul class="nav navbar-nav">
                            <li>
                                <a>Alanes Aguilar , Zenobia - Comisión 2w50 (Leg: 111483)</a>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </div>


</body>
</html>
