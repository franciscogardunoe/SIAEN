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
        <title>Encuestas</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        
        <!--Libreria de JQuery-->
        <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

        <!-- Librerias de SweetAlert-->
        <script src="<%=context%>/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=context%>/sweetalert-master/dist/sweetalert.css">
            <!--Terminan librerías de SweerAlert-->
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
                <!--Validación de sesión -->
        <s:if test="#session.logged != 'yes'">
            <script>
                window.location.replace("<%=context%>/index.jsp");
            </script>
        </s:if>
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
                    <a class="navbar-brand" href="<%=context%>/vistaPrincipal">SIAEN</a>
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
                                Encuestas <small></small>
                                <button type="button" class="btn btn-primary btn-lg pull-right" data-toggle="modal" data-target="#exampleModal">
                                    <i class="fa fa-plus"></i>&nbsp;Nueva Encuesta
                                </button>
                            </h1>
                        </div>
                    </div> 
                    <div class="row">                 
                        <div class="col-md-12">    
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Mis Encuestas
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Código</th>
                                                    <th>Nombre Encuesta</th>
                                                    <th>Fecha Creación</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="misEncuestas" status="stet"> 
                                                    <tr>
                                                        <td><s:property value="%{#stet.count}"/></td>
                                                        <td><s:property value="codigo"/></td>
                                                        <td><s:property value="nombre"/></td>
                                                        <td><s:property value="fechaCreacion"/></td>
                                                        <div class="container">                                                          
                                                            <form role="form" name="consultar" action="<%=context%>/consultarEncuesta" method="POST">
                                                                <input id="codigo" name="codigo" value="<s:property value="codigo"/>" hidden=""/>
                                                                <td><button type="submit" class="btn btn-primary" title="Ver detalles"><i class="fa fa-eye"></i></button></td>
                                                            </form>
                                                            <form role="form" id="eliminar" name="eliminar" action="<%=context%>/eliminarEncuesta" method="POST">
                                                                <input id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="idEncuesta"/>" hidden=""/>
                                                                <td><button type="submit" class="btn btn-danger" title="Eliminar Encuesta"><i class="fa fa-times"></i></button></td>
                                                            </form>
                                                        </div> 
                                                    </tr>
                                                </s:iterator> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">NUEVA ENCUESTA</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form role="form" name="registrar" action="<%=context%>/registrarEncuesta" method="post">
                                    <div class="modal-body">

                                        <div class="form-group">
                                            <label>Nombre Encuesta</label>
                                            <input type="text" class="form-control" name="unaEncuesta.nombre" id="nombre" placeholder="Nombre" required="" min="2" max="45">                                       
                                        </div>
                                        <div class="form-group">
                                            <label>Descripción</label>
                                            <textarea type=text" class="form-control" rows="3" name="unaEncuesta.descripcion" id="descripcion" placeholder="Descripción" max="150"></textarea>
                                        </div>          
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                        <button type="submit" class="btn btn-primary">Registrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

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

        <!-- DATA TABLE SCRIPTS -->
        <script src="<%=context%>/assets/js/dataTables/jquery.dataTables.js"></script>
        <script src="<%=context%>/assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
                $(document).ready(function () {
                    $('#dataTables-example').dataTable();
                });
        </script>
    </body>
</html>


