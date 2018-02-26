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
        <title>Vista Princiapl</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                            <a href="#"><i class="fa fa-desktop"></i>Encuestas contestadas</a>
                        </li>
                    </ul>

                </div>

            </nav>          
            <!-- Aquí termina el inicio empty-->    


            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    
                    <h2>Bienvenido al sistema de encuestas SIAEN</h2>
                    <p>Registra y comparte todas las encuestas que necesites</p>
                    
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


