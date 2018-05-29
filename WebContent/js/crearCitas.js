$( document ).ready(function() 
{
	$("#txtProveedor").keydown(function(event){
		//console.log("El código de la tecla " + String.fromCharCode(event.which) + " es: " + event.which);
		disableControllers();
	}); 
	
});

function cleanElemts()
{
	var tabla = $('#tableContent table');
	tabla.remove();
	var select= $('#selectPedido').find('option').remove().end().append($('<option>', { 
        value: "x",
        text : "--Sin Datos1--"
    }));
	
}
function enableControllers()
{
	var btnConsultar= $('#btnConsultarDetalles');
	
	//habilita botones
	btnConsultar.css('display','');
	
}

function disableControllers()
{
	var btnConsultar= $('#btnConsultarDetalles');
	
	//deshabilita botones
	btnConsultar.css('display','none');
	cleanElemts();
}

function buscarPedidos()
{
		disableControllers();
		$('#selectPedido').find('option').remove();
		
		var mensajeDisplay="";
		var proveedor = $("#txtProveedor").val();
		var idCentro = $("#idCentro").val();
		var json ={
				"proveedor"		:proveedor,
				"idCentro"		:idCentro
		}
		
		var screen = $('#loading');
		configureLoadingScreen(screen);
		$.ajax
		({
			url 		: "obtenerPedidos",
			type 		: "POST",
			data		:  json,
			dataType 	: "json",
			success 	: function(jsonResponse) 
			{
					if(jsonResponse.success)
					{
						var options1 = {
								  'title': 'Correcto!',
								  'style': 'success',
								  'message': jsonResponse.mensaje,
								  'icon': 'check',
							      'timeout': '1000'

								  };
						var n1 = new notify(options1);
						n1.show();
						$('#selectPedido').append($('<option>', { 
						        value: "x",
						        text : "--Seleccione un pedido--"
						    }));
						$.each(jsonResponse.result, function (i, item) 
						{
						    $('#selectPedido').append($('<option>', 
						    { 
						        value: item.numeroPedido,
						        text : item.numeroPedido
						    }));
						});
						
						enableControllers();
						
					}
					else
					{
						mensajeDisplay = jsonResponse.mensaje;
						var options1 = {
								  'title': 'Error al obtener pedidos',
								  'style': 'info',
								  'message': mensajeDisplay,
								  'icon': 'warning',
								  'timeout': '2000'
								  };
						var n1 = new notify(options1);
						n1.show();
						
						$('#selectPedido').append($('<option>', { 
						        value: '',
						        text : '--Sin Datos--' 
					    }));
						disableControllers();
						
					}
				
			},
			error 		 : function(jqXHR, textStatus, errorThrown) {
							var options1 = {
									  'title': 'Error',
									  'style': 'error',
									  'message': 'El servicio esta temporalmente inactivo. Intentelo mas tarde, Gracias.',
									  'icon': 'warning',
									  'timeout': '3000'
									  };
							var n1 = new notify(options1);
							n1.show();
							
							$('#selectPedido').append($('<option>', { 
						        value: '',
						        text : 'Sin Datos' 
					    }));
						disableControllers();
			}
		});
	
	
}

function pintarTabla(jsonResponse)
{
	var table="<table class='table table-hover table-striped'>";
	table += "<thead  class='thead-default'>";
	table+= "<tr>";
	table+= "<th class='liverTable'>#</th>";
	table+= "<th class='liverTable'>No. Pedido</th>";
	table+= "<th class='liverTable'>SKU</th>";
	table+= "<th class='liverTable'>C\u00F3digo EAN</th>";
	table+= "<th class='liverTable'>Descripci\u00F3n</th>";
	table+= "<th class='liverTable'>Solicitadas</th>";
	table+= "<th class='liverTable'>Negativas</th>";
	table+= "<th class='liverTable'>Entregadas</th>";
	table+= "<th class='liverTable'>Citadas</th>";
	table+='</tr>';
	table+= '</thead>';
	// colocar en la lista					
	$.each(jsonResponse.result, function (i, item) 
	{
		
		table+= "<tr id='"+item.numeroPedido+"' >";
		table+=" <td><a href='#' onClick='openModal("+item.numeroPedido+");' data-toggle='modal' data-target='#exampleModal' data-whatever='@mdo'><i class='fas fa-bell'></i></a></td>";
		table+= '<td>'+item.numeroPedido+'</td>';
		table+= '<td>'+item.sku+'</td>';
		table+= '<td>'+item.ean+'</td>';
		table+= '<td>'+item.descripcion+'</td>';
		table+= '<td>'+item.cantidadSolicitada+'</td>';
		table+= '<td>'+item.piezasNegativas+'</td>';
		table+= '<td>'+item.cantidadEntregada+'</td>';
		table+= '<td>'+item.cantidadCitada+'</td>';
		table+= '</tr>';		
	});
	table +="</table>";
	$('#tableContent').append(table);
	
}


function verDetalleCitas()
{
	var mensajeDisplay="";
	var proveedor = $("#txtProveedor").val();
	var idCentro = $("#idCentro").val();
	var pedido = $("#selectPedido").val();
	console.log(pedido); 
	var json ={
			"proveedor"		:proveedor,
			"idCentro"		:idCentro,
			"pedido"		:pedido
	}
	
	var screen = $('#loading');
	configureLoadingScreen(screen);
	$.ajax
	({
		url 		: "obtenerCitas",
		type 		: "POST",
		data		:  json,
		dataType 	: "json",
		success 	: function(jsonResponse) 
		{
				if(jsonResponse.success)
				{
					console.log(jsonResponse.mensaje);
					var options1 = {
							  'title': 'Correcto!',
							  'style': 'success',
							  'message': jsonResponse.mensaje,
							  'icon': 'check',
						      'timeout': '3000'

							  };
					var n1 = new notify(options1);
					n1.show();
					pintarTabla(jsonResponse)
					enableControllers();
					
				}
				else
				{
					mensajeDisplay = jsonResponse.mensaje;
					var options1 = {
							  'title': 'Error al obtener el detalle de pedidos.',
							  'style': 'info',
							  'message': mensajeDisplay,
							  'icon': 'warning',
							  'timeout': '3000'
							  };
					var n1 = new notify(options1);
					n1.show();
					
					
					
				}
			
		},
		error 		 : function(jqXHR, textStatus, errorThrown) {
						var options1 = {
								  'title': 'Error',
								  'style': 'error',
								  'message': 'El servicio esta temporalmente inactivo. Intentelo mas tarde, Gracias.',
								  'icon': 'warning',
								  'timeout': '3000'
								  };
						var n1 = new notify(options1);
						n1.show();
						
						$('#selectPedido').append($('<option>', { 
					        value: 'x',
					        text : 'Sin Datos' 
				    }));
		}
	});

}

function btnMandarBorrador()
{
	console.log("se va a mandar a borrador");
	var mensajeDisplay="";
	var proveedor = $("#txtProveedor").val();
	var pedido = $("#noPedidoDetalleCita").val();
	var idCentro = $("#idCentro").val();
	var camiones = $("#noCamiones").val();
	var fecha = $("#fechaCita").val();
	
	// agregar validacion
	

}

function openModal(idPedido)
{
	console.log("El id del pedido es "+idPedido);
	
	$('#noPedidoDetalleCita').val(idPedido);
	var json ={
			"proveedor"		:proveedor,
			"idCentro"		:idCentro,
			"pedido"		:pedido,
			"camiones"		:camiones,
			"fecha"			:fecha
	}
	
	var screen = $('#loading');
	configureLoadingScreen(screen);
	$.ajax
	({
		url 		: "generarBorrador",
		type 		: "POST",
		data		:  json,
		dataType 	: "json",
		success 	: function(jsonResponse) 
		{
				if(jsonResponse.success)
				{
					var options1 = {
							  'title': 'Cita agregada a borrador.',
							  'style': 'success',
							  'message': jsonResponse.mensaje,
							  'icon': 'check',
						      'timeout': '3000'

							  };
					var n1 = new notify(options1);
					n1.show();
				}
				
				else
				{
					mensajeDisplay = jsonResponse.mensaje;
					var options1 = {
							  'title': 'Error al agregar cita a borrador.',
							  'style': 'Error',
							  'message': mensajeDisplay,
							  'icon': 'warning',
							  'timeout': '3000'
							  };
					var n1 = new notify(options1);
					n1.show();
				}
			
		},
		error 		 : function(jqXHR, textStatus, errorThrown) {
						var options1 = {
								  'title': 'Error',
								  'style': 'error',
								  'message': 'El servicio esta temporalmente inactivo. Intentelo mas tarde, Gracias.',
								  'icon': 'warning',
								  'timeout': '3000'
								  };
						var n1 = new notify(options1);
						n1.show();
						
		}
	});
}