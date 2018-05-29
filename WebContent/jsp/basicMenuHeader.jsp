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
        System.out.print("ERROR de permisos ");
    }
    
    
     
%>
<div class="container-fluid">
<div class="row">	
<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar-default">
      <a class="navbar-brand" href="#">Liverpool</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
</div> 
</div>   
    <div class="row">.</div>
    <div class="row">.</div>
    <div class="row">.</div>

</body>
</html>