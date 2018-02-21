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
        <title>Detalle Encuesta</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                    <a class="navbar-brand" href="index.jsp">Dream</a>
                </div>

                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                            <a href="index.jsp"><i class="fa fa-dashboard"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="ui-elements.jsp"><i class="fa fa-desktop"></i> UI Elements</a>
                        </li>
                        <li>
                            <a href="chart.jsp"><i class="fa fa-bar-chart-o"></i> Charts</a>
                        </li>
                        <li>
                            <a href="tab-panel.jsp"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                        </li>

                        <li>
                            <a href="table.jsp"><i class="fa fa-table"></i> Responsive Tables</a>
                        </li>
                        <li>
                            <a href="form.jsp"><i class="fa fa-edit"></i> Forms </a>
                        </li>


                        <li>
                            <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Link</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Link</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Link</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Link</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Link</a>
                                        </li>

                                    </ul>

                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="active-menu" href="empty.jsp"><i class="fa fa-fw fa-file"></i> Empty Page</a>
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
                                Detalles <small> Encuesta</small>
                            </h1>
                        </div>
                    </div> 
                    <div class="row">
                        <div class="col-md-6">    
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Detalles Encuesta
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <label>Nombre:</label> <s:property value="unaEncuesta.nombre"/><br><br>
                                                <label>Descripción:</label> <s:property value="unaEncuesta.descripcion"/><br><br>
                                                        <label>Fecha Creación:</label> <s:property value="unaEncuesta.fechaCreacion"/><br><br>
                                                                <label>Código:</label> <s:property value="unaEncuesta.codigo"/><br>
                                                                    <button class="btn btn-warning btn pull-right" data-toggle="modal" data-target="#myModal">
                                                                        <i class="fa fa-pencil"></i>&nbsp; Editar
                                                                    </button>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>

                                                                    <div class="col-md-3">
                                                                        <div class="panel panel-default">
                                                                            <div class="panel-heading">
                                                                                Código Encuesta
                                                                            </div>
                                                                            <div class="panel-body">
                                                                                <div class="table-responsive">
                                                                                    <h3><b><s:property value="unaEncuesta.codigo"/></b></h3><br><br>
                                                                                            <div class="alert alert-info">
                                                                                                <strong>¡Aviso!</strong> Proporcione este código a los usuarios para responder a la encuesta que ha creado.
                                                                                            </div>
                                                                                            </div>
                                                                                            </div>
                                                                                            </div>
                                                                                            </div>
                                                                                            <div class="col-md-3">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading">
                                                                                                        Informes
                                                                                                    </div>
                                                                                                    <div class="panel-body">
                                                                                                        <div class="table-responsive">
                                                                                                            <button class="btn btn-info btn" data-toggle="modal" data-target="#myModal">
                                                                                                                <i class="fa fa-signal"></i>&nbsp; Ver Informes
                                                                                                            </button>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>



                                                                                            <div class="col-md-12">    
                                                                                                <!-- Advanced Tables -->
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="col-md-12 row">
                                                                                                        <br>
                                                                                                            <button type="button" class="btn btn-primary btn-lg pull-right" data-toggle="modal" data-target="#exampleModal">
                                                                                                                <i class="fa fa-plus"></i>&nbsp;Nueva Pregunta
                                                                                                            </button><br><br>
                                                                                                                    </div>
                                                                                                                    <div class="panel-heading">
                                                                                                                        Preguntas

                                                                                                                    </div>
                                                                                                                    <div class="panel-body">
                                                                                                                        <div class="table-responsive">
                                                                                                                            <s:set name="numero" value="numeroPreguntas"/>
                                                                                                                            <s:if test="%{#numero>0}">
                                                                                                                                <table class="table">
                                                                                                                                    <thead>
                                                                                                                                        <tr>
                                                                                                                                            <th>#</th>
                                                                                                                                            <th>Pregunta</th>
                                                                                                                                            <th>Obligatoria</th>
                                                                                                                                            <th>Tipo</th>
                                                                                                                                        </tr>
                                                                                                                                    </thead>
                                                                                                                                    <tbody>
                                                                                                                                        <s:iterator value="misPreguntas" status="stet"> 
                                                                                                                                            <tr>
                                                                                                                                                <td><s:property value="%{#stet.count}"/></td>
                                                                                                                                                <td><s:property value="pregunta"/></td>
                                                                                                                                                <td>
                                                                                                                                                    <s:set name="obli" value="obligatoria"/>
                                                                                                                                                    <s:if test="%{#obligatoria==1}">
                                                                                                                                                        Si
                                                                                                                                                    </s:if>
                                                                                                                                                    <s:else>
                                                                                                                                                        No
                                                                                                                                                    </s:else> 
                                                                                                                                                </td>
                                                                                                                                                <td><s:property value="tipo.tipo"/></td>
                                                                                                                                            </tr>
                                                                                                                                        </s:iterator> 
                                                                                                                                    </tbody>
                                                                                                                                </table>
                                                                                                                            </s:if>
                                                                                                                            <s:else>
                                                                                                                                <div class="alert alert-warning">
                                                                                                                                    <strong>¡Advertencia!</strong> Aun no hay preguntas registradas.
                                                                                                                                </div>
                                                                                                                            </s:else> 
                                                                                                                        </div>
                                                                                                                    </div>
                                                                                                                    </div>
                                                                                                                    <!--End Advanced Tables -->
                                                                                                                    </div>
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
                                                                                                                                        <button type="submit" class="btn btn-primary">Aceptar</button>
                                                                                                                                    </div>
                                                                                                                                </form>
                                                                                                                                    
                                                                                                                                    
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


