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
                window.location.replace("<%=context%>/miCuenta");
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
                                <p class="login-box-msg"><strong><s:property value="mensaje"/></strong></p>
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