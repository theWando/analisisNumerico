package com.analisisnumerico.controlador.excepciones;

public class LimitesInsuficientes extends MetodoExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414970666728567384L;

	public LimitesInsuficientes(){
		super("Los limites son insuficientes para evaluar la función");
	}
}
