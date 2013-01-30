package com.analisisnumerico.controlador.comando.util;

import java.util.regex.Matcher;

import com.analisisnumerico.controlador.excepciones.WAExcepcion;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class WolframInvocator {

	private static final String DERIVATE = "Derivative";
	private static final String RESULTADO = "Decimal form|Result";
	private static final String API_KEY = "3KEKLK-GVJTEP28YK";
	
	private static WAQueryResult invoke(final String function) throws WAExcepcion {
		if (function != null && !function.trim().isEmpty() ) {
			try {
				WAEngine engine = new WAEngine();
				engine.setAppID(API_KEY);
				engine.addFormat("plaintext");
				
				WAQuery query = engine.createQuery();
				query.setInput(function);
				
				WAQueryResult resultado = engine.performQuery(query);
				if (resultado.isError()) {
					throw new WAExcepcion(resultado.getErrorCode(), resultado.getErrorMessage());
				} else if (!resultado.isSuccess()) {
					throw new WAExcepcion();
				} else if (resultado.isSuccess()){
					return resultado;
				}
			} catch (WAException e) {
				throw new WAExcepcion(e.getCause());
			}
		}
		return null;
	}

	public static String evaluate(final String funcion) throws WAExcepcion {
		WAQueryResult resultado = invoke(funcion);
		String valor = null;
		if (resultado != null) {
			valor = obtenerPodDeseado(resultado, RESULTADO);
		}
		return valor;
	}

	private static String obtenerPodDeseado(WAQueryResult resultado, final String form) {
		for (WAPod pod : resultado.getPods()) {
			if (!pod.isError()) {
				if (!pod.getTitle().matches(form)) {
					continue;
				}
				for (WASubpod subpod : pod.getSubpods()) {
					for (Object element : subpod.getContents()) {
						if (element instanceof WAPlainText) {
							String valor = ((WAPlainText) element).getText();
							if (valor.indexOf("=") != -1) {
								valor = valor.substring(valor.indexOf("=") + 1);
							}
							Matcher m = FuncionConstructor.getMatcher("\\.+$", valor);
							if (m.find()) {
								return m.replaceAll("");
							} else {
								return valor;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static String derivate(final String funcion) throws WAExcepcion {
		WAQueryResult resultado = invoke(funcion);
		String valor = null;
		if (resultado != null) {
			valor = obtenerPodDeseado(resultado, DERIVATE);
		}
		return valor;
	}
}
