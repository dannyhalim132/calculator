package com.personal.calculator.test;

import org.junit.Test;

import com.personal.calculator.Calculator;
import com.personal.calculator.handler.AdditionSubtractionHandler;

import junit.framework.Assert;

public class AdditionSubtractionTest
{
	@Test
	public void additionSubtractionTest1()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "1+1";
			result = new AdditionSubtractionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("2"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void additionSubtractionTest2()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "2-1";
			result = new AdditionSubtractionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("1"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void additionSubtractionTest3()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "1+1-3";
			result = new AdditionSubtractionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("-1"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void additionSubtractionTest4()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "1+-3";
			result = new AdditionSubtractionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("-2"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void additionSubtractionTest5()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "1--3";
			result = new AdditionSubtractionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("4"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}
}
