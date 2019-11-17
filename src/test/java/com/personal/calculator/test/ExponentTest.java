package com.personal.calculator.test;

import org.junit.Test;

import com.personal.calculator.handler.ExponentHandler;

import junit.framework.Assert;

public class ExponentTest
{
	@Test
	public void exponentTest1()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "2^2";
			result = new ExponentHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("4"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void exponentTest2()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "2^2^2";
			result = new ExponentHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("16"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void exponentTest3()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "2^-2";
			result = new ExponentHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("0.25"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
}
