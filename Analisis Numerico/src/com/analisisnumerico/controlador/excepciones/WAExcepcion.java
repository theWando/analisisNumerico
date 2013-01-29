package com.analisisnumerico.controlador.excepciones;


public class WAExcepcion extends MetodoExcepcion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9124634809101300034L;

	private int code;
	
	private String message;
	
	
	public WAExcepcion(Throwable cause) {
		super(cause);
	}

	public WAExcepcion(int code, String message){
		super("Error con la plataforma de WolfrmAlpha: CODE: " + code + " | MESSAGE: " + message);
		this.code = code;
		this.message = message;
	}
	
	public WAExcepcion(){
		super("No fue entendida la funcion, no se pueden arrojar resultados");
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
