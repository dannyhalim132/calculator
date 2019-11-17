package com.personal.calculator.handler;

import java.util.Vector;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;
import com.personal.calculator.service.CalculatorService;
import com.personal.calculator.util.CalculationUtil;

public class MultiplicationDivisionHandler extends OperationHandler
{
	public MultiplicationDivisionHandler(String equations)
	{
		super(equations);
	}

	@Override
	public String process(Vector<String> vecEquation, Vector<Operator> vecOperator) throws Exception
	{
		// to indicate the last location of the string being calculated
		int stringIndex = 0;
		// to indicate which row of the list in the loop
		int listIndex = 0;
		// to indicate the starting point of value1 for replacement
		int lastMDStringIndex = 0;
		// to indicate the index of the operator to retrieve the value2 for the calculation
		int lastMDOperatorIndex= 0;
				
		// to indicate which operator enum to be used
		OperatorEnum operatorEnum = null;
		
		// to keep track of the accumulative calculation
		String currentValue = "";

		for (Operator operator : vecOperator)
		{
			// if value1 found, retrieve value2 based on last operator location
			if (!"".equals(currentValue))
			{
				// calculate the value
				currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(lastMDOperatorIndex+1, operator.getIndex()), operatorEnum);

				// replace current equation with the result
				// e.g. 1+5*2-3 -> 1+10-3
				this.equations = this.equations.substring(0, lastMDStringIndex) + currentValue + this.equations.substring(operator.getIndex());
				
				// invoke multiplication and division handler again to cater the rest of
				// multiplication and division
				// e.g 1+5*2/2-3
				// 1st invocation -> 1+10/2-3
				// 2nd invocation -> 1+5-3
				// 3rd invocation -> no multiplication and division found, return original
				// equation
				return new CalculatorService(this.equations).calculate();
			}

			// first encounter of the multiplication and division
			if (operator.getOperatorEnum() == OperatorEnum.MULTIPLICATION || operator.getOperatorEnum() == OperatorEnum.DIVISION)
			{
				// get value1 for calculation
				currentValue = this.equations.substring(stringIndex, operator.getIndex());

				// get the current operator for next loop calculation
				operatorEnum = operator.getOperatorEnum();
				lastMDOperatorIndex = operator.getIndex();
				
				// get the starting point to replace
				lastMDStringIndex = stringIndex;
				
				// if last operator is multiplication / division
				// e.g. 1+2-3/2 -> 1+2-1.5
				if (listIndex == vecOperator.size() - 1)
				{
					currentValue = CalculationUtil.calculate(currentValue, this.equations.substring(operator.getIndex() + 1), operatorEnum);
					this.equations = this.equations.substring(0, lastMDStringIndex) + currentValue;
				}
			}

			// next loop starting point to get the number
			stringIndex = operator.getIndex() + 1;
			listIndex++;
		}

		return this.equations;
	}
}
