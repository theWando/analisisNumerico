package com.analisisnumerico.controlador.comando;

public class SimpsonSimpleTresCuartos extends Metodo {

	public static final String FORMULA = "({b} - {a}) * (([b] + 3*((({b} - {a})/3) + {a}) + 3*(((2/3)*({b} - {a})) + {a}) + [a])/8)";
	
	public SimpsonSimpleTresCuartos(){
		super(2);
		this.setFuncion(FORMULA);
	}
}
