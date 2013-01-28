package com.analisisnumerico.controlador.comando;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public abstract class Metodo {
	private List<Limite> limites;
	
	private int puntos;
	
	private String funcion;
	
	private ScriptEngine script;
	
	private BigDecimal resultado;

	public BigDecimal getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = new BigDecimal(resultado);
	}

	public Metodo(int puntos){
		this.limites = new ArrayList<>();
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    this.script = mgr.getEngineByName("JavaScript");
	    
		this.puntos = puntos;
	}
	
	public ScriptEngine getScript() {
		return script;
	}
	public void agregarPunto(Limite limite) {
		limites.add(limite);
	}

	public abstract BigInteger calcular() throws MetodoExcepcion;
	
	public List<Limite> getLimites() {
		return limites;
	}
	public int getPuntos() {
		return puntos;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
}