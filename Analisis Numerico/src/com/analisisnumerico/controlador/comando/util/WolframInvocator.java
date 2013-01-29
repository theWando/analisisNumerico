package com.analisisnumerico.controlador.comando.util;

import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;
import com.analisisnumerico.controlador.excepciones.WAExcepcion;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class WolframInvocator {

	private static final String API_KEY = "3KEKLK-GVJTEP28YK";
	
	public static String invoke(final String function) throws MetodoExcepcion {
		String valor = "";
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
					podLabel: for (WAPod pod : resultado.getPods()) {
						if (!pod.isError()) {
							if(!pod.getTitle().matches("Decimal form")){
								continue;
							}
							for (WASubpod subpod : pod.getSubpods()) {
								for (Object element : subpod.getContents()) {
									if (element instanceof WAPlainText) {
										valor = ((WAPlainText) element).getText();
										break podLabel;
									}
								}
							}
						}
					}
					if(valor.indexOf("=") != -1){
						valor = valor.substring(valor.indexOf("=")+1);
					}
				}
			} catch (WAException e) {
				throw new WAExcepcion(e.getCause());
			}
		}
		return valor;
	}
}
