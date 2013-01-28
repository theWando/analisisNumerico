package com.analisisnumerico.controlador.excepciones;

public class MetodoExcepcion extends Exception {

	private static final long serialVersionUID = -8133876580891780772L;

	public MetodoExcepcion() {
		super();
	}

	public MetodoExcepcion(String message) {
		super(message);
	}

	public MetodoExcepcion(Throwable cause) {
		super(cause);
	}

	public MetodoExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

	public MetodoExcepcion(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}