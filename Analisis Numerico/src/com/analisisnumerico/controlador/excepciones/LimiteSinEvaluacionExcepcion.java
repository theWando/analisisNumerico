package com.analisisnumerico.controlador.excepciones;

public class LimiteSinEvaluacionExcepcion extends MetodoExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4846226328167155415L;

	public LimiteSinEvaluacionExcepcion(){
		super("El l�mite no posee un punto evaluado o funci�n para ser evaluado");
	}
}
