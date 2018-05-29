package com.liverpool.modelo;

public class Usuario 
{
	private  long idUsuario;
	private  int userRol;
	private  String nombre;
	private  String paterno;
	private  String materno;
	private  String username;
	private  String contraseña;
	private String strName;
	private String usrRolDescripcion;
	
	
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String paterno, String materno) {
		super();
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public int getUserRol() {
		return userRol;
	}
	public void setUserRol(int userRol) {
		this.userRol = userRol;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getUsrRolDescripcion() {
		return usrRolDescripcion;
	}
	public void setUsrRolDescripcion(String usrRolDescripcion) {
		this.usrRolDescripcion = usrRolDescripcion;
	}
	
	
	
}
