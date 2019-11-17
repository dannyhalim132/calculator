package com.personal.calculator.test;

import org.junit.Test;

import com.personal.calculator.handler.MultiplicationDivisionHandler;

import junit.framework.Assert;

public class MultiplicationDivisionTest
{
	@Test
	public void multiplicationDivisionTest1()
	{
		String sum = "";
		String result = "";

		try
		{
			sum = "1*3";
			result = new MultiplicationDivisionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("3"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void multiplicationDivisionTest2()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "2/4";
			result = new MultiplicationDivisionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("0.5"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void multiplicationDivisionTest3()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "2/-4";
			result = new MultiplicationDivisionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("-0.5"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void multiplicationDivisionTest4()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "2*2/-4";
			result = new MultiplicationDivisionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("-1"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}

	@Test
	public void multiplicationDivisionTest5()
	{
		String sum = "";
		String result = "";
		try
		{
			sum = "-2*2/-4";
			result = new MultiplicationDivisionHandler(sum).calculate();
			Assert.assertEquals(Double.parseDouble("1"), Double.parseDouble(result));
		} catch (Exception e)
		{
			Assert.fail();
		}
	}
}
