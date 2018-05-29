<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../scripts/jqueryNotificaciones.css" />
<link rel="stylesheet" href="../css/controles.css">
<link rel="stylesheet" href="../css/liverpool.css">

	<!-- 	BOOTSTRAP -->
<link rel="stylesheet" href="../scripts/bootstrap4.css">
<script src="../scripts/bootstrap4.js"></script>

<script src="../scripts/jqueryNotificaciones.js"></script>
<script src="../scripts/jquery-3.3.7.min.js"></script>
<script src="../js/login.js"></script>
<script src="../js/controles.js"></script>

<title>Liverpool-CEBT</title>

</head>

   <body class="text-center">
   
	 <div id="notificationError"></div>
  		
	 <div id="loading" style="display:none">
 	 	<img src="../imagenes/load.svg">
  	</div>
   		

	 <div class="form-signin">
	
      <img class="mb-4" src="../imagenes/liverpool1.png" alt="" width="auto" height="auto">
      <h1 class="h3 mb-3 font-weight-normal">Ingresar</h1>
      
      <label for="inputEmail" class="sr-only">Usuario</label>
      <input type="text" id="usuario" placeholder="user123" class="form-control" required autofocus>
      
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password"id="pass" placeholder="Contraseña" class="form-control" required>
      
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Recuerdame.
        </label>
      </div>
      
      <button class="btn btn-lg btn-liverpool btn-block" onclick="inicar(this);">Entrar</button>

      <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
      
    </div>
  </body>
</html>