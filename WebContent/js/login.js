$( document ).ready(function() {
});

function inicar(element){
	var mensajeDisplay="";
	var name = $("#usuario").val();
	var pass = $("#pass").val();
	var json ={
			"userLog"		:name,
			"passLog"		:pass
	}
	
	var screen = $('#loading');
	configureLoadingScreen(screen);
	$.ajax
	({
		url 		: "login",
		type 		: "POST",
		data		:  json,
		dataType 	: "json",
		success 	: function(jsonResponse) 
		{
			    //jsonResponse.success= true;
			    
				if(jsonResponse.success)
				{
					window.location="../jsp/seleccionCD.jsp";
					
				}
				else
				{
					mensajeDisplay = jsonResponse.mensaje;
					var options1 = {
							  'title': 'Error Usuario/Contraseña',
							  'style': 'error',
							  'message': mensajeDisplay,
							  'icon': 'warning',
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
								  };
						var n1 = new notify(options1);
						n1.show();
		}
	});
}