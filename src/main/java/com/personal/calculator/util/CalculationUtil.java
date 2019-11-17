package com.personal.calculator.util;

import com.personal.calculator.constant.OperatorEnum;

public class CalculationUtil
{
	/**
	 * calculate addition, subtraction, multiplication, division and exponent between 2 values
	 * @param value1
	 * @param value2
	 * @param operatorEnum
	 * @return
	 * @throws Exception
	 */
	public static String calculate(String value1, String value2, OperatorEnum operatorEnum) throws Exception
	{
		switch(operatorEnum) {
		case ADDITION:
			return String.format("%.4f", Parser.parseDouble(value1) + Parser.parseDouble(value2));
		case SUBTRACTION:
			return String.format("%.4f", Parser.parseDouble(value1) - Parser.parseDouble(value2));
		case MULTIPLICATION:
			return String.format("%.4f", Parser.parseDouble(value1) * Parser.parseDouble(value2));
		case DIVISION:
			return String.format("%.4f", Parser.parseDouble(value1) / Parser.parseDouble(value2));
		case EXPONENT:
			return String.format("%.4f", Math.pow(Parser.parseDouble(value1),Parser.parseDouble(value2)));
		default:
			throw new Exception("Operator not supported");
		}
	}
	/**
	 * formating equation string such as removing spaces, simplifying operators (e.g. -- become +, +- become -)
	 * 
	 * @param equation string
	 * @return simplified string
	 */
	public static String formatEquiation(String equation)
	{
		return equation.replace(" ", "")
				.replace("--", "+")
				.replace("+-", "-")
				.replace("{", "(")
				.replace("[", "(")
				.replace("}", ")")
				.replace("]", ")")
				.replace("x", "*");
	}
}
