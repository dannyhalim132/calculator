package com.personal.calculator.test;

import org.junit.Test;

import com.personal.calculator.Calculator;

import junit.framework.Assert;

public class InterviewTest
{
	@Test
	public void interviewTest1()
	{
		String sum = "";
		double result = 0.00;

		try
		{
			sum = "1 + 1";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("2"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest2()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "2 * 2";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("4"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest3()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "1 + 2 + 3";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("6"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest4()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "1 + 2 + 3";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("6"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest5()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "6 / 2";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("3"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest6()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "11 + 23";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("34"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest7()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "11.1 + 23";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("34.1"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest8()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "1 + 1 * 3";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("4"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest9()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "( 11.5 + 15.4 ) + 10.1";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("37"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest10()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "23 - ( 29.3 - 12.5 )";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("6.2"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTest11()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "10 - ( 2 + 3 * ( 7 - 5 ) )";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("2"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	// extra testing
	// handle no spaces
	@Test
	public void interviewTestExtra1()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "5--1+2*2/-2+5-2*7";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("-5"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTestExtra2()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "12/2^2-2";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("1"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void interviewTestExtra3()
	{
		String sum = "";
		double result = 0.00;
		try
		{
			sum = "(-4/(2/-2))^2^2+5-3+4/-2+3/2^2-2";
			result = Calculator.calculate(sum);
			Assert.assertEquals(Double.parseDouble("254.75"), result);
		} catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
}
