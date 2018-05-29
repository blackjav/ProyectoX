$( document ).ready(function() {

	console.log("Cargando configuracion del dia actual ");
	
	//Creando AJAX inicial
	var result = sendDate(currentDate(),'initialLoad');
	console.log(result);
	
});

function currentDate()
{
	var hoy = new Date();
	var dd = hoy.getDate();
	var mm = hoy.getMonth()+1; //hoy es 0!
	var yyyy = hoy.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	hoy = dd+'/'+mm+'/'+yyyy;
	return hoy;
}

function printChar(labelsArry,datasArry,backGroundColorArry,bordercolorArry)
{
	var ctx = document.getElementById("myChart").getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: labelsArry,
	        datasets: [{
	        	label: '# de remisiones creadas',
	            data: datasArry,
	            backgroundColor: [
	                'rgba(75, 192, 192, 0.2)'
	            ],
	            borderColor: [
	                'rgba(75, 192, 192, 1)'
	            ],
	            borderWidth: 2
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
}

function sendDate(currentDate,action)
{
	$('#selectPedido').find('option').remove();
	
	var mensajeDisplay="";
	var json ={
			"currentDate"		:currentDate
	}
	
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
					return jsonResponse.result;
				}
				else
				{
					mensajeDisplay = jsonResponse.mensaje;
					var options1 = {
							  'title': '¡Lo siento!',
							  'style': 'info',
							  'message': mensajeDisplay,
							  'icon': 'warning',
							  'timeout': '3000'
							  };
					var n1 = new notify(options1);
					n1.show();
					return undefined;
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
						return undefined;
		}
	});



}