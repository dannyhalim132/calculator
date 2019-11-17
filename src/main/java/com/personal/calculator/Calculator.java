package com.personal.calculator;

import java.util.Scanner;

import com.personal.calculator.service.CalculatorService;

public class Calculator
{
	public static void main(String args[])
	{
		System.out.println("============================");
		System.out.println("# Input 0 to exit!");
		System.out.println("============================");

		while (true)
		{
			// request for system input
			System.out.print("Enter an operation: ");
			String input = new Scanner(System.in).nextLine();

			// since it is infinity loop, 0 is the exit keyword that user could input to
			// break the loop
			if (input.equals("0"))
				break;

			// begin calculation
			try
			{
				System.out.println("result :" + Calculator.calculate(input));
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		// system exiting
		System.out.println("Thank you! System exiting.... ");
		System.exit(0);
	}

	public static double calculate(String sum)
	{
		try
		{
			return Double.parseDouble(new CalculatorService(sum).calculate());
		}catch(Exception e)
		{
			throw new ArithmeticException(e.getMessage());
		}
	}
}
