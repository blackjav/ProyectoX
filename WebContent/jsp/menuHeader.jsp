<%@page import="com.liverpool.modelo.CentroDistribucion"%>
<%@page import="com.liverpool.cebt.utils.Constantes"%>
<%@page import="com.liverpool.modelo.Usuario"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%
    HashMap<String,String> perms = null;
    Usuario user =new Usuario();
    CentroDistribucion seleccionCD = null;
    try
    {
        
        if(request.getSession(false)!=null)
        {
        	perms= (HashMap<String, String>) request.getSession(false).getAttribute(Constantes.CEBT_USER_PERMISOS_SESSION);
        	
            
        	if(request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION)!=null)
            {
                user = (Usuario) request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION);
                
                if(request.getSession(false).getAttribute(Constantes.CEBT_USER_CENTRO_SELECCIONADO) != null)
                {
                	seleccionCD = (CentroDistribucion) request.getSession(false).getAttribute(Constantes.CEBT_USER_CENTRO_SELECCIONADO);
                }
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
        System.out.print("ERROR de permisos ");
    }
%>
<div class="container-fluid">
<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar-default">
      <a class="navbar-brand" href="#">Liverpool</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        
	        <!--     	CITAS -->
	        <%if(perms.containsKey("11") || perms.containsKey("12") || perms.containsKey("13")){ %>
		    	<li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Citas</a>
		            <div class="dropdown-menu" aria-labelledby="dropdown01">
		            	 <%if(perms.containsKey("11") || perms.containsKey("12")){ %><a class="dropdown-item" onclick="validaCrearCitas()"  href="#">Crear</a><%}%>
		              	 <%if(perms.containsKey("11") || perms.containsKey("12")){ %><a class="dropdown-item" onclick="validaCancelarCitas()"  href="#">Cancelar</a><%}%>
		              	 <%if(perms.containsKey("11") || perms.containsKey("13")){ %><a class="dropdown-item" onclick="validaRevisarCitas()"  href="#">Revsisar</a><%}%>
		           </div>
	           </li>
		    <%}%>
		    
		    <!--     	REPORTES -->
			<%if(perms.containsKey("14")){ %>
			    <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reportes</a>
		            <div class="dropdown-menu" aria-labelledby="dropdown02">
		            	 <%if(perms.containsKey("14")){ %><a class="dropdown-item" onclick="validaVerReportes()"  href="#">Ver citas</a><%}%>
	         			 <%if(perms.containsKey("14")){ %><a class="dropdown-item" onclick="validaEntregaDiariaReporte()"  href="#">Entrega</a><%}%>
		           </div>
	           </li>
		    <%}%>
		    
			<!--     CONFIGURACION -->
			<%if(perms.containsKey("5")){ %>
		    	 <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Configuracion</a>
		            <div class="dropdown-menu" aria-labelledby="dropdown03">
		            	  <%if(perms.containsKey("2")){ %><a class="dropdown-item" onclick="validaUsuarios()"  href="#">Usuarios</a><%}%>
					      <%if(perms.containsKey("5")){ %><a class="dropdown-item" onclick="validaCentroDist()"  href="#">Centro de Distribucion</a><%}%>
					      <%if(perms.containsKey("5")){ %><a class="dropdown-item" onclick="validaHorarios()"  href="#">Horarios</a><%}%>
					      <%if(perms.containsKey("5")){ %><a class="dropdown-item" onclick="validaDias()"  href="#">Dias</a><%}%>
					      <%if(perms.containsKey("55")){ %><a class="dropdown-item" onclick="validaRoles()"  href="#">Roles</a><%}%>
		           </div>
	            </li>
		    <%}%>
	          
          
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
</div> 
   



