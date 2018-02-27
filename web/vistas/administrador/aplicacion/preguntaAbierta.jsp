<%-- 
    Document   : empty
    Created on : 19-feb-2018, 23:58:52
    Author     : penlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Pregunta | Contestar</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>

        <!-- Librerias de SweetAlert-->
        <script src="<%=context%>/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=context%>/sweetalert-master/dist/sweetalert.css">
            <!--Terminan librerías de SweerAlert-->
            <script>
                $(document).ready(function ()
                {
                <s:set name="a" value="accion"/>
                <s:if test="%{#a != '' }">
                    swal("¡<s:property value="accion"/>!", "<s:property value="mensaje"/>", "<s:property value="tipoMensaje"/>");
                });
                </s:if>
            </script>
    </head>
    <body>

        <!-- Aquí comienza el inicio empty-->   
        <div id="wrapper">
            <nav class="navbar navbar-default top-navbar" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=context%>/vistaPrincipal"  >SIAEN</a>
                </div>

                <ul class="nav navbar-top-links navbar-right">
                    <li class="name">¡Hola <s:property value="#session.name"/>!</li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li class="divider"></li>
                            <li><a href="<%=context%>/cerrarSesion"><i class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
            </nav>
            <!--/. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu"> 
                        <li>
                            <a class="active-menu" href="<%=context%>/vistaPrincipal"><i class="fa fa-fw fa-file"></i> Inicio</a>
                        </li>
                        <li>
                            <a href="<%=context%>/consultarEncuestas"><i class="fa fa-dashboard"></i>Encuestas creadas</a>
                        </li>
                        <li>
                            <a href="<%=context%>/cargarPreguntasUsuario"><i class="fa fa-desktop"></i>Encuestas contestadas</a>
                        </li>
                    </ul>

                </div>

            </nav>          
            <!-- Aquí termina el inicio empty-->        
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-header">
                                Pregunta <small> Contestar</small>
                            </h1>
                            <div class="row">                 
                                <div class="col-md-12">    
                                    <!-- Advanced Tables -->
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            Mis Encuestas
                                        </div>
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <s:set name="tip" value="unaPregunta.tipo.idTipo"/>
                                                <s:if test="%{#tip==3}">
                                                    <s:property value="unaPregunta.pregunta"/>
                                                    <form role="form" name="consultar" action="<%=context%>/registrarRespuestaAbierta" method="POST">
                                                        <input id="idAplica" name="unaAplica.idAplica" value="<s:property value="idAplica"/>" hidden=""/>
                                                        <input id="idAplica" name="unaPregunta.idPregunta" value="<s:property value="unaPregunta.idPregunta"/>" hidden=""/>
                                                        <div class="form-group">
                                                            <label>Descripción</label>
                                                            <textarea type=text" class="form-control" rows="3" name="unaPregunta.pregunta" id="descripcion" placeholder="Descripción" max="150"></textarea>
                                                        </div> 
                                                        <button type="submit" class="btn btn-primary">Registrar</button>
                                                    </form>
                                                </s:if>
                                                <s:if test="%{#tip==1}">
                                                    <form role="form" name="consultar" action="<%=context%>/registrarRespuestaOpcion" method="POST">
                                                        <input id="idAplica" name="unaAplica.idAplica" value="<s:property value="idAplica"/>" hidden=""/>
                                                        <input id="idAplica" name="unaPregunta.idPregunta" value="<s:property value="unaPregunta.idPregunta"/>" hidden=""/>
                                                        <s:property value="unaPregunta.pregunta"/><br></br>
                                                        <s:iterator value="misOpciones" status="stet"> 
                                                            <input type="radio" name="opcion" value="<s:property value="idOpcion"/>"> <s:property value="opcion"/><br></br>
                                                            </s:iterator>
                                                            <button type="submit" class="btn btn-primary">Registrar</button>
                                                    </form>
                                                </s:if>
                                                <s:if test="%{#tip==2}">
                                                    <form role="form" name="consultar" action="<%=context%>/registrarRespuestaOpcion" method="POST">
                                                        <input id="idAplica" name="unaAplica.idAplica" value="<s:property value="aplica.idAplica"/>" hidden=""/>
                                                        <input id="idAplica" name="unaPregunta.idPregunta" value="<s:property value="unaPregunta.idPregunta"/>" hidden=""/>
                                                        <s:property value="unaPregunta.pregunta"/><br></br>
                                                        <s:iterator value="misOpciones" status="stet"> 
                                                            <input type="radio" name="opcion" value="<s:property value="idOpcion"/>" checked> Male<br></br>
                                                            </s:iterator>                                                       
                                                            <button type="submit" class="btn btn-primary">Registrar</button>
                                                    </form>
                                                </s:if>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Advanced Tables -->
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- /. ROW  -->
                    <footer><p>All right reserved. Template by: <a href="http://webthemez.com">WebThemez</a></p></footer>
                </div>
                <!-- /. PAGE INNER  -->
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <!-- JS Scripts-->
        <!-- jQuery Js -->
        <script src="<%=context%>/assets/js/jquery-1.10.2.js"></script>
        <!-- Bootstrap Js -->
        <script src="<%=context%>/assets/js/bootstrap.min.js"></script>
        <!-- Metis Menu Js -->
        <script src="<%=context%>/assets/js/jquery.metisMenu.js"></script>
        <!-- Custom Js -->
        <script src="<%=context%>/assets/js/custom-scripts.js"></script>
    </body>
</html>



