package com.personal.calculator.util;

import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.entity.Operator;

public class CommonUtil
{
	/**
	 * separate string into each char string into a list in order from left to right
	 * @param equation / sum
	 * @return list of every char as a vector string
	 */
	public static Vector<String> stringToCharVector(String value)
	{
		char[] charArr = value.toCharArray();
		
		return IntStream.range(0, charArr.length)
                .mapToObj(i -> String.valueOf(charArr[i]))
                .collect(Collectors.toCollection(Vector<String>::new));
	}
	
	/**
	 * identify and collect operators from equations
	 * @param converted equation into vector string
	 * @return list of every supported operator in the equation excluding minus value
	 */
	public static Vector<Operator> extractOperator(Vector<String> vecEquation)
	{
		int index = 0;
		
		Vector<Operator> vecOperator = new Vector();
		
		// identifying operator's location
		for (String s : vecEquation)
		{
			// ignore if first operator is minus
			if (OperatorEnum.get(s) != null)
			{
				// if it is not substraction, add regardless
				if (OperatorEnum.SUBTRACTION != OperatorEnum.get(s))
				{
					vecOperator.add(new Operator(OperatorEnum.get(s), index));
				}
				// negative value handling
				else if (OperatorEnum.SUBTRACTION == OperatorEnum.get(s) && index != 0)
				{
					// if vector is empty
					if (vecOperator.isEmpty())
					{
						vecOperator.add(new Operator(OperatorEnum.get(s), index));
					} else
					{
						// get previous operator to compare the index location
						Operator previousOperator = vecOperator.get(vecOperator.size() - 1);
						if (previousOperator.getOperatorEnum() == OperatorEnum.OPEN_BRACKET 
								|| previousOperator.getOperatorEnum() == OperatorEnum.MULTIPLICATION 
								|| previousOperator.getOperatorEnum() == OperatorEnum.DIVISION 
								|| previousOperator.getOperatorEnum() == OperatorEnum.EXPONENT)
						{
							// if previous index and current index just 1 character behind, ignore the minus
							if (previousOperator.getIndex() - index == -1)
							{
								index++;
								continue;
							} else
							{
								// other than open bracket, multiplication, division and exponent
								// add into operator vector
								vecOperator.add(new Operator(OperatorEnum.get(s), index));
							}
						} else
						{
							// other than open bracket, multiplication, division and exponent
							// add into operator vector
							vecOperator.add(new Operator(OperatorEnum.get(s), index));
						}
					}
				}
			}
			index++;
		}
		
		return vecOperator;
	}
	
	/**
	 * return true if the whole string is numeric, purpose is to validate whether string has operator or just number
	 * @param value
	 * @return true if value is a numeric value, false if it is still an equation exists
	 */
	public static boolean isNumeric(String value)
	{
		try
		{
			Integer.parseInt(value);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
}
