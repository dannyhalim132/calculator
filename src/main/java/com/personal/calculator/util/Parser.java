package com.personal.calculator.util;

public class Parser
{
	/**
	 * parse string into double. will return 0.00 if not valid
	 * @param value
	 * @return
	 */
	public static double parseDouble(String value)
	{
		try
		{
			return Double.parseDouble(value);
		}catch(Exception e)
		{
			return 0.00;
		}
	}
}
