package com.analisisnumerico.controlador.excepciones;


public class CalculoExcepcion extends MetodoExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1644851152965225898L;
	
	private static final String mensaje = "Ocurri� un error calculando la f�rmula ";

	public CalculoExcepcion(String formula, Throwable cause) {
		super(mensaje + formula, cause);
		// TODO Auto-generated constructor stub
	}

	public CalculoExcepcion() {
		super(mensaje);
	}

	public CalculoExcepcion(String formula) {
		super(mensaje + formula);
	}
	
	
}
