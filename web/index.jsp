 <%-- 
    Document   : index
    Created on : 18/02/2018, 04:48:12 PM
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V15</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
<!-- Bootstrap Styles-->
        <link href="<%=context%>/assets/css/bootstrap.css" rel="stylesheet" />
        <!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=context%>/assets/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/animate/animate.css"> 
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=context%>/assets/css/main.css">
<!--===============================================================================================-->
 <!--este codigo hará que si la sesión está iniciada se redireccione al menu sin iniciar
        sesion de nuevo
        -->

        <s:if test="#session.logged == 'yes'">
            <script>
                window.location.replace("<%=context%>/vistas/administrador/creacion/vistaPrincipal.jsp");
            </script>
        </s:if>  

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(<%=context%>/assets/images/bg-01.jpg);">
					<span class="login100-form-title-1">
						Inicio de sesión
					</span>
				</div>
                                <div id="loginAlert" class="alert <s:property value="logType"/>">
                                    <center><s:property value="mensaje"/></center>
                                </div>
				<form name="login" action="loginUsuario" method="post" class="login100-form validate-form" >
					<div class="wrap-input100 validate-input m-b-26" data-validate="Correo es requerido">
						<span class="label-input100">Correo electrónico</span>
						<input class="input100" type="text" name="correo" placeholder="Ingresa tu correo">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Contraseña es requerida">
						<span class="label-input100">Contraseña</span>
						<input class="input100" type="password" name="password" placeholder="Ingresar contraseña">
						<span class="focus-input100"></span>
					</div>
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Iniciar Sesión
						</button>
                                            
					</div>
				</form>     
                                 <a href="#mytoogle" class="singup" data-toggle="modal" data-target="#exampleModal">¡Registrarme!</a>
			</div>
                                
		</div>
	</div>
                                
<!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Registro de usuario</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form role="form" name="registrar" action="<%=context%>/registrarUsuario" method="post">
                                    <div class="modal-body">

                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" class="form-control" name="unUsuario.nombre" id="nombre" placeholder="Nombre" required="" min="2" max="45">                                       
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido 1</label>
                                            <input type="text" class="form-control" name="unUsuario.apellido1" id="apellido1" placeholder="Apellido 1" required="" min="2" max="45">   
                                        </div>      
                                        <div class="form-group">
                                            <label>Apellido 2</label>
                                            <input type="text" class="form-control" name="unUsuario.apellido2" id="apellido2" placeholder="Apellido 2" required="" min="2" max="45">   
                                        </div>  
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input type="email" class="form-control" name="unUsuario.correo" id="correo" placeholder="info@dominio.com" required="" >   
                                        </div> 
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input type="password" class="form-control" name="unUsuario.contrasena" id="correo" required="" min="2" max="15">   
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
	
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=context%>/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="<%=context%>/assets/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="<%=context%>/assets/js/main.js"></script>

</body>
</html>