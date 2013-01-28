package com.analisisnumerico.controlador.excepciones;

public class LimiteNoInicializadoExcepcion extends MetodoExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7476544458091154817L;
	
	public LimiteNoInicializadoExcepcion(){
		super("Uno de los límites del método no ha sido inicializado");
	}

}
