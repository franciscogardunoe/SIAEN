<%-- 
    Document   : encuesta
    Created on : 19/02/2018, 08:43:58 AM
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Creación de Encuesta</h1>
        <form name="nombre" action="<%=context%>/registrarEncuesta" method="post">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" name="unaEncuesta.nombre" id="nombre" placeholder="Nombre" required="">
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción</label>
                <input type="text" class="form-control" name="unEncuesta.descripcion" id="descripcion" placeholder="Descrioción">
            </div>          
            <div class="text-center">
                <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Registrar</button>
            </div>
        </form>
    </body>
</html>
