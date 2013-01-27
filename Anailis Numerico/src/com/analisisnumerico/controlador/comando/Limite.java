package com.analisisnumerico.controlador.comando;

import java.math.BigInteger;

public class Limite {
	private boolean inicializado;
	
	private boolean calculado;
	
	private BigInteger valor;
	
	private String funcion;
	
	private BigInteger parametroFuncion;

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public BigInteger getParametroFuncion() {
		return parametroFuncion;
	}

	public void setParametroFuncion(BigInteger paramtroFuncion) {
		this.parametroFuncion = paramtroFuncion;
	}

	public boolean isInicializado() {
		return inicializado;
	}

	public void setInicializado(boolean inicializado) {
		this.inicializado = inicializado;
	}

	public BigInteger getValor() {
		return valor;
	}

	public void setValor(BigInteger valor) {
		this.valor = valor;
	}

	public boolean isCalculado() {
		return calculado;
	}
	
	public void setCalculado(boolean calculado) {
		this.calculado = calculado;
	}
}

