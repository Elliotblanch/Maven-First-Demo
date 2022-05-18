package jdbcDemo;

public class JDBCRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create my JDBC Demo Object
		JDBCDemo jdbc = new JDBCDemo();
		
		// Create our Cafe object
		Cafe newCafe = new Cafe();
		
		Drink latte = new Drink("latte", "large", true, 1.50f);
		Drink mocha = new Drink("mocha", "medium", false, 3.75f);
		
//		newCafe.addDrink(latte);
//		newCafe.addDrink(mocha);
		System.out.println(newCafe.getDrinkById(1));
		System.out.println(newCafe.getDrinkById(2));
		System.out.println("==================");
		System.out.println(newCafe.getAllDrinks());
		System.out.println(newCafe.getDrinkByQuery("cost = 1.5"));

	}

}
