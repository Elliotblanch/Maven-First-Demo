package jdbcDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// Serves a similar purpose to Garage, used for methods
public class Cafe {

	// ArrayList not needed, as database will be storing data
	
	Statement stmt = null; // Import java.sql
	Connection conn = null;
	
	JDBCDemo db = new JDBCDemo(); // making object
	
	// method to add drink to database
	public void addDrink(Drink drink) {
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			// The SQL query we are putting into our database
			String query = "INSERT INTO drinks(type, size, dairyfree, cost) VALUES ('"+ drink.getType() + "', '"+ drink.getSize()+"', "+ drink.isDairyFree() +", "+ drink.getCost() +");";
			System.out.println(query);
			stmt.executeUpdate(query); // pass in our SQL query into stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	// Viewing the data in our database in Java
	// SELECT * FROM drinks in SQL, need equivalent for Java
	public Drink getDrinkById(int id) {
		try {
			
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks WHERE id = " + id; // returns an object of type ResultSet
			ResultSet results =stmt.executeQuery(query); 
			results.next(); // moves the selection cursor down to the next row
			System.out.println(results); // need to convert to a useful object
			Drink drinkResult = modelDrink(results);
			return drinkResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Drink> getAllDrinks() {
		ArrayList<Drink> resultList = new ArrayList<>();
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks";
			ResultSet results = stmt.executeQuery(query);
			
			// While there is another row below this, keep going
			while (results.next()) {
				// Return the current row as a Drink object, add it to this arraylist
				resultList.add(modelDrink(results));
			}
			return resultList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Drink> getDrinkByQuery(String condition) {
		ArrayList<Drink> resultList = new ArrayList<>();
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks WHERE " + condition;
			ResultSet results = stmt.executeQuery(query);
			
			while (results.next()) {
				resultList.add(modelDrink(results));
			}
			return resultList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// Will return a drink from a drink ResultSet
	public Drink modelDrink(ResultSet result) {
		try {
			int id = result.getInt(1); //pass in the column number (1-5)
			String type = result.getString("type"); // pass in the column name (type, size)
			String size = result.getString("size");
			boolean bool = result.getBoolean("dairyFree");
			float cost = result.getFloat("cost");
			
			// Make a new Drink object
			Drink drink = new Drink(id, type, size, bool, cost);
			return drink;
					
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Prepared Statements:
	// We create a statement Object which contains a query, then run the statement
	
	// Pass In ? in place of data in our queries - WHERE " + term + " =...
	// WHERE size = ? (Change ? to be any value)
	
	public int deleteDrinkById(int id) {
		try {
			conn = db.connect();
			String query = "DELETE FROM drinks WHERE id = ?";
			PreparedStatement preStmt = conn.prepareStatement(query);
			// set the value of ?, you can have as many ? as  you want, they index from 1
			preStmt.setInt(1, id); // The first ? = id
			return preStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	
	public Drink updateDrinkById(Drink drink, int id) {
		try {
			conn = db.connect();
			String query = "UPDATE drinks SET type = ?, size =?, dairyFree = ?, cost = ? WHERE id = ?";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, drink.getType());
			preStmt.setString(1, drink.getSize());
			preStmt.setBoolean(3, drink.isDairyFree());
			preStmt.setFloat(4, drink.getCost());
			preStmt.setInt(5, id);
			preStmt.executeUpdate(); // If you're getting data - query
									 // Otherwise it's an update (Create, Update, Delete)
			return getDrinkById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
}
