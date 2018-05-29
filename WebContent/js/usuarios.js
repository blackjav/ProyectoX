$( document ).ready(function() {
	
    $('#selectFiltro').change(function(){
        var seleccionFiltro = $("#selectFiltro").val();
        var tabla = $('#tableContent table ');
    	tabla.remove();
    	pintarTabla(undefined);
        switch (seleccionFiltro) {
	        case "1":
		        	filtroUsuario(false);
		        	filtroTipoUsuario(false);
		        	filtroNombre(true);
				break;
	        case "2":
		        	filtroTipoUsuario(false);
		        	filtroNombre(false);
		        	filtroUsuario(true);
				break;
	        case "3":
		        	filtroUsuario(false);
		        	filtroNombre(false);
		        	filtroTipoUsuario(true);
				break;
			default:
					filtroUsuario(false);
		        	filtroTipoUsuario(false);
		        	filtroNombre(false);
				break;
		}
   });
    
});

// FILTROS
function filtroNombre(value)
{
	if(value == true)
	{
		$(".filtroNombre").css('display','');
		$("#btnBuscar").css('display','');
	}
	else
	{
		$(".filtroNombre").css('display','none');
		$("#btnBuscar").css('display','none');
	}
}
function filtroUsuario(value)
{
	if(value == true)
	{
		$(".filtroUsuario").css('display','');
		$("#btnBuscar").css('display','');
	}
	else
	{
		$(".filtroUsuario").css('display','none');
		$("#btnBuscar").css('display','none');
	}
}
function filtroTipoUsuario(value)
{
	if(value == true)
	{
		$(".filtroTipoUsuario").css('display','');
		$("#btnBuscar").css('display','');
	}
	else
	{
		$(".filtroTipoUsuario").css('display','none');
		$("#btnBuscar").css('display','none');
	}
}

// boton buscar

function buscarUser(element)
{
	 var seleccionFiltro = $("#selectFiltro").val();
	 switch (seleccionFiltro) {
     case "1":
	        	var nombre   = $("#txtNombre").val();
	        	var paterno = $("#txtPaterno").val();
	        	var materno = $("#txtMaterno").val();
	        	var screen = $('#loading');
	        	var json ={
						"nombre"		:nombre,
						"paterno"		:paterno,
						"materno"		:materno
					  }
	        	filtros(json,"filtroNombre");
			break;
			
			
     case "2":
		    	var user   = $("#txtUser").val();
		     	var json ={ "usuario"		:user  }
		     	filtros(json,"filtroUsuario");
	        	
			break;
     case "3":
    	 		var typeUser   = $("#selectTipoUsuario").val();
    	 		console.log(typeUser);
    	 		var json ={ "tipoUsuario"		:typeUser  }
    	 		filtros(json,"filtroTipoUsuario");
	        	
			break;
		default:
				
			break;
	}
}

function filtros(json,action)
{
	var screen = $('#loading');
	configureLoadingScreen(screen);
	$.ajax
	({
		url 		:  action,
		type 		: "POST",
		data		:  json,
		dataType 	: "json",
		success 	: function(jsonResponse) 
		{
			if(jsonResponse.success)
			{
				var options1 = {
						  'title': 'Filtro ejecutado.',
						  'style': 'success',
						  'message': jsonResponse.mensaje,
						  'icon': 'check',
					      'timeout': '3000'

						  };
				var n1 = new notify(options1);
				n1.show();
				// pintamos en la tabla
				pintarTabla(jsonResponse);
			}
			else
			{
				mensajeDisplay = jsonResponse.mensaje;
				var options1 = {
						  'title': 'Error Filtro.',
						  'style': 'error',
						  'message': mensajeDisplay,
						  'icon': 'info-circle',
						  'timeout': '5000'
						  };
				var n1 = new notify(options1);
				n1.show();
				pintarTabla(undefined);
			}
			
		},
		error 		 : function(jqXHR, textStatus, errorThrown) {
			
							var options1 = {
									  'title': 'Error.',
									  'style': 'error',
									  'message': 'El servicio esta temporalmente inactivo. Intentelo mas tarde, Gracias.',
									  'icon': 'error',
									  'timeout': '5000'
									  };
							var n1 = new notify(options1);
							n1.show();
							console.log("ERROR : "+jsonResponse);
							pintarTabla(undefined);
						}
	});
}


function pintarTabla(jsonResponse)
{
	var tabla = $('#tableContent table');
	tabla.remove();
	var table="<table class='table table-sm table-bordered table-hover table-striped'>";
	table += "<thead  class='thead-default'>";
	table+= "<tr>";
	table+= "<th scope='col' class='liverTable' style='width:10%;'>#</th>";
	table+= "<th scope='col' class='liverTable' style='width:30%;'>Nombre</th>";
	table+= "<th scope='col' class='liverTable' style='width:20%;'>Tipo de usuario</th>";
	table+= "<th scope='col' class='liverTable' style='width:20%;'>Usuario</th>";
	table+= "<th scope='col' class='liverTable' style='width:20%;'>Contrase&#241;a</th>";
	table+= '</thead>';
	// colocar en la lista	
	table+= '<tbody>';
	if(jsonResponse != undefined)
	{
		$.each(jsonResponse.result, function (i, item) 
		{
			table+= "<tr id='"+item.username+"' >";
			table+=" <td><a href='#' onClick='openModal("+item.idUsuario+");' data-toggle='modal' data-target='#exampleModal' data-whatever='@mdo'><i class='fas fa-edit'></i></a></td>";
			table+= '<td>'+item.strName+'</td>';
			table+= '<td>'+item.usrRolDescripcion+'</td>';
			table+= '<td>'+item.username+'</td>';
			table+= '<td>***********</td>';
			table+= '</tr>';		
		});
	}
	else
	{
		table+= "<tr>";
		table+=" <td>Sin datos</td>";
		table+= '<td></td>';
		table+= '<td> </td>';
		table+= '<td> </td>';
		table+= '<td> </td>';
		table+= '</tr>';
	}
	
	table+= '</tbody>';
	table +="</table>";
	$('#tableContent').html(table);
	
	
}

function openModal(item)
{
	console.log();
	console.log(item);
	
	if(item != 0)
	{
		var json ={
				"idUsuario"		:item,
			  }
		$.ajax
		({
			url 		:  "buscarUsuarioPorId",
			type 		: "POST",
			data		:  json,
			dataType 	: "json",
			success 	: function(jsonResponse) 
			{
				if(jsonResponse.success)
				{
					var user = jsonResponse.result;
					
					$('#idUsuario').val(item);
					$('#txtNombreModal').val(user.nombre);
					$('#txtAmaternoModal').val(user.materno);
					$('#txtTipoUsuarioModal').val(user.userRol);
					$('#txtApaternoModal').val(user.paterno);
					$('#txtUsernameModal').val(user.username);
				}
				else
				{
					mensajeDisplay = jsonResponse.mensaje;
					var options1 = {
							  'title': 'Error Filtro.',
							  'style': 'error',
							  'message': mensajeDisplay,
							  'icon': 'info-circle',
							  'timeout': '5000'
							  };
					var n1 = new notify(options1);
					n1.show();
					console.log("Data not found");
				}
				
			},
			error 		 : function(jqXHR, textStatus, errorThrown) {
				
								var options1 = {
										  'title': 'Error.',
										  'style': 'error',
										  'message': 'El servicio esta temporalmente inactivo. Intentelo mas tarde, Gracias.',
										  'icon': 'error',
										  'timeout': '5000'
										  };
								var n1 = new notify(options1);
								n1.show();
								console.log("ERROR : "+jsonResponse);
							}
		});
	}
	
	
}