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
		 Pattern r = Pattern.compile("(SUM:)(\\{)([A-Z+][a-z+])(\\})");
		 Matcher m = r.matcher(TrapecioCompuesto.FORMULA);
		 if(m.find()){
			String group = m.group(0);
			Pattern r1 = Pattern.compile("Yi");
			Matcher m1 = r1.matcher(group);
			System.out.println(group);
			System.out.println(m1.find());
			System.out.println(m1.group(0));
		 }

	}

}
