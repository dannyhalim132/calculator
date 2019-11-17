package com.personal.calculator.service;

import com.personal.calculator.handler.AdditionSubtractionHandler;
import com.personal.calculator.handler.BracketHandler;
import com.personal.calculator.handler.ExponentHandler;
import com.personal.calculator.handler.MultiplicationDivisionHandler;
import com.personal.calculator.util.CalculationUtil;

public class CalculatorService
{
	private String equations;
	
	public CalculatorService(String equations)
	{
		this.equations = equations;
	}

	public String calculate()
	{
		try
		{
			this.equations = new BracketHandler(this.equations).calculate();
			this.equations = new ExponentHandler(this.equations).calculate();
			this.equations = new MultiplicationDivisionHandler(this.equations).calculate();
			String result = new AdditionSubtractionHandler(this.equations).calculate();
			return result;
		}catch(Exception e)
		{
			e.printStackTrace();
			return "Exception!";
		}
	}
}