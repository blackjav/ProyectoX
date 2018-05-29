<%@page import="com.liverpool.modelo.CentroDistribucion"%>
<%@page import="com.liverpool.cebt.utils.Constantes"%>
<%@page import="com.liverpool.modelo.Usuario"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
<head>
<!-- 	jquey -->
		<script src="../scripts/jquery-3.3.7.min.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		
<!-- 	NOTIFICACIONES  -->
		<link rel="stylesheet" href="../scripts/jqueryNotificaciones.css" />
		<script src="../scripts/jqueryNotificaciones.js"></script>
<!-- 	BOOTSTRAP -->
		<link rel="stylesheet" href="../scripts/bootstrap4.css">
		<script src="../scripts/bootstrap4.js"></script>
<!-- 	AUXILIARES  -->
		<link rel="stylesheet" href="../css/controles.css">
		<script src="../js/menuHeader.js"></script>
		<script src="../js/controles.js"></script>
		<script src="../js/seleccionCD.js"></script>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
		
		<link rel="stylesheet" href="../css/liverpool.css">
		<title>VIEW</title>
</head>

<body>
	<div style="border: none; left: 0px; top: 0px; width: 100%; display: inline-block;">
	 	<s:include value="/jsp/basicMenuHeader.jsp"></s:include>
	 	<div class="container-fluid">
	 		<div class="row">
		        <div class='col-sm-6'>
		            <div class="form-group">
		                <div class='input-group date' id='datetimepicker1'>
		                   <p> Date: <input type="text" id="datepicker"></p>
		                </div>
		            </div>
		        </div>
		        <script type="text/javascript">
		        $( function() {
		            $( "#datepicker" ).datepicker();
		          } );
		        </script>
		    </div>
	 		
	 		<div class="row">
	 			<canvas id="myChart"  style="height:4vh; width:6vw">></canvas>
	 		</div>
	 	</div>
	 	
<script>

</script>
	</div>
	
	

</body>
</html>