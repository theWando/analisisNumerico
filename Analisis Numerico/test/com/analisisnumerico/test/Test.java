package com.analisisnumerico.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.analisisnumerico.controlador.comando.Limite;
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
		Limite limite2 = new Limite();
		limite2.setValor("6");
		limite2.setParametroFuncion("52");
		
		String funcion = FuncionConstructor.agregarPuntos("({0} - {1}) - (( {2} + {3})/2)", limite, limite2);
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(funcion);
		System.out.println("Eval: " + engine.eval(funcion));
	}

}
