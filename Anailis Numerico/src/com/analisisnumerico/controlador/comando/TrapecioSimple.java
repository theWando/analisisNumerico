package com.analisisnumerico.controlador.comando;

import java.math.BigInteger;

import javax.script.ScriptException;

import com.analisisnumerico.controlador.excepciones.LimiteNoInicializadoExcepcion;
import com.analisisnumerico.controlador.excepciones.MetodoExcepcion;

public class TrapecioSimple extends Metodo {

	public TrapecioSimple() {
		super(2);
		this.setFuncion("({0} - {1}) - (( {2} + {3})/2)");
	}

	@Override
	public BigInteger calcular() throws MetodoExcepcion {
		if(getLimites() == null && getLimites().isEmpty()){
			throw new LimiteNoInicializadoExcepcion();
		}
		try {
			this.getScript().eval(getFuncion());
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
