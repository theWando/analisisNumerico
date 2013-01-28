package com.analisisnumerico.controlador.comando;

import java.math.BigDecimal;

public class Limite {
	private boolean inicializado;
	
	private boolean calculado;
	
	private BigDecimal valor;
	
	private String funcion;
	
	private BigDecimal parametroFuncion;
	
	private String punto;

	public String getPunto() {
		return punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public String getFuncion() {
		return funcion;
	}

	/**
	 * Asigna la funcion a evaluar
	 * @param funcion
	 */
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	/**
	 * @return Obtiene el parametro que se evaluar� en la funcion
	 */
	public BigDecimal getParametroFuncion() {
		return parametroFuncion;
	}

	/**
	 * Asigna el valor que esr� evaluado en la funci�n
	 * @param parametroFuncion
	 */
	public void setParametroFuncion(String parametroFuncion) {
		this.inicializado = true;
		this.parametroFuncion = new BigDecimal(parametroFuncion);
	}

	public boolean isInicializado() {
		return inicializado;
	}

	/**
	 * @return el valor resultante de la evaluacion de la funcion
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * Se asing el resultado de la evaluaci�n de la funci�n
	 * @param valor
	 */
	public void setValor(String valor) {
		this.calculado = true;
		this.valor = new BigDecimal(valor);
	}

	public boolean isCalculado() {
		return calculado;
	}
	
}

