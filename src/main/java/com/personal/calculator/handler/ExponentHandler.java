package com.personal.calculator.handler;

import java.util.Vector;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;
import com.personal.calculator.util.CalculationUtil;

public class ExponentHandler extends OperationHandler
{
	public ExponentHandler(String equations)
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
		//to indicate the starting point of value1 for replacement
		int lastEStringIndex = 0;
		
		//to indicate which operator enum to be used
		OperatorEnum operatorEnum = null;
		
		//to keep track of the accumulative calculation
		String currentValue = "";
		
		for(Operator operator : vecOperator)
		{
			//if value1 found, retrieve value2 based on last operator location
			if(!"".equals(currentValue))
			{
				//calculate the value
				currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(stringIndex,operator.getIndex()), operatorEnum);
				
				//replace current equation with the result
				this.equations = this.equations.substring(0,lastEStringIndex)+currentValue+this.equations.substring(operator.getIndex());
				
				//invoke Exponent handler again to cater the rest of exponent
				return new ExponentHandler(this.equations).calculate();
			}
			
			if(operator.getOperatorEnum() == OperatorEnum.EXPONENT)
			{
				//get value1 for calculation
				currentValue = this.equations.substring(stringIndex,operator.getIndex());
				
				//get the current operator for next loop calculation
				operatorEnum = operator.getOperatorEnum();
				//get the starting point to replace 
				lastEStringIndex = stringIndex;
				
				//if last operator is exponent
				if(listIndex == vecOperator.size()-1)
				{
					currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(operator.getIndex()+1), operatorEnum);
					this.equations = this.equations.substring(0,lastEStringIndex)+currentValue;
				}
			}
			
			//next loop starting point to get the number
			stringIndex = operator.getIndex()+1;
			listIndex++;
		}

		return this.equations;
	}
}
