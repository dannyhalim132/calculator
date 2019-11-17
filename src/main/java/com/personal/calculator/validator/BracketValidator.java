package com.personal.calculator.validator;

import java.util.Stack;

import com.personal.calculator.constant.OperatorEnum;
import com.personal.calculator.util.CommonUtil;

public class BracketValidator
{
	public static void validate(String equations) throws Exception
	{

		Stack<String> bracketStack = new Stack<String>();

		if (equations.contains(OperatorEnum.CLOSE_BRACKET.getValue()) || equations.contains(OperatorEnum.OPEN_BRACKET.getValue()))
		{
			int index = 0;
			// for every open bracket, put into stack
			// for every close bracket:
			// check if stack was empty, then close bracket is invalid
			// check if stack consist of value, then pop the last added bracket
			for (String s : CommonUtil.stringToCharVector(equations))
			{
				if (null != OperatorEnum.get(s))
				{
					switch (OperatorEnum.get(s))
					{
					case OPEN_BRACKET:
						bracketStack.add(s);
						break;
					case CLOSE_BRACKET:
						if (bracketStack.isEmpty())
							throw new Exception("invalid bracketing format [)] at index:" + (index+1));
						else
							bracketStack.pop();
						break;
					}
				}
				index++;
			}

			if (!bracketStack.isEmpty())
				throw new Exception("invalid bracketing format, missing close bracket.");
		}
	}
}
