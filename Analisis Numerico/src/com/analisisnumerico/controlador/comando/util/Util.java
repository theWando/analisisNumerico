package com.analisisnumerico.controlador.comando.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Util {
	
	public static List<BigDecimal> obtenerListaDeHashMap(HashMap<BigDecimal, BigDecimal> valores) {
		if(valores.isEmpty())
			return null;
		List<BigDecimal> respuesta = new ArrayList<BigDecimal>();
		Iterator<BigDecimal> iterator = valores.values().iterator();
		while (iterator.hasNext()) {
			BigDecimal valor = (BigDecimal)iterator.next();
			respuesta.add(valor);
		}
		return respuesta;
	}

}
