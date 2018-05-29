<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" type="image/png" href="css/images/favico.png" />
	<title>Ocurri&oacute; un error...</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="../css/login.css">
	<link rel="stylesheet" href="../css/controles.css">
	<link rel="stylesheet" href="../scripts/jqueryNotificaciones.css" />
	<script src="../scripts/jqueryNotificaciones.js"></script>
	<script src="../scripts/jquery-3.2.1.min.js"></script>
	<script src="../js/login.js"></script>
	<script src="../js/controles.js"></script>
	
</head>
<body>	
	<div class="w3-container">
		<div style="border: none; position: relative; left: 0px; top: 0px; width: 100%; height: 100%;  display: block;">
			<div class="content" id="content">
				<br>
				<div style="width: 500px;margin-left: auto;margin-right: auto;padding:3px;color:#000000;" class="ui-state-default ui-corner-all ui-state-active"> 
					<span class="ui-icon ui-icon-alert" style="display: inline-block;margin-top:5px;"></span>
					<h3 style="display: inline-block;margin-top: 0px;">&nbsp;&nbsp;&nbsp;OCURRIÓ UN PROBLEMA</h3>
					<br>
					<s:if test="actionError!=null">
						<span style="font-size:14px;"><s:property value="actionError"/></span>
					</s:if><s:else>
						<span style="font-size:14px;">Tu sesión ha expirado y ya no es válida, por favor inicia sesión nuevamente.</span>
					</s:else>
					<hr>
					<div>Lamentamos la posibilidad de perdida de información, le sugerimos validar el estado final de sus operaciones. Si el problema persiste, por favor comuníquese con los administradores del CEBT.</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>
