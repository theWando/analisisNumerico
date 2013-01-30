package com.analisisnumerico.controlador.comando;

import java.math.BigDecimal;

import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;


public class TrapecioCompuesto extends MetodoIterativo {

	public static final String FORMULA = "([h]/2)+([Y1]+[Yn] + 2*[SUM:{Yi}])";
	
	@Override
	public BigDecimal calcular() throws MetodoExcepcion {
		calcularH();
		return null;
	}

}
