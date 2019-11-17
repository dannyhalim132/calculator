package com.personal.calculator.test;

import org.junit.Test;

import com.personal.calculator.handler.BracketHandler;

import junit.framework.Assert;

public class BracketTest
{
	@Test
	public void bracketTest1()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "(2+2)";
			result = new BracketHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("4"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void bracketTest2()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "(2*(10/2))";
			result = new BracketHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("10"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void bracketTest3()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "(2*(10+2))";
			result = new BracketHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("24"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void bracketTest4Exception()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "(2*(10+2)";
			result = new BracketHandler(sum).calculate();
			Assert.fail("invalid bracket combination");
		} catch (Exception e)
		{
			// expected due to invalid bracket combination
		}
	}

	@Test
	public void bracketTest5()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "(2*(10+2))/2";
			result = new BracketHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("12"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
}
