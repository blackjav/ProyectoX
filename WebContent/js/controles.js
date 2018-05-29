function configureLoadingScreen(screen){
    $(document)
        .ajaxStart(function () {
            screen.fadeIn();
        })
        .ajaxStop(function () {
            screen.fadeOut();
        });
}


function sendAjaxService(screen,uri,json,asincrono)
{
	var obj =null;
	configureLoadingScreen(screen);
	$.ajax
	({
		url 		:  uri,
		type 		:  "POST",
		data		:  json,
		async		:  asincrono,
        cache		:  false,
        timeout		:  30000,//30segundoa
		dataType 	:  "json",
		success 	: function(jsonResponse) 
		{
			obj = {
				    success: jsonResponse.success,
				    result: jsonResponse.result,
				    mensaje: jsonResponse.mensaje
				  };
			
		},
		error 		 : function(jqXHR, textStatus, errorThrown) 
					  {
			 			   obj =null;
					  }
	});
	
	return obj;

}