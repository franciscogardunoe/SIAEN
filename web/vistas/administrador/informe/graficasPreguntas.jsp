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
        <title>Informe | Pregunta</title>
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
                <s:if test="%{#a!= '' }">
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
                                Informe <small> Pregunta</small>
                            </h1>


                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                    </div>
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


        <script lang="es" >
                Highcharts.chart('container', {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: '¿<s:property value="unaPregunta.pregunta"/>?'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: false
                            },
                            showInLegend: true
                        }
                    },
                    series: [{
                            name: 'Porcentaje preferencia',
                            colorByPoint: true,
                            data: [{
                                    name: '<s:property value="opcion1"/>',
                                    y: <s:property value="valor1"/>
                                }, {
                                    name: '<s:property value="opcion2"/>',
                                    y: <s:property value="valor2"/>
                                }, {
                                    name: '<s:property value="opcion3"/>',
                                    y: <s:property value="valor3"/>
                                }, {
                                    name: '<s:property value="opcion4"/>',
                                    y: <s:property value="valor4"/>
                                }, {
                                    name: '<s:property value="opcion5"/>',
                                    y: <s:property value="valor5"/>
                                }]
                        }]
                });
        </script>

        <script>
            function tildes_unicode(str) {
                str = str.replace('á', '\u00e1');
                str = str.replace('é', '\u00e9');
                str = str.replace('í', '\u00ed');
                str = str.replace('ó', '\u00f3');
                str = str.replace('ú', '\u00fa');

                str = str.replace('Á', '\u00c1');
                str = str.replace('É', '\u00c9');
                str = str.replace('Í', '\u00cd');
                str = str.replace('Ó', '\u00d3');
                str = str.replace('Ú', '\u00da');

                str = str.replace('ñ', '\u00f1');
                str = str.replace('Ñ', '\u00d1');
                return str;
            }
        </script>
    </body>
</html>



