package com.analisisnumerico.test;

import com.analisisnumerico.controlador.comando.Limite;
import com.analisisnumerico.controlador.comando.SimpsonSimpleTresCuartos;
import com.analisisnumerico.controlador.comando.util.FuncionConstructor;
import com.analisisnumerico.controlador.comando.util.WolframInvocator;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class TestWAInvocator {

	/**
	 * @param args
	 * @throws MetodoExcepcion 
	 */
	public static void main(String[] args) throws MetodoExcepcion {
		Limite limite = new Limite();
		limite.setValor("-5");
		limite.setParametroFuncion("2");
		limite.setPunto("a");
		Limite limite2 = new Limite();
		limite2.setValor("6");
		limite2.setParametroFuncion("52");
		limite2.setPunto("b");
		
		String funcion = FuncionConstructor.agregarPuntos(SimpsonSimpleTresCuartos.FORMULA, limite, limite2);
		System.out.println("funcion: " + funcion);
		String resultado = WolframInvocator.evaluate(funcion);
		System.out.println("resultado: " + resultado);
	}

}
