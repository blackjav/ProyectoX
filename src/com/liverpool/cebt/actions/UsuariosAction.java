//package com.liverpool.cebt.actions;
//
//import java.util.HashMap;
//import java.util.List;
//
//import com.liverpool.cebt.excption.CEBTNotAuthorizedException;
//import com.liverpool.cebt.excption.CEBTSessionException;
//import com.liverpool.cebt.impl.UsuarioDaoImpl;
//import com.liverpool.cebt.service.CebtAction;
//import com.liverpool.cebt.service.ServiceResponse;
//import com.liverpool.cebt.utils.Constantes;
//import com.liverpool.modelo.Usuario;
//
//public class UsuariosAction extends CebtAction{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 9078387437881075706L;
//	private List<Usuario> listaUsuarios;
//	private String nombre;
//	private String paterno;
//	private String materno;
//	private String usuario;
//	private String tipoUsuario;
//	private int idUsuario;
////	
//	@SuppressWarnings("unchecked")
//	public String vistaUsuarios()
//	{
//		String resultAction ="success";
//		try
//		{
////			TODO Bloque de validacion obligatorio
//			Usuario user =(Usuario ) session.get(Constantes.CEBT_USER_SESSION);
//			
//			HashMap<String, String> perms = (HashMap<String, String> )session.get(Constantes.CEBT_USER_PERMISOS_SESSION);
//			if(user==null)
//			{
//				throw new CEBTSessionException();
//			}			
//			if(perms==null || (perms.containsKey("5"))==false )
//			{// perms 2: Vista de home.
//				System.out.println("El usuario " + user + " No cuenta con los permisos necesarios para ejecutar este módulo[11,12].");
//				throw new CEBTNotAuthorizedException("No cuentas con autorización para ejecutar esta transacción");
//			}
////			TODO END bloque de validacion obligatorio
//			
//			
//			System.out.println("Se ha autorizado entrada al usaurio "+user.getUsername()+" para el modulo de usuarios");
//			
//			//verificar si es proveedor para de una vez cargarle los pedidos.
//			//vamos a cargar todos los usuarios de ese centro de distribución
//			//UsuarioDaoImpl dao = new UsuarioDaoImpl();
//			ServiceResponse sr = new ServiceResponse();
//			
////			sr = dao.obtenerTodosUsuariosPorCentro();
////			if(sr.isSuccess())
////			{
////				listaUsuarios = (List<Usuario>) sr.getResult();
////				
////			}
//			sr.setResult(null);
//			sr.setMensaje("Ok");
//			sr.setSuccess(true);
//			
//		}
//		catch(CEBTNotAuthorizedException auth)
//		{
//			System.out.println("111");
//			System.out.println("CEBTNotAuthorizedException: " + auth.getMessage());
//			resultAction = Constantes.CEBT_EXCEPTION_NO_AUTORIZATION;
//			setActionError("No cuentas con autorización para ejecutar esta transacción");
//		}
//		catch(CEBTSessionException session)
//		{
//			System.out.println("1");
//			System.out.println("CEBTSessionException: " + session.getMessage());
//			resultAction=Constantes.CEBT_EXCEPTION_NO_SESSION;
//		}
//		catch(Exception e )
//		{
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//			resultAction=Constantes.CEBT_EXCEPTION_GENERAL_ERROR;
//			setActionError("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//		}
//		return resultAction;
//	}
//	
//	
//	public String buscarUsuarioPorId()
//	{
//
//		ServiceResponse response = new ServiceResponse();
//		try
//		{
////			TODO Bloque de validacion obligatorio
//			Usuario user =(Usuario ) session.get(Constantes.CEBT_USER_SESSION);
//			
//			HashMap<String, String> perms = (HashMap<String, String> )session.get(Constantes.CEBT_USER_PERMISOS_SESSION);
//			if(user==null)
//			{
//				throw new CEBTSessionException();
//			}			
//			if(perms==null || (perms.containsKey("5"))==false )
//			{// perms 2: Vista de home.
//				System.out.println("El usuario " + user + " No cuenta con los permisos necesarios para ejecutar este módulo[11,12].");
//				throw new CEBTNotAuthorizedException("No cuentas con autorización para ejecutar esta transacción");
//			}
////			TODO END bloque de validacion obligatorio
//			UsuarioDaoImpl dao = new UsuarioDaoImpl();
//
//			Usuario u = new Usuario();
//			u.setIdUsuario(this.idUsuario);
//			response = dao.obtenerUsuarioPorID(u);
//			
//			
//		}
//		catch(CEBTNotAuthorizedException auth)
//		{
//			System.out.println("111");
//			System.out.println("CEBTNotAuthorizedException: " + auth.getMessage());
//			setActionError("No cuentas con autorización para ejecutar esta transacción");
//			response.setSuccess(false);
//			response.setMensaje("No tiene permisos para ejecutar esta operación.");
//			response.setResult(null);
//		}
//		catch(CEBTSessionException session)
//		{
//			System.out.println("1");
//			System.out.println("CEBTSessionException: " + session.getMessage());
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, su session ha terminado.");
//			response.setResult(null);
//		}
//		catch(Exception e )
//		{
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//			setActionError("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setResult(null);
//		}
//		
//		sendJSONObjectToResponse(response);
//
//		return null;
//	
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	public String filtroXnombre()
//	{
//		ServiceResponse response = new ServiceResponse();
//		try
//		{
////			TODO Bloque de validacion obligatorio
//			Usuario user =(Usuario ) session.get(Constantes.CEBT_USER_SESSION);
//			
//			HashMap<String, String> perms = (HashMap<String, String> )session.get(Constantes.CEBT_USER_PERMISOS_SESSION);
//			if(user==null)
//			{
//				throw new CEBTSessionException();
//			}			
//			if(perms==null || (perms.containsKey("5"))==false )
//			{// perms 2: Vista de home.
//				System.out.println("El usuario " + user + " No cuenta con los permisos necesarios para ejecutar este módulo[11,12].");
//				throw new CEBTNotAuthorizedException("No cuentas con autorización para ejecutar esta transacción");
//			}
////			TODO END bloque de validacion obligatorio
//			System.out.println("Filtro de nombre");
//			UsuarioDaoImpl dao = new UsuarioDaoImpl();
//			//response = dao.filtroXnombre1(nombre);
//			if(nombre != null && nombre.length()>0)
//			{
//				if(paterno != null && paterno.length() > 0)
//				{
//					if(materno != null && materno.length() > 0)
//					{
//						response= dao.filtroXnombre(new Usuario(nombre, paterno, materno), "filtroNombreFull");
//					}
//					else
//					{
//						response= dao.filtroXnombre(new Usuario(nombre, paterno, null), "filtroNombreNombreApaterno");
//					}
//				}
//				else
//				{
//					if(materno != null && materno.length() > 0)
//					{
//						response= dao.filtroXnombre(new Usuario(nombre, null, materno), "filtroNombreNombreAmaterno");
//					}
//					else
//					{
//						response= dao.filtroXnombre(new Usuario(nombre, null, null), "filtroNombreNombre");
//					}
//				}
//			}
//			else
//			{
//				if(paterno != null && paterno.length() > 0)
//				{
//					if(materno != null && materno.length() > 0)
//					{
//						response= dao.filtroXnombre(new Usuario(null, paterno, materno), "filtroNombrePaternoAmaterno");
//					}
//					else
//					{
//						response= dao.filtroXnombre(new Usuario(null, paterno, null), "filtroNombreApaterno");
//					}
//				}
//				else
//				{
//					if(materno != null && materno.length() > 0)
//					{
//						response= dao.filtroXnombre(new Usuario(null, null, materno), "filtroNombreAmaterno");
//					}
//					else
//					{
//						response.setSuccess(false);
//						response.setResult(null);
//						response.setMensaje("No se han ingresado correctamente los criterios de busqueda.");
//					}
//				}
//			}
//			
//		}
//		catch(CEBTNotAuthorizedException auth)
//		{
//			System.out.println("111");
//			System.out.println("CEBTNotAuthorizedException: " + auth.getMessage());
//			setActionError("No cuentas con autorización para ejecutar esta transacción");
//			response.setSuccess(false);
//			response.setMensaje("No tiene permisos para ejecutar esta operación.");
//			response.setResult(null);
//		}
//		catch(CEBTSessionException session)
//		{
//			System.out.println("1");
//			System.out.println("CEBTSessionException: " + session.getMessage());
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, su session ha terminado.");
//			response.setResult(null);
//		}
//		catch(Exception e )
//		{
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//			setActionError("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setResult(null);
//		}
//		sendJSONObjectToResponse(response);
//		return null;
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	public String filtroXUsuario()
//	{
//
//		ServiceResponse response = new ServiceResponse();
//		try
//		{
////			TODO Bloque de validacion obligatorio
//			Usuario user =(Usuario ) session.get(Constantes.CEBT_USER_SESSION);
//			
//			HashMap<String, String> perms = (HashMap<String, String> )session.get(Constantes.CEBT_USER_PERMISOS_SESSION);
//			if(user==null)
//			{
//				throw new CEBTSessionException();
//			}			
//			if(perms==null || (perms.containsKey("5"))==false )
//			{// perms 2: Vista de home.
//				System.out.println("El usuario " + user + " No cuenta con los permisos necesarios para ejecutar este módulo[11,12].");
//				throw new CEBTNotAuthorizedException("No cuentas con autorización para ejecutar esta transacción");
//			}
////			TODO END bloque de validacion obligatorio
//			UsuarioDaoImpl dao = new UsuarioDaoImpl();
//			System.out.println("Filtro de usuario");
//			Usuario u = new Usuario();
//			u.setUsername(usuario);
//			System.out.println(usuario +" vs "+u.getUsername());
//			response = dao.filtroXnombre(u, "filtroUser");
//			
//		}
//		catch(CEBTNotAuthorizedException auth)
//		{
//			System.out.println("111");
//			System.out.println("CEBTNotAuthorizedException: " + auth.getMessage());
//			setActionError("No cuentas con autorización para ejecutar esta transacción");
//			response.setSuccess(false);
//			response.setMensaje("No tiene permisos para ejecutar esta operación.");
//			response.setResult(null);
//		}
//		catch(CEBTSessionException session)
//		{
//			System.out.println("1");
//			System.out.println("CEBTSessionException: " + session.getMessage());
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, su session ha terminado.");
//			response.setResult(null);
//		}
//		catch(Exception e )
//		{
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//			setActionError("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setResult(null);
//		}
//		sendJSONObjectToResponse(response);
//		return null;
//	
//	}
//	
//	public String filtroXtipoUsuario()
//	{
//		ServiceResponse response = new ServiceResponse();
//		try
//		{
////			TODO Bloque de validacion obligatorio
//			Usuario user =(Usuario ) session.get(Constantes.CEBT_USER_SESSION);
//			
//			HashMap<String, String> perms = (HashMap<String, String> )session.get(Constantes.CEBT_USER_PERMISOS_SESSION);
//			if(user==null)
//			{
//				throw new CEBTSessionException();
//			}			
//			if(perms==null || (perms.containsKey("5"))==false )
//			{// perms 2: Vista de home.
//				System.out.println("El usuario " + user + " No cuenta con los permisos necesarios para ejecutar este módulo[11,12].");
//				throw new CEBTNotAuthorizedException("No cuentas con autorización para ejecutar esta transacción");
//			}
////			TODO END bloque de validacion obligatorio
//			
//			
//			UsuarioDaoImpl dao = new UsuarioDaoImpl();
//			System.out.println("Filtro por tipo de usuario");
//			Usuario u = new Usuario();
//			u.setUserRol(Integer.parseInt(tipoUsuario));
//			response = dao.filtroXnombre(u, "filtroTipoUser");
//		}
//		catch(CEBTNotAuthorizedException auth)
//		{
//			System.out.println("111");
//			System.out.println("CEBTNotAuthorizedException: " + auth.getMessage());
//			setActionError("No cuentas con autorización para ejecutar esta transacción");
//			response.setSuccess(false);
//			response.setMensaje("No tiene permisos para ejecutar esta operación.");
//			response.setResult(null);
//		}
//		catch(CEBTSessionException session)
//		{
//			System.out.println("1");
//			System.out.println("CEBTSessionException: " + session.getMessage());
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, su session ha terminado.");
//			response.setResult(null);
//		}
//		catch(Exception e )
//		{
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//			setActionError("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setSuccess(false);
//			response.setMensaje("Estimado usuario, ocurrió un problema con su operación, por favor reintentelo.");
//			response.setResult(null);
//		}
//		sendJSONObjectToResponse(response);
//		return null;
//	
//	
//	}
//	
//	
//	
//	
//	public int getIdUsuario() {
//		return idUsuario;
//	}
//
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//
//	public List<Usuario> getListaUsuarios() {
//		return listaUsuarios;
//	}
//	public void setListaUsuarios(List<Usuario> listaUsuarios) {
//		this.listaUsuarios = listaUsuarios;
//	}
//
//
//	public String getNombre() {
//		return nombre;
//	}
//
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getPaterno() {
//		return paterno;
//	}
//
//
//	public void setPaterno(String aPaterno) {
//		this.paterno = aPaterno;
//	}
//
//
//	public String getMaterno() {
//		return materno;
//	}
//
//
//	public void setMaterno(String aMaterno) {
//		this.materno = aMaterno;
//	}
//
//
//	public String getUsuario() {
//		return usuario;
//	}
//
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//
//	public String getTipoUsuario() {
//		return tipoUsuario;
//	}
//
//
//	public void setTipoUsuario(String tipoUsuario) {
//		this.tipoUsuario = tipoUsuario;
//	}
//	
//	
//}
