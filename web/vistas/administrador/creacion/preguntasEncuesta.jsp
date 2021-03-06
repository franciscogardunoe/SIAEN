<%-- 
    Document   : empty
    Created on : 19-feb-2018, 23:58:52
    Author     : penlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html lang="es" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="viewport" charset="utf-8" content="width=device-width, initial-scale=1.0" />
        <title>Encuesta | Detalle</title>
        <!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FontAwesome Styles-->
        <link href="<%=context%>/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
        <link href="<%=context%>/assets/css/custom-styles.css" rel="stylesheet" />
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!--Libreria de JQuery-->
        <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

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
            <s:if test="#session.logged != 'yes'">
                <script>
                    window.location.replace("<%=context%>/index.jsp");
                </script>
            </s:if>
    </head>
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
                            Encuesta <small> Detalle</small>
                        </h1>
                    </div>
                </div> 


                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="row">
                                <div class="col-md-12">
                                    <br>
                                        <div class="col-md-6">    
                                            <!-- Advanced Tables -->
                                            <div class="panel panel-primary">
                                                <div class="panel-heading">
                                                    Detalles Encuesta
                                                </div>
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <label>Nombre:</label> <s:property value="unaEncuesta.nombre"/><br></br>
                                                        <label>Descripción:</label> <s:property value="unaEncuesta.descripcion"/><br></br>
                                                        <label>Fecha Creación:</label> <s:property value="unaEncuesta.fechaCreacion"/><br></br>
                                                        <button class="btn btn-warning btn pull-right" data-toggle="modal" data-target="#editarEncuesta">
                                                            <i class="fa fa-pencil"></i>&nbsp; Modificar
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="panel panel-primary">
                                                <div class="panel-heading">
                                                    Código Encuesta
                                                </div>
                                                <div class="panel-body">
                                                    <div class="table-responsive">
                                                        <h3><b><s:property value="unaEncuesta.codigo"/></b></h3>
                                                        <br>
                                                            <div class="alert alert-info">
                                                                <strong>¡Aviso!</strong> Proporcione este código a los usuarios para responder la encuesta que ha creado.
                                                            </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-primary">
                                                <div class="panel-heading">
                                                    Informes
                                                </div>
                                                <div class="panel-body">
                                                    Numero de personas que han contestado la encuesta
                                                    <div class="table-responsive">
                                                        <strong><h2><s:property value="totalAplicadas"/></h2></strong>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">    
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Preguntas
                            </div>
                            <div class="panel-body">
                                <button type="button" class="btn btn-primary btn pull-right" data-toggle="modal" data-target="#exampleModal">
                                    <i class="fa fa-plus"></i>&nbsp;Nueva Pregunta
                                </button><br></br><br>
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
                                                            <td>¿<s:property value="pregunta"/>?</td>
                                                            <td>
                                                                <s:set name="obli" value="obligatoria"/>
                                                                <s:if test="%{#obli==1}">
                                                                    <i class="glyphicon glyphicon-ok"></i>
                                                                </s:if>
                                                                <s:else>
                                                                    <i class="glyphicon glyphicon-remove"></i>
                                                                </s:else> 
                                                            </td>
                                                            <td><s:property value="tipo.tipo"/></td>
                                                            <div class="container">
                                                                <s:set name="tipos" value="tipo.tipo"/>
                                                                <s:if test="%{#tipos!='Abierta'}">
                                                                    <form role="form" name="consultar" action="<%=context%>/generarGraficaPregunta" method="POST">
                                                                        <input id="idPregunta" name="unaPregunta.idPregunta" value="<s:property value="idPregunta"/>" hidden=""/>
                                                                        <input id="codigo" name="codigo" value="<s:property value="codigo"/>" hidden=""/>
                                                                        <td><button type="submit" class="btn btn-info" title="Ver informes"><i class="fa fa-signal"></i></button></td>
                                                                    </form>
                                                                </s:if>
                                                                <s:else>
                                                                    <form role="form" name="consultar" action="<%=context%>/generarGraficaPregunta" method="POST">
                                                                        <input id="idPregunta" name="unaPregunta.idPregunta" value="<s:property value="idPregunta"/>" hidden=""/>
                                                                        <input id="codigo" name="codigo" value="<s:property value="codigo"/>" hidden=""/>
                                                                        <td><button type="submit" class="btn btn-info" title="Ver informes" disabled="true"><i class="fa fa-signal"></i></button></td>
                                                                    </form>
                                                                </s:else> 
                                                                <form role="form" name="consultar" action="<%=context%>/consultarPregunta" method="POST">
                                                                    <input id="idPregunta" name="unaPregunta.idPregunta" value="<s:property value="idPregunta"/>" hidden=""/>
                                                                    <input id="codigo" name="codigo" value="<s:property value="codigo"/>" hidden=""/>
                                                                    <td><button type="submit" class="btn btn-primary" title="Ver detalles"><i class="fa fa-eye"></i></button></td>
                                                                </form>
                                                                <form role="form" id="eliminar" name="eliminar" action="<%=context%>/eliminarPregunta" method="POST">
                                                                    <input id="idPregunta" name="unaPregunta.idPregunta" value="<s:property value="idPregunta"/>" hidden=""/>
                                                                    <input type="text" id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="unaEncuesta.idEncuesta"/>" hidden="">
                                                                        <input type="text" id="codigo" name="codigo" value="<s:property value="unaEncuesta.codigo"/>" hidden="">
                                                                            <td><button type="submit" class="btn btn-danger" title="Eliminar Pregunta"><i class="fa fa-times"></i></button></td>
                                                                            </form>
                                                                            </div> 
                                                                            </tr>
                                                                        </s:iterator> 
                                                                        </tbody>
                                                                        </table>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <div class="alert alert-warning">
                                                                            <strong>¡Advertencia!</strong> Aún no hay preguntas registradas.
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
                                                                                    <h5 class="modal-title" id="exampleModalLabel">NUEVA PREGUNTA</h5>
                                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                        <span aria-hidden="true">&times;</span>
                                                                                    </button>
                                                                                </div>

                                                                                <div class="col-md-12">
                                                                                    <br></br>
                                                                                    <div class="alert alert-info">
                                                                                        <strong>¡Aviso!</strong> Seleccione el tipo de pregunta que desea registrar.
                                                                                    </div>
                                                                                    <!-- Nav tabs -->
                                                                                    <ul class="nav nav-tabs" role="tablist">
                                                                                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Abierta</a></li>
                                                                                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Opción múltiple</a></li>
                                                                                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Selección múltiple</a></li>
                                                                                    </ul>

                                                                                    <!-- Tab panes -->
                                                                                    <div class="tab-content">
                                                                                        <div role="tabpanel" class="tab-pane active" id="home">
                                                                                            <form role="form" name="registrar" action="<%=context%>/registrarPreguntaAbierta" method="post">
                                                                                                <div class="modal-body">
                                                                                                    <input type="text" id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="unaEncuesta.idEncuesta"/>" hidden="">
                                                                                                        <input type="text" id="codigo" name="codigo" value="<s:property value="unaEncuesta.codigo"/>" hidden="">
                                                                                                            <div class="form-group">
                                                                                                                <label>Pregunta</label>
                                                                                                                <textarea type=text" class="form-control" rows="3" name="unaPregunta.pregunta" id="pregunta" placeholder="Pregunta" max="150" required=""></textarea>
                                                                                                            </div> 
                                                                                                            <div class="form-group">
                                                                                                                <label>Pregunta obligatoria</label>
                                                                                                                <br></br>
                                                                                                                <label class="radio-inline">
                                                                                                                    <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="1"> Si
                                                                                                                </label>
                                                                                                                <label class="radio-inline">
                                                                                                                    <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="0"> No
                                                                                                                </label>        
                                                                                                            </div>
                                                                                                            </div>
                                                                                                            <center><button type="submit" class="btn btn-primary">Aceptar</button></center>
                                                                                                            </form>
                                                                                                            </div>




                                                                                                            <div role="tabpanel" class="tab-pane" id="profile">
                                                                                                                <form role="form" name="registrar" action="<%=context%>/registrarPreguntaOpcion" method="post">
                                                                                                                    <div class="modal-body">
                                                                                                                        <input type="text" id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="unaEncuesta.idEncuesta"/>" hidden="">
                                                                                                                            <input type="text" id="codigo" name="codigo" value="<s:property value="unaEncuesta.codigo"/>" hidden="">
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Pregunta</label>
                                                                                                                                    <textarea type=text" class="form-control" rows="3" name="unaPregunta.pregunta" id="pregunta" placeholder="Pregunta" max="150" required=""></textarea>
                                                                                                                                </div> 

                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Opción 1</label>
                                                                                                                                    <input type=text" class="form-control" rows="3" name="opcion1" id="opcion1" placeholder="Opción 1" max="100"/>
                                                                                                                                </div> 
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Opción 2</label>
                                                                                                                                    <input type=text" class="form-control" rows="3" name="opcion2" id="opcion2" placeholder="Opción 2" max="100"/>
                                                                                                                                </div> 
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Opción 3</label>
                                                                                                                                    <input type=text" class="form-control" rows="3" name="opcion3" id="opcion3" placeholder="Opción 3" max="100"/>
                                                                                                                                </div> 
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Opción 4</label>
                                                                                                                                    <input type=text" class="form-control" rows="3" name="opcion4" id="opcion4" placeholder="Opción 4" max="100"/>
                                                                                                                                </div> 
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Opción 5</label>
                                                                                                                                    <input type=text" class="form-control" rows="3" name="opcion5" id="opcion5" placeholder="Opción 5" max="100"/>
                                                                                                                                </div> 
                                                                                                                                <div class="form-group">
                                                                                                                                    <label>Pregunta obligatoria</label>
                                                                                                                                    <br></br>
                                                                                                                                    <label class="radio-inline">
                                                                                                                                        <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="1"> Si
                                                                                                                                    </label>
                                                                                                                                    <label class="radio-inline">
                                                                                                                                        <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="0"> No
                                                                                                                                    </label>        
                                                                                                                                </div>
                                                                                                                                </div>
                                                                                                                                <center><button type="submit" class="btn btn-primary">Aceptar</button></center>
                                                                                                                                </form>
                                                                                                                                </div>




                                                                                                                                <div role="tabpanel" class="tab-pane" id="messages">
                                                                                                                                    <form role="form" name="registrar" action="<%=context%>/registrarPreguntaMultiple" method="post">
                                                                                                                                        <div class="modal-body">
                                                                                                                                            <input type="text" id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="unaEncuesta.idEncuesta"/>" hidden="">
                                                                                                                                                <input type="text" id="codigo" name="codigo" value="<s:property value="unaEncuesta.codigo"/>" hidden="">
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Pregunta</label>
                                                                                                                                                        <textarea type=text" class="form-control" rows="3" name="unaPregunta.pregunta" id="pregunta" placeholder="Pregunta" max="150" required=""></textarea>
                                                                                                                                                    </div> 

                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Opción 1</label>
                                                                                                                                                        <input type=text" class="form-control" rows="3" name="opcion1" id="opcion1" placeholder="Opción 1" max="100"/>
                                                                                                                                                    </div> 
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Opción 2</label>
                                                                                                                                                        <input type=text" class="form-control" rows="3" name="opcion2" id="opcion2" placeholder="Opción 2" max="100"/>
                                                                                                                                                    </div> 
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Opción 3</label>
                                                                                                                                                        <input type=text" class="form-control" rows="3" name="opcion3" id="opcion3" placeholder="Opción 3" max="100"/>
                                                                                                                                                    </div> 
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Opción 4</label>
                                                                                                                                                        <input type=text" class="form-control" rows="3" name="opcion4" id="opcion4" placeholder="Opción 4" max="100"/>
                                                                                                                                                    </div> 
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Opción 5</label>
                                                                                                                                                        <input type=text" class="form-control" rows="3" name="opcion5" id="opcion5" placeholder="Opción 5" max="100"/>
                                                                                                                                                    </div> 
                                                                                                                                                    <div class="form-group">
                                                                                                                                                        <label>Pregunta obligatoria</label>
                                                                                                                                                        <br></br>
                                                                                                                                                        <label class="radio-inline">
                                                                                                                                                            <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="1"> Si
                                                                                                                                                        </label>
                                                                                                                                                        <label class="radio-inline">
                                                                                                                                                            <input type="radio" name="unaPregunta.obligatoria" id="obligatoria" value="0"> No
                                                                                                                                                        </label>        
                                                                                                                                                    </div>
                                                                                                                                                    </div>
                                                                                                                                                    <center><button type="submit" class="btn btn-primary">Aceptar</button></center>
                                                                                                                                                    </form>
                                                                                                                                                    </div>

                                                                                                                                                    </div>
                                                                                                                                                    </div>
                                                                                                                                                    <div class="modal-footer">
                                                                                                                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                                                                                                                    </div>

                                                                                                                                                    </div>
                                                                                                                                                    </div>
                                                                                                                                                    </div>

                                                                                                                                                    <!-- Modal -->
                                                                                                                                                    <div class="modal fade" id="editarEncuesta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                                                                                                        <div class="modal-dialog" role="document">
                                                                                                                                                            <div class="modal-content">
                                                                                                                                                                <div class="modal-header">
                                                                                                                                                                    <h5 class="modal-title" id="exampleModalLabel">MODIFICAR ENCUESTA</h5>
                                                                                                                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                                                                                                        <span aria-hidden="true">&times;</span>
                                                                                                                                                                    </button>
                                                                                                                                                                </div>
                                                                                                                                                                <form role="form" name="registrar" action="<%=context%>/modificarEncuesta" method="post">
                                                                                                                                                                    <div class="modal-body">
                                                                                                                                                                        <input type="text" id="idEncuesta" name="unaEncuesta.idEncuesta" value="<s:property value="unaEncuesta.idEncuesta"/>" hidden="">
                                                                                                                                                                            <input type="text" id="codigo" name="codigo" value="<s:property value="unaEncuesta.codigo"/>" hidden="">
                                                                                                                                                                                <div class="form-group">
                                                                                                                                                                                    <label>Nombre Encuesta</label>
                                                                                                                                                                                    <input type="text" class="form-control" name="unaEncuesta.nombre" id="nombre" placeholder="Nombre" required="" min="2" max="45" value="<s:property value="unaEncuesta.nombre"/>">                                       
                                                                                                                                                                                </div>
                                                                                                                                                                                <div class="form-group">
                                                                                                                                                                                    <label>Descripción</label>
                                                                                                                                                                                    <input type="text" class="form-control" rows="3" name="unaEncuesta.descripcion" id="descripcion" placeholder="Descripción" max="150" value="<s:property value="unaEncuesta.descripcion"/>"></textarea>
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
                                                                                                                                                                                </body>
                                                                                                                                                                                </html>


