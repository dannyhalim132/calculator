package com.personal.calculator.handler;

import java.util.Vector;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;
import com.personal.calculator.util.CalculationUtil;

public class AdditionSubtractionHandler extends OperationHandler
{
	public AdditionSubtractionHandler (String equations)
	{
		super(equations);
	}

	@Override
	public String process(Vector<String> vecEquation, Vector<Operator> vecOperator) throws Exception
	{
		//to indicate the last location of the string being calculated
		int stringIndex = 0;
		//to indicate which row of the list in the loop
		int listIndex = 0;
		//to indicate which operator enum to be used
		OperatorEnum operatorEnum = null;
		
		//to keep track of the accumulative calculation
		String currentValue = "";
		
		//return the equations if no operator found
		//this will be hit if there were no addition or subtraction in the original equation
		//e.g. -2 only or -3
		if(vecOperator.isEmpty())
			return this.equations;
		
		//begin calculation
		for(Operator operator : vecOperator)
		{
			//if string index is 0, we took the first number as the current total
			if(stringIndex == 0)
				currentValue = this.equations.substring(0,operator.getIndex());
			//begin calculation from first of the list until the last of the list
			else
				currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(stringIndex,operator.getIndex()), operatorEnum);
			
			//to calculate the last value upon reaching the end of the list
			if(listIndex == vecOperator.size()-1 && !"".equals(currentValue))
				currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(operator.getIndex()+1), operator.getOperatorEnum());

			//update counter
			operatorEnum = operator.getOperatorEnum();
			stringIndex = operator.getIndex()+1;
			listIndex++;
		}
		
		return currentValue;
	}
}
