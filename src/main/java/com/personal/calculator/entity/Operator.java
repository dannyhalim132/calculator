package com.personal.calculator.entity;

import com.personal.calculator.constant.OperatorEnum;

public class Operator
{
	private OperatorEnum operatorEnum;
	private int index;

	public Operator(OperatorEnum operatorEnum, int index)
	{
		this.operatorEnum = operatorEnum;
		this.index = index;
	}

	public OperatorEnum getOperatorEnum()
	{
		return operatorEnum;
	}

	public void setOperatorEnum(OperatorEnum operatorEnum)
	{
		this.operatorEnum = operatorEnum;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	@Override
	public String toString()
	{
		return "Operator [operatorEnum=" + operatorEnum + ", index=" + index + "]";
	}
}
