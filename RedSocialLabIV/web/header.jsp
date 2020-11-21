
<div class="nav navbar-fixed-top navbar-default" style="background-color: #1c1e21;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home.jsp">Menu</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Rubros <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="listadoRubros.jsp">Listado de Rubros</a></li>
                        <li><a href="registroRubro.jsp">Registrar nuevo Rubro</a></li>
                    </ul>
                </li>

                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Comercios <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="listadoComercios.jsp">Listado de Comercios</a></li>
                        <li><a href="registroComercio.jsp">Registrar nuevo Comercio</a></li>
                    </ul>
                </li>

                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ofertas <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="listadoOfertas.jsp">Listado de Ofertas</a></li>
                        <li><a href="registroOferta.jsp">Registrar nueva Oferta</a></li>
                    </ul>
                </li>


                <li class="dropdown"><a href="control?action=sistema" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Sistema <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="actualizarDatosLogueo.jsp">Actualizar datos logueo</a></li>
                        <li><a href="index.jsp">Cerrar Sesion</a></li>
                        <li><a href="index.jsp">Iniciar Sesion</a></li>
                    </ul>
                </li>

                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Reportes <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="Reportes">Reportes</a></li>
                  
                    </ul>
                </li>
                
                 <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Comentarios <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="AdmComentarios.jsp">Comentarios</a></li>
                  
                    </ul>
                </li>




            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</div>
