package com.liverpool.cebt.excption;

public class CEBTSessionException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 *Default Constructor 
	 */
	public CEBTSessionException() {
		// Auto-generated constructor stub
		super("Estimado usuario, su sesi�n actual ya no es valida. Inicie secion nuevamente.");
	}

	/**
	 * @param error Texto de la nueva excepci�n
	 */
	public CEBTSessionException(String error) {
		super(error);
		// Auto-generated constructor stub
	}

}
