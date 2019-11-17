package com.personal.calculator.handler;

import java.util.Vector;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;
import com.personal.calculator.service.CalculatorService;
import com.personal.calculator.util.CommonUtil;

public class BracketHandler extends OperationHandler
{
	public BracketHandler(String equations)
	{
		super(equations);
	}

	@Override
	public String process(Vector<String> vecEquation, Vector<Operator> vecOperator) throws Exception
	{
		//opening and closing bracket index
		Integer openBracketIndex = null;
		Integer closeBracketIndex = null;
		
		int i = 0 ;

		for(Operator operator : vecOperator)
		{
			//to find opening bracket and closing bracket location
			if(operator.getOperatorEnum() == OperatorEnum.OPEN_BRACKET)
				openBracketIndex = operator.getIndex();
			else if(operator.getOperatorEnum() == OperatorEnum.CLOSE_BRACKET)
				closeBracketIndex = operator.getIndex();
			
			//if found a set of opening and closing bracket, process bracket
			if(null != openBracketIndex && null != closeBracketIndex)
			{
				//this will be true if value is only numeric.
				//true scenario (-4) or (3.25) or (4.000)
				//false if operator still detected in the equations
				if(CommonUtil.isNumeric(this.equations.substring(openBracketIndex+1,closeBracketIndex)))
				{					
					String result = this.equations.substring(openBracketIndex+1,closeBracketIndex);
					return this.equations.substring(0,openBracketIndex) + result + this.equations.substring(closeBracketIndex+1);
				}else
				{
					// if substring value still consist of equations
					String result = new CalculatorService(this.equations.substring(openBracketIndex+1,closeBracketIndex)).calculate();
					this.equations = this.equations.substring(0,openBracketIndex) + result + this.equations.substring(closeBracketIndex+1);
					return new CalculatorService(this.equations).calculate();
				}
			}
		}

		return this.equations;
	}
}
