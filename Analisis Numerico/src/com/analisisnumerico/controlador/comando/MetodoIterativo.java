package com.analisisnumerico.controlador.comando;

import java.math.BigDecimal;
import java.util.HashMap;

import com.analisisnumerico.controlador.comando.util.FuncionConstructor;
import com.analisisnumerico.controlador.comando.util.WolframInvocator;
import com.analisisnumerico.controlador.excepciones.LimiteNoInicializadoExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public abstract class MetodoIterativo extends Metodo {
	
	private static final String FORMULA_H = "({b} - {a})/{n}";

	private int n;
	
	private BigDecimal h;
	
	private Limite limiteA;
	
	private Limite limiteB;
	
	private String funcion;
	
	private HashMap<BigDecimal, BigDecimal> tabla;
	
	public Limite getLimiteA() {
		return limiteA;
	}

	public void setLimiteA(Limite limiteA) {
		this.limiteA = limiteA;
	}

	public Limite getLimiteB() {
		return limiteB;
	}

	public void setLimiteB(Limite limiteB) {
		this.limiteB = limiteB;
	}

	
	public abstract BigDecimal calcular() throws MetodoExcepcion;
	
	protected String calcularH(Limite limiteA, Limite limiteB, int n) throws MetodoExcepcion{
		this.limiteA = limiteA;
		this.limiteB = limiteB;
		this.n = n;
		return calcularH();
	}
	
	protected String calcularH() throws MetodoExcepcion {
		String hCalculada = null;
		if(limiteA == null || limiteB == null || n == 0)
			throw new LimiteNoInicializadoExcepcion();
		String stringN = Integer.toString(n);
		Limite n = new Limite("n", stringN);
		String formulaConstruida = FuncionConstructor.agregarPuntos(FORMULA_H, limiteA, limiteB, n);
		hCalculada = FuncionConstructor.evaluarCadena(formulaConstruida);
		this.h = new BigDecimal(hCalculada);
		this.llenarTabla();
		return hCalculada;
	}
	
	private void llenarTabla() throws MetodoExcepcion{
		float a = limiteA.getParametroFuncion().floatValue();
		float b = limiteB.getParametroFuncion().floatValue();
		tabla = new HashMap<BigDecimal, BigDecimal>();
		for(float i = a; i <= b; i = i + this.h.floatValue()){
			String funcion = FuncionConstructor.agregarPuntos(this.funcion, new Limite("x", Float.toString(i)));
			String funcionEvaluada = WolframInvocator.evaluate(funcion);
			BigDecimal resultadoFuncion = new BigDecimal(funcionEvaluada);
			tabla.put(new BigDecimal(i), resultadoFuncion);
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public BigDecimal getH() {
		return h;
	}

	public void setH(BigDecimal h) {
		this.h = h;
	}

	public HashMap<BigDecimal, BigDecimal> getTabla() {
		return tabla;
	}

	public void setTabla(HashMap<BigDecimal, BigDecimal> tabla) {
		this.tabla = tabla;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

}
