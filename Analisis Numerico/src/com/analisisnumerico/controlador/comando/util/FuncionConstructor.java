package com.analisisnumerico.controlador.comando.util;

import com.analisisnumerico.controlador.comando.Limite;
import com.analisisnumerico.controlador.excepciones.LimiteNoInicializadoExcepcion;
import com.analisisnumerico.controlador.excepciones.LimiteSinEvaluacionExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class FuncionConstructor {

	public static String agregarPuntos(String funcion, Limite... limites) throws MetodoExcepcion {
		if (funcion.indexOf("{") != -1) {
			for (Limite limite : limites) {
				validarLimite(limite);
				funcion = buildParameter(funcion, limite);
				funcion = buildFunction(funcion, limite);
			}
		}
		return funcion;
		
	}

	private static String buildFunction(String funcion, Limite limite) {
		if (funcion.indexOf("[") != -1) {
			StringBuilder builder = new StringBuilder();
			builder = new StringBuilder();
			builder.append("[");
			builder.append(limite.getPunto());
			builder.append("]");
			String valor = "";
			if (limite.isCalculado()) {
				valor = limite.getValor().toString();
			} else if (!limite.isCalculado() && limite.getFuncion() != null) {
				
			}
			funcion = funcion.replace(builder.toString(), valor);
		}
		return funcion;
	}

	private static String buildParameter(String funcion, Limite limite) {
		if (funcion.indexOf("{") != -1) {
			StringBuilder builder = new StringBuilder();
			builder.append("{");
			builder.append(limite.getPunto());
			builder.append("}");
			String valor = "";
			if (limite.isInicializado()) {
				valor = limite.getParametroFuncion().toString();
			}
			funcion = funcion.replace(builder.toString(), valor);
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
		if((limite.getValor() == null && limite.getFuncion() == null)|| limite.getParametroFuncion() == null)
			throw new LimiteSinEvaluacionExcepcion();
	}
}
