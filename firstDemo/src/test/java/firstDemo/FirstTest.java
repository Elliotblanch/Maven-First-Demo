package firstDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Testing is written in Java, using the same rules and codes
// Testing does NOT USE a main method
// Every method labelled as a test will run

public class FirstTest {
	// Test methods don't generally return anything and are generally static
	@Test
	public void printNameTest() {

		// Arrange - pulling all methods / variables needed
		String name = "";

		// Act - Running what we want to test
		name = "Elliot";

		// Assert - Checking if it returned as expected
		Assertions.assertEquals("Elliot", name);

	}

	// Testing if 2 + 2 is equal to 4
	// You are checking if something gives you a value you expect
	// Only test stuff where we can expect a value
	// Changing methods to allow us to expect a value

	// Good practice if test methods end in test, but not always necessary
	@Test // Tell Eclipse that this method is a test
	public void twoPlusTwoTest() {

		// Arrange
		int num1 = 2;
		int num2 = 2;
		int result;

		// Act
		result = num1 + num2;

		// Assert
		Assertions.assertTrue(4 == result);
		Assertions.assertEquals(4, result);
		Assertions.assertNotEquals(200, result);

		Assertions.assertFalse(4 != result); // Testing error messages in methods

	}

	// Test that 5 - 1 = 4
	@Test
	public void subtractTest() {

		// Arrange
		int num1 = 5;
		int num2 = 1;
		int result;

		// Act
		result = num1 - num2;

		// Assert
		Assertions.assertEquals(4, result);

	}

	@Test
	public void multTest() {
		int num1 = 5;
		int num2 = 10;
		int result;

		result = num1 * num2;

		Assertions.assertEquals(50, result);

	}

	@Test
	public void tripleAddTest() {
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int result;

		result = num1 + num2 + num3;

		Assertions.assertEquals(6, result);
	}
	
	@Test
	public void falseTest() {
		int num1 = 20;
		int num2 = 16;
		int result;

		result = num1 - num2;

		Assertions.assertNotEquals(5, result);

	}
	
	@Test
	public void worldTest() {
		String s1 = "Hello";
		String s2 = "world";
		String result;

		result = s1 + " " + s2;

		Assertions.assertEquals("Hello world", result);

	}
	
	@Test
	public void divTest() {
		int num1 = 12;
		int num2 = 4;
		int result;

		result = num1 / num2;

		Assertions.assertEquals(3, result);

	}
	
	@Test
	public void remTest() {
		int num1 = 15;
		int num2 = 4;
		int result;

		result = num1 % num2;

		Assertions.assertEquals(3, result);

	}
	
	public void fruitTest() {
		String fruit1 = "Banana";
		String result;
		
		result = fruit1;
		
		Assertions.assertNotEquals("Mango", result);	
	}
	
	@Test
	public void bracketTest() {
		int num1 = 17;
		int num2 = 2;
		int result;

		result = num1 * num2;

		Assertions.assertTrue(25 < result);
	}
	
	@Test
	public void evenTest() {
		
		// Arrange
		int num = 12;
		String result;
		
		// Act
		if(num % 2 == 0) {
			result = "EVEN";
		} else {
			result = "ODD";
		}
		
		// Assert
		Assertions.assertEquals("EVEN", result);
		
	}
	
public void oddTest() {
		
		// Arrange
		int num = 11;
		String result;
		
		// Act
		if(num % 2 == 0) {
			result = "EVEN";
		} else {
			result = "ODD";
		}
		
		// Assert
		Assertions.assertEquals("ODD", result);
	}

}
