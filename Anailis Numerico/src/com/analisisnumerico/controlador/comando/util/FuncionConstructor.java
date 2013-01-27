package com.analisisnumerico.controlador.comando.util;

import com.analisisnumerico.controlador.comando.Limite;
import com.analisisnumerico.controlador.excepciones.LimiteNoInicializadoExcepcion;
import com.analisisnumerico.controlador.excepciones.LimiteSinEvaluacionExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class FuncionConstructor {

	public static String agregarPuntos(String funcion, Limite... limites) throws MetodoExcepcion {
		int pos = 0;
		for (Limite limite : limites) {
			validarLimite(limite);
			StringBuilder builder = new StringBuilder();
			builder.append("{");
			builder.append(pos);
			builder.append("}");
			funcion.replace(builder.toString(), funcion);
		}
		return funcion;
		
	}

	/**
	 * Valida si el limite tiene alguno de sus elementos escenciales nulos
	 * @param limite
	 * @throws LimiteNoInicializadoExcepcion
	 * @throws LimiteSinEvaluacionExcepcion
	 */
	private static void validarLimite(Limite limite) throws LimiteNoInicializadoExcepcion, LimiteSinEvaluacionExcepcion {
		if(limite == null)
			throw new LimiteNoInicializadoExcepcion();
		if(limite.getValor() == null || limite.getFuncion() == null || limite.getParametroFuncion() == null)
			throw new LimiteSinEvaluacionExcepcion();
	}
}
