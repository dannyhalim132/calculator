package com.personal.calculator.handler;

import java.util.Vector;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;
import com.personal.calculator.util.CalculationUtil;
import com.personal.calculator.util.CommonUtil;
import com.personal.calculator.validator.BracketValidator;

public abstract class OperationHandler
{
	protected String equations;
	
	public OperationHandler(String equations)
	{
		this.equations = CalculationUtil.formatEquiation(equations);
	}

	public String calculate() throws Exception
	{
		if(this instanceof BracketHandler)
		{
			BracketValidator.validate(this.equations);
			//if no bracket found, return original equation
			if(!this.equations.contains(OperatorEnum.OPEN_BRACKET.getValue()))
				return this.equations;
		}
		
		if(this instanceof ExponentHandler)
		{
			// if no exponent operator found, return original equation
			if (!this.equations.contains(OperatorEnum.EXPONENT.getValue()))
				return this.equations;
		}
		
		if(this instanceof MultiplicationDivisionHandler)
		{
			// if no multiplication or division operator found, return original equation
			if (!this.equations.contains(OperatorEnum.MULTIPLICATION.getValue()) 
					&& !this.equations.contains(OperatorEnum.DIVISION.getValue()))
				return this.equations;
		}
		
		if(this instanceof AdditionSubtractionHandler)
		{
			// if no multiplication or division operator found, return original equation
			if (!this.equations.contains(OperatorEnum.ADDITION.getValue()) 
					&& !this.equations.contains(OperatorEnum.SUBTRACTION.getValue()))
				return this.equations;
		}
		
		// convert string into String list
		Vector<String> vecEquation = CommonUtil.stringToCharVector(this.equations);
		
		// extract operator from equation
		Vector<Operator> vecOperator = CommonUtil.extractOperator(vecEquation);

		return this.process(vecEquation, vecOperator);
	}
	
	protected abstract String process(Vector<String> vecEquation,Vector<Operator> vecOperator) throws Exception;
}
