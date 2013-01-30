package com.analisisnumerico.controlador.comando.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.analisisnumerico.controlador.comando.Limite;
import com.analisisnumerico.controlador.excepciones.LimiteNoInicializadoExcepcion;
import com.analisisnumerico.controlador.excepciones.LimiteSinEvaluacionExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;
import com.analisisnumerico.controlador.excepciones.WAExcepcion;

public class FuncionConstructor {
	
	private static final String SUMATORIA = "(SUM:)(\\[)([A-Z+][a-z+])(\\])";
	
	public static String agregarPuntos(String funcion, List<Limite> limites) throws MetodoExcepcion{
		return agregarPuntos(funcion, (Limite[])limites.toArray());
	}
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

	private static String buildFunction(String funcion, Limite limite) throws MetodoExcepcion {
		if (funcion.indexOf("[") != -1) {
			String valor = "";
			if (limite.isCalculado()) {
				valor = limite.getValor().toString();
			} else if (!limite.isCalculado() && limite.getFuncion() != null) {
				return evaluarFuncion(limite);
			}
			funcion = reemplazar(funcion, "\\["+limite.getPunto()+"\\]", valor);//funcion.replace(builder.toString(), valor);
		}
		return funcion;
	}
	
	/**
	 * Evalua la función, si ocasiona un error lo envía a wolfram alpha para intentar resolverlo
	 * @param limite
	 * @return
	 * @throws WAExcepcion
	 */
	private static String evaluarFuncion(Limite limite) throws WAExcepcion {
		return evaluarCadena(limite.getFuncion());
	}
	
	public static String evaluarCadena(String funcion) throws WAExcepcion {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			return (String) engine.eval(funcion);
		} catch (ScriptException e) {
			return WolframInvocator.evaluate(funcion);
		}
	}

	private static String buildParameter(String funcion, Limite limite) {
		if (funcion.indexOf("{") != -1) {
			String valor = "";
			if (limite.isInicializado()) {
				valor = limite.getParametroFuncion().toString();
				funcion = reemplazar(funcion, "\\{"+limite.getPunto()+"\\}", valor);//funcion.replace(builder.toString(), valor);
			}
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
	
	public static String buscarSuma(String funcion, BigDecimal... valores){
		Matcher m = getMatcher(SUMATORIA, funcion);
		if(m.find()){
			String suma = m.group(0);
			BigDecimal resultado = new BigDecimal("0");
			for (BigDecimal bigDecimal : valores) {
				resultado.add(bigDecimal);
			}
			String sumaTXT = getMatcher("Yi", suma).group(0);
			String sumaCalculada = buildParameter(sumaTXT, new Limite("Yi", resultado.toPlainString()));
			return m.replaceFirst(sumaCalculada);
		}
		return null;
	}
	
	private static String reemplazar(final String funcion, final String variable, final String reemplazo) {
		Matcher m = getMatcher(variable, funcion);
		 if(m.find()){
			return m.replaceAll(reemplazo);
		 }
		 return funcion;
	}
	
	private static Matcher getMatcher(final String patron,final String objetivo) {
		Pattern r = Pattern.compile(patron);
		 Matcher m = r.matcher(objetivo);
		return m;
	}
}
