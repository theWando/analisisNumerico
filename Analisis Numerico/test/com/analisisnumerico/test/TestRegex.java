package com.analisisnumerico.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.analisisnumerico.controlador.comando.TrapecioCompuesto;

@SuppressWarnings("unused")
public class TestRegex {

	private static final String REGEX = "(SUM:)(\\{)([A-Z+][a-z+])(\\})";
	private static final String WA = "Decimal form|Result";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Pattern r = Pattern.compile("Yi");
		 Matcher m = r.matcher(TrapecioCompuesto.FORMULA);
		 if(m.find()){
			System.out.println(m.group(0));
		 }

	}

}
