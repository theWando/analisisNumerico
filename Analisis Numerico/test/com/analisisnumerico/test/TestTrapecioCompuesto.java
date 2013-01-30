package com.analisisnumerico.test;

import java.math.BigDecimal;

import com.analisisnumerico.controlador.comando.TrapecioCompuesto;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class TestTrapecioCompuesto {
	public static void main(String[] args) throws MetodoExcepcion {
		TrapecioCompuesto t = new TrapecioCompuesto("1", "2", 5, "sin({x})/2");
		BigDecimal resultado = t.calcular();
		System.out.println(resultado);
	}
}
