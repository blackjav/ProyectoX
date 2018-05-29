package com.liverpool.cebt.actions;

import com.liverpool.cebt.service.CebtAction;
import com.liverpool.cebt.service.ServiceResponse;

public class LoginAction extends CebtAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7368924168218834981L;
	private String userLog;
	private String passLog;
	
	public String validaUsuario()
	{
		ServiceResponse usuarioResponse= new ServiceResponse();
		try{
			System.out.println("Se ingreso al usuario : "+userLog);
			System.out.println("Con la contraseña : " +  passLog);
			
			usuarioResponse.setResult(null);
			usuarioResponse.setSuccess(true);
			usuarioResponse.setMensaje("Ha ocurrido una excepción al intentar obtener las credenciales de usuario.");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			usuarioResponse.setResult(null);
			usuarioResponse.setSuccess(false);
			usuarioResponse.setMensaje("Ha ocurrido una excepción al intentar obtener las credenciales de usuario.");
			
			
		}
		
//		Envia resultado Final de la evaluación
		sendJSONObjectToResponse(usuarioResponse);
		return null;
	}

	public String getUserLog() {
		return userLog;
	}

	public void setUserLog(String userLog) {
		this.userLog = userLog;
	}

	public String getPassLog() {
		return passLog;
	}

	public void setPassLog(String passLog) {
		this.passLog = passLog;
	}
	
	
}
