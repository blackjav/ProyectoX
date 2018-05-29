function citasMenu() {
    var x = document.getElementById("citasDrop");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

function reportesMenu() {
    var x = document.getElementById("reportesDrop");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

function administracionMenu() {
    var x = document.getElementById("adminDrop");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

function sendForm(action, method, values) {
	var form = $('<form/>', {
		action: action,
		method: method
	});
	
	
	$.each(values, function() {
		
		form.append($('<input/>', {
			type: 'hidden',
			name: this.name,
			value: this.value
		})); 
		
	});
	//configureLoadingScreen(screen);
	form.appendTo('body').submit();
}



function validaCrearCitas()
{
	console.log("Se va a verificar si puede crear citas.");
	var screen = $('#loading');
	configureLoadingScreen(screen);
	sendForm('crearCitas','POST','',[{vista:'crearCitas'}])
}
function validaCancelarCitas()
{
	
}
function validaRevisarCitas()
{
}
function validaVerReportes()
{
}
function validaEntregaDiariaReporte()
{
}
function validaUsuarios()
{
	console.log("Se va a mandar validar usuariso.");
	var screen = $('#loading');
	configureLoadingScreen(screen);
	sendForm('vistaUsuarios','POST','',[{vista:'vistaUsuarios'}])
}

function validaCentroDist()
{
}

function validaHorarios()
{
}
function validaDias()
{

}
function validaRoles()
{
	}