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
    CentroDistribucion centroD = null;
    

    try
    {
        
        if(request.getSession(false)!=null)
        {
            perms= (HashMap<String, String>) request.getSession(false).getAttribute(Constantes.CEBT_USER_PERMISOS_SESSION);
            
            if(request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION)!=null)
            {
                user = (Usuario) request.getSession(false).getAttribute(Constantes.CEBT_USER_SESSION);
            }
            if(request.getSession(false).getAttribute(Constantes.CEBT_USER_CENTRO_SELECCIONADO)!=null)
            {
            	centroD = (CentroDistribucion) request.getSession(false).getAttribute(Constantes.CEBT_USER_CENTRO_SELECCIONADO);
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
		<script src="../js/usuarios.js"></script>
		<link rel="stylesheet" href="../css/liverpool.css">
		<link href="https://use.fontawesome.com/releases/v5.0.7/css/all.css" rel="stylesheet">

		<title>Liverpool-CEBT</title>
		
	</head>
	
	<body>
		<header style="height:70px;">
			<s:include value="/jsp/menuHeader.jsp"></s:include>
		</header>
		<div id="notificationError"></div>
		
		<div id="loading" style="display:none">
		  	<img src="../imagenes/load.svg">
		</div>
		
<!-- 		CORE  -->
		<div class="container">
		<input type="hidden" name="country" id="idCentro" value="<%=centroD.getIdCentro()%>">
		
			<div class="card border-danger" >
			  <ul class="list-group ">
			  
			  <!-- 			FILTRO -->
			    <li class="list-group-item border-danger">
			    	<div class="form-inline">
					   <div class="form-group">
						    <label for="selectFiltro">Filtrar por:</label>
						    <select class="form-control mx-sm-3"  id="selectFiltro">
						     	<option selected>Seleccione....</option>
							    <option value="1">Nombre</option>
							    <option value="2">Usuario</option>
							    <option value="3">Tipo de usuario</option>
							</select>
						</div>	
						<div class="form-group" style="padding-top:1%;">
						
<!-- 							FILTRO NOMBRE -->
							<label class="filtroNombre" for="txtNombre" style="display: none">Nombre:</label>
						    <input type="text" id="txtNombre" class=" filtroNombre form-control mx-sm-3" style="display: none">
						    
						    <label class="filtroNombre" for="txtPaterno" style="display: none">A. Paterno:</label>
						    <input type="text" id="txtPaterno" class="filtroNombre form-control mx-sm-3" style="display: none">
						    
						    <label class="filtroNombre" for="txtMaterno" style="display: none">A. Materno:</label>
						    <input type="text" id="txtMaterno" class="filtroNombre form-control mx-sm-3" style="display: none">
						    
<!-- 						    FILTRO USERNAME -->
							<label class="filtroUsuario" for="txtUser" style="display: none">Usuario:</label>
						    <input type="text" id="txtUser" class="filtroUsuario form-control mx-sm-3" style="display: none">
						    
<!-- 						    FILTRO TIPO USUARIO -->
						    <label class="filtroTipoUsuario" for="selectFiltro" style="display: none">Tipo de usuario:</label>
						    <select class="filtroTipoUsuario form-control mx-sm-3"  id="selectTipoUsuario" style="display: none">
							    <option selected>Seleccione....</option>
							    <option value="0">Proveedor</option>
							    <option value="1">Administrador</option>
							    <option value="3">Consulta</option>
							</select>
						    
						    
						    <button id="btnBuscar" class="btn btn-liverpool mx-sm-3" onclick="buscarUser(this);" style="display: none">Buscar</button>
					  	</div>
					</div>
				</li>
				
				<!-- 			TABLA -->
			    <li class="list-group-item border-danger ">
					<div class="table-responsive" style="height:400px;" id="tableContent">
						<table class='table table-sm table-bordered table-hover table-striped '>
							<thead class='thead-default'>
								<tr>
									<th scope="col" class='liverTable' style="width:10%;">#</th>
									<th scope="col" class='liverTable' style="width:30%;">Nombre</th>
									<th scope="col" class='liverTable' style="width:20%;">Tipo de usuario</th>
									<th scope="col" class='liverTable' style="width:20%;">Usuario</th>
									<th scope="col" class='liverTable' style="width:20%;">Contraseña</th>
								</tr>
							</thead>
							<tbody>
							<s:if test="%{listaUsuarios != null}">
								<s:iterator var="USUARIO" value="listaUsuarios">
									<tr>
									    <td>..</td>
										<td><s:property value="#USUARIO.strName"/> </td>
										<td><s:property value="#USUARIO.usrRolDescripcion"/></td>
										<td><s:property value="#USUARIO.username"/></td>
										<td>***********</td>
									</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr>
							   		<td><p>Sin datos</p></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
							    </tr>
							</s:else>
							</tbody>
						</table>
					</div>
				<li class="list-group-item ">
					<button type="button" class="btn btn-liverpool float-right mx-sm-3 "  onClick="openModal(0);" data-toggle='modal' data-target='#exampleModal' data-whatever='@mdo'><i class="fas fa-user-plus"></i> Agregar</button>
				</li>
			  </ul>
			</div>
			
			
			<!-- 			VENTANA MODAL  -->
			<div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-lg" role="document">
			    <div class="modal-content">
			    	
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel"></h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      
			      <div class="modal-body">
					  <div class="container-fluid">
				  		<div class="row">
				  		
							<input type="hidden" name="country" id=idUsuario value="xx">
						    <div class="col">
						     	<label for="txtNombreModal">Nombre(s):</label>
					        	<input type="text" class="form-control" id="txtNombreModal">
					        	
					            <label for="txtAmaternoModal" >Apellido Materno </label>
					            <input type="text" class="form-control " id="txtAmaternoModal">
					            
					            <label for="txtTipoUsuarioModal" >Tipo Usuario </label>
					            <input type="text" class="form-control" id="txtTipoUsuarioModal">
					            
					            <label for="txtContrasena2Modal" >Repetir Contraseña</label>
					            <input type="password" class="form-control" id="txtContrasena2Modal">
					            
						    </div>
						    
						    <div class="col">
						      <label for="txtApaternoModal">Apellido Paterno:</label>
					        	<input type="text"  class="form-control" id="txtApaternoModal">
					        	
					            <label for="txtUsernameModal" >Nombre Usuario</label>
					            <input type="text" class="form-control " id="txtUsernameModal">
					            
					            <label for="txtContraseniaModel" >Contraseña</label>
					            <input type="password" class="form-control" id="txtContraseniaModel">
						    </div>
						</div>
					  </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        <button type="button" onClick="btnMandarBorrador" class="btn btn-liverpool">Salvar</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	
<!-- 		END CORE  -->
	 
	</body>
</html>