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
			String valor = "";
			if(limite.isInicializado()){
				valor = limite.getParametroFuncion().toString();
			}
			funcion = funcion.replace(builder.toString(), valor);
			builder = new StringBuilder();
			builder.append("{");
			builder.append(pos+2);
			builder.append("}");
			valor = "";
			if(limite.isCalculado()){
				valor = limite.getValor().toString();
			}
			funcion = funcion.replace(builder.toString(), valor);
			pos++;
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
