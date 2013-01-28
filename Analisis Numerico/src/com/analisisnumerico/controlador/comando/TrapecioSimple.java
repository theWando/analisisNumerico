package com.analisisnumerico.controlador.comando;


public class TrapecioSimple extends Metodo {

	
	public static final String FORMULA = "({a} - {b}) - (([a] + [b])/2)";

	public TrapecioSimple() {
		super(2);
		this.setFuncion(FORMULA);
	}
}
