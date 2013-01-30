package com.analisisnumerico.controlador.comando;

import java.math.BigDecimal;
import java.util.List;

import com.analisisnumerico.controlador.comando.util.FuncionConstructor;
import com.analisisnumerico.controlador.comando.util.Util;
import com.analisisnumerico.controlador.excepciones.CalculoExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;


public class TrapecioCompuesto extends MetodoIterativo {

	public static final String FORMULA = "({h}/2)+({Y1}+{Yn} + 2*[SUM:{Yi}])";
	
	public TrapecioCompuesto(String limiteA, String limiteB, int iteraciones, String funcion) {
		this.setLimiteA(new Limite("a", limiteA));
		this.setLimiteB(new Limite("b", limiteB));
		this.setN(iteraciones);
		this.setFuncion(funcion);
	}
	
	@Override
	public BigDecimal calcular() throws MetodoExcepcion {
		if (getTabla() == null || getTabla().isEmpty()) {
			calcularH();
			if (getFuncion() == null)
				throw new CalculoExcepcion("del problema");
		}
		List<BigDecimal> valores = Util.obtenerListaDeHashMap(getTabla());
		String formula = calcularSumatoria((List<BigDecimal>) valores);
		Limite yi = new Limite("Y1", valores.get(0).toPlainString());
		Limite yn = new Limite("Yn", valores.get(valores.size()-1).toPlainString());
		Limite h = new Limite("h", getH().toPlainString());
		String resultado = FuncionConstructor.agregarPuntos(formula, h, yi, yn);
		String evaluado = FuncionConstructor.evaluarCadena(resultado);
		return new BigDecimal(evaluado);
	}
	
	private String calcularSumatoria(List<BigDecimal> valores){
		if(valores != null && !valores.isEmpty()) {
			valores.remove(0);
			valores.remove(valores.size()-1);
			return FuncionConstructor.buscarSuma(FORMULA, valores.toArray());
		}
		return null;
	}

}
