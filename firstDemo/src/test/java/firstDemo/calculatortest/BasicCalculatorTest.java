package firstDemo.calculatortest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import firstDemo.com.qa.main.calculator.BasicCalculator;

public class BasicCalculatorTest {
	
	// Create a calculator object
	
	BasicCalculator calc = new BasicCalculator();
	
	@Test
	public void addSumTest() {
		
		// Arrange
		int num1 = 7;
		int num2 = 3;
		int num3 = 1;
		String result;
		
		// Act
		result = calc.addSum(num1, num2, num3);

		
		// Assert
		Assertions.assertEquals("7+3+1=11", result);
	}
	@Test
	public void subSumTest() {
		int num1 = 5;
		int num2 = 3;
		String result = calc.subSum(num1, num2);
		Assertions.assertEquals("5-3=2", result);
	}
	
	@Test
	public void multSumTest() {
		int num1 = 3;
		int num2 = 5;
		String result = calc.multSum(num1, num2);
		Assertions.assertEquals("3x5=15", result);
	}
	
	@Test
	public void divSumTest() {
		int num1 = 10;
		int num2 = 2;
		String result = calc.divSum(num1, num2);
		Assertions.assertEquals("10/2=5.0", result);
	}
	
	@Test
	public void squareSumTest() {
		int num1 = 3;
		String result = calc.squareSum(num1);
		Assertions.assertEquals("3²=9", result);
	}
	
	@Test
	public void raisePowerTest() {
		int num1 = 3;
		int num2 = 3;
		int result = calc.raisePower(num1, num2);
		Assertions.assertEquals(27, result);
	}
	
	@Test
	public void oddEvenTest1() {
		String result = calc.oddEven(4);
		
		Assertions.assertEquals("4 is an even number", result);
	}
	
	@Test
	public void oddEvenTest2() {
		String result = calc.oddEven(3);
		
		Assertions.assertEquals("3 is an odd number", result);
	}
	
	
	// Coverage works with lines and isntructions
	// You should aim for 80% coverage, though this will vary
	// Test all methods you wrote
	
	@Test
	public void higherTest() {
		// Arrange
		String result;
		
		
		// Act
		result = calc.higherLower(15);
		
		//Assert
		Assertions.assertEquals("Higher!", result);	
	}
	
	@Test
	public void lowerTest() {
		// Arrange
		String result;
		
		
		// Act
		result = calc.higherLower(6);
		
		//Assert
		Assertions.assertEquals("Lower!", result);	
	}
	
	@Test
	public void equalTest() {
		// Arrange
		String result;
		
		
		// Act
		result = calc.higherLower(10);
		
		//Assert
		Assertions.assertEquals("Equal to 10", result);	
	}
	
	// Example of meaningless test
	@Test
	public void equalTest2() {
		// Inserting random number & doing nothing
		calc.higherLower(32);
		
		// Forcing an assertion of true
		Assertions.assertTrue(true);
		// Important taht tests are meaningful and doing
		// something useful with the data
	}

}
