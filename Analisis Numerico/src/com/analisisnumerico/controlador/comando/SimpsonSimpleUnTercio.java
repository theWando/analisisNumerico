package com.analisisnumerico.controlador.comando;


public class SimpsonSimpleUnTercio extends Metodo {
	
	public static final String FORMULA = "(({b} - {a})/{b}) * ([a] +4*(({a} + {b})/2) + [b])";

	public SimpsonSimpleUnTercio(){
		super(2);
		this.setFuncion(FORMULA);
	}
}
