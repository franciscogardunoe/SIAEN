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
        <title>Free Bootstrap Admin Template : Dream</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- Librerias de SweetAlert-->
        <script src="<%=context%>/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=context%>/sweetalert-master/dist/sweetalert.css">
            <!--Terminan librerías de SweerAlert-->
            <script>
                $(document).ready(function ()
                {
                <s:set name="a" value="accion"/>
                <s:if test="%{#a!= '' }">
                    swal("¡<s:property value="accion"/>!", "<s:property value="mensaje"/>", "<s:property value="tipoMensaje"/>");
                });
                </s:if>
            </script>
    </head>
    <body>
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
                            <a  href="<%=context%>/vistaPrincipal"><i class="fa fa-fw fa-file"></i> Inicio</a>
                        </li>
                        <li>
                            <a class="active-menu" href="<%=context%>/consultarEncuestas"><i class="fa fa-dashboard"></i>Encuestas creadas</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-desktop"></i>Encuestas contestadas</a>
                        </li>
                    </ul>

                </div>

            </nav>
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-header">
                                Pregunta <small>Detalles</small>
                            </h1>
                        </div>
                    </div> 



                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="row">
                                    <div class="col-md-12">
                                        <br>
                                            <div class="col-md-12">    
                                                <!-- Advanced Tables -->
                                                <div class="panel panel-primary">
                                                    <div class="panel-heading">
                                                        Detalles Pregunta
                                                    </div>
                                                    <div class="panel-body">
                                                        <div class="table-responsive">
                                                            <label>Pregunta:</label> ¿<s:property value="unaPregunta.pregunta"/>?<br></br>
                                                            <label>Obligatoria:</label>
                                                            <s:set name="obli" value="obligatoria"/>
                                                            <s:if test="%{#obli==1}">
                                                                Si
                                                            </s:if>
                                                            <s:else>
                                                                No
                                                            </s:else> <br></br>
                                                            <label>Tipo:</label> <s:property value="unaPregunta.tipo.tipo"/><br></br>                                     
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <s:set name="tip" value="unaPregunta.tipo.tipo"/>
                        <s:if test="%{#tip!='Abierta'}">
                            <div class="col-md-12">    
                                <!-- Advanced Tables -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Opciones
                                    </div>
                                    <div class="panel-body">
                                        <s:set name="numero" value="numeroOpciones"/>
                                        <s:if test="%{#numero<=4}">
                                            <button type="button" class="btn btn-primary btn pull-right" data-toggle="modal" data-target="#insertarOpcion">
                                                <i class="fa fa-plus"></i>&nbsp;Nueva Opción
                                            </button><br></br><br>
                                            </s:if>
                                            <div class="table-responsive">


                                                <s:if test="%{#numero>0}">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>Opcion</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <s:iterator value="misOpciones" status="stet"> 
                                                                <tr>
                                                                    <td><s:property value="%{#stet.count}"/></td>
                                                                    <td><s:property value="opcion"/></td>
                                                                </tr>
                                                            </s:iterator> 
                                                        </tbody>
                                                    </table>
                                                </s:if>
                                                <s:else>
                                                    <div class="alert alert-warning">
                                                        <strong>¡Advertencia!</strong> Aún no hay opciones registradas.
                                                    </div>
                                                </s:else> 
                                            </div>
                                    </div>
                                </div>
                                <!--End Advanced Tables -->
                            </div>
                        </s:if>
                        <!-- Modal -->
                        <div class="modal fade" id="insertarOpcion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <form role="form" name="registrar" action="<%=context%>/registrarOpcion" method="post">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">REGISTRAR OPCIÓN</h4>
                                        </div>
                                        <div class="modal-body">
                                            <input type="text" id="idPregunta" name="unaPregunta.idPregunta" value="<s:property value="unaPregunta.idPregunta"/>" hidden="">
                                                <div class="form-group">
                                                    <label>Opción</label>
                                                    <input type=text" class="form-control" rows="3" name="opcion1" id="opcion1" placeholder="Opción" max="150">
                                                </div> 
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                            <button type="submit" class="btn btn-primary">Aceptar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>            
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


