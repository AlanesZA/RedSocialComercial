<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="GestorBD" class="Controlador.GestorBD" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Comentarios</title>
         <jsp:include page="includes.jsp"></jsp:include>
        
        <style>
            /*#form {
                width: 400px;
                margin: 0 auto;
                height: 80px;
            }*/
            #form p {
                text-align: center;
            }
            /*#form label {
                font-size: 50px;
            }*/
            input[type="radio"] {
                display: none;
            }            
            label {
                color: darkgray;
            }
            .clasificacion {
                direction: rtl;
                unicode-bidi: bidi-override;
            }
            label:hover,
              label:hover ~ label {
                color: dodgerblue;
            }            
            input[type="radio"]:checked ~ label {
                color: dodgerblue;
            }
        </style>
        
    </head>
    <body>
         <jsp:include page="header.jsp"></jsp:include>
        
        <div class="col col-lg-5">
            <h1>Registrar Comentario</h1>
        </div>
        
        <div class="row justify-content col-md-8">
            <%@include file="infoError.jsp" %>
        </div>
        
        <form action="listaComentario" method="post">
            <div class="row justify-content col-lg-11">
                <div class="row justify-content.">
                    <div class="col-lg-11">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">Titulo</span>
                            </div>
                            <input type="text" class="form-control" name="txtTitulo" placeholder="Titulo">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Comentario</span>
                            </div>
                            <textarea class="form-control" name="txtComentario" placeholder="Comentario"></textarea>
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Valoración</span>
                            </div>
                                <p class="clasificacion">
                                    <input id="radio1" type="radio" name="estrellas" value="1">
                                    <label for="radio1">&#9733;</label>
                                    <input id="radio2" type="radio" name="estrellas" value="2">
                                    <label for="radio2">&#9733;</label>
                                    <input id="radio3" type="radio" name="estrellas" value="3">
                                    <label for="radio3">&#9733;</label>
                                    <input id="radio4" type="radio" name="estrellas" value="4">
                                    <label for="radio4">&#9733;</label>
                                    <input id="radio5" type="radio" name="estrellas" value="5">
                                    <label for="radio5">&#9733;</label>
                                </p>
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Comercio</span>
                            </div>
                            <select name="cboComercio">                  
                                <c:forEach items="${listaComercios}" var="lc">
                                    <option value="${ lc.getId_Comercio() }"> ${ lc.getComercio() } </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>                    
                    <div class="col col-lg-8">
                        <div class="input-group justify-content-end">                           
                            <button class="btn btn-secondary" type="submit">Registrar Comentario</button>
                        </div>
                    </div>    
                </div>                
            </div>
        </form>
        
         <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
