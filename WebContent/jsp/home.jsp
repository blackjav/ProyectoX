<%@page import="com.liverpool.modelo.CentroDistribucion"%>
<%@page import="com.liverpool.cebt.utils.Constantes"%>
<%@page import="com.liverpool.modelo.Usuario"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<%
    HashMap<String,String> perms = null;
    Usuario user =new Usuario();

    try
    {
        
        if(request.getSession(false)!=null)
        {
            perms= (HashMap<String, String>) request.getSession(false).getAttribute(Constantes.CEBT_USER_PERMISOS_SESSION);
            
            if(request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION)!=null){
                user = (Usuario) request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION);
            }
        }       
        else
        {
        	System.out.print("ERROR");
        }
    }catch(Exception e)
    {
        System.out.println("Ocurrió un error al procesar seleccionCD.jsp. Error: " + e.getMessage());
    }
    if (perms == null) 
    {
        perms = new HashMap<String, String>();
        System.out.print("ERROR de permisos");
    }
    
    
     
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
<!-- 	jquey -->
	<script src="../scripts/jquery-3.3.7.min.js"></script>
	
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
	<link rel="stylesheet" href="../css/liverpool.css">
	
	<title>Liverpool-CEBT</title>

</head>
<body>
	<header>
		<s:include value="/jsp/menuHeader.jsp"></s:include>
	</header>

	<div id="loading" style="display:none">
		  	<img src="../imagenes/load.svg">
	</div>
	<div class="container">
		<section class="main row">
			<h1>CEBT-Smart v2.0 - Proximamente....</h1>
		</section>
		
		
	</div>
</body>
</html>