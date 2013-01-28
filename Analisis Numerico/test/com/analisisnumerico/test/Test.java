package com.analisisnumerico.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.analisisnumerico.controlador.comando.Limite;
import com.analisisnumerico.controlador.comando.SimpsonSimpleTresCuartos;
import com.analisisnumerico.controlador.comando.SimpsonSimpleUnTercio;
import com.analisisnumerico.controlador.comando.util.FuncionConstructor;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class Test {

	/**
	 * @param args
	 * @throws MetodoExcepcion 
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws MetodoExcepcion, ScriptException {
		Limite limite = new Limite();
		limite.setValor("-5");
		limite.setParametroFuncion("2");
		limite.setPunto("a");
		Limite limite2 = new Limite();
		limite2.setValor("6");
		limite2.setParametroFuncion("52");
		limite2.setPunto("b");
		
		String funcion = FuncionConstructor.agregarPuntos(SimpsonSimpleTresCuartos.FORMULA, limite, limite2);
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(funcion);
		System.out.println("Eval: " + engine.eval(funcion));
	}

}
