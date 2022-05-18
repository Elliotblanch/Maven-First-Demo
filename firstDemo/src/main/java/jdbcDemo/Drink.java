package jdbcDemo;

public class Drink {
	
	// JDBC will be creating a Drinks table
	// We need a Primary key
	// When insterting data into a database, MySQL will generate a primary key value for us
	// Auto incrementing id
	
	//Fields
	private int id;
	private String type;
	private String size;
	private boolean dairyFree;
	private float cost;
	
	// Constructor - For pushing data into the database (No id)
	public Drink(String type, String size, boolean dairyFree, float cost) {
		super();
		this.type = type;
		this.size = size;
		this.dairyFree = dairyFree;
		this.cost = cost;
	}
	
	//Overloading - multiple constructors (with different parameters) in one class
	//Constructor - Getting data out of the database (Has an id)
	public Drink(int id, String type, String size, boolean dairyFree, float cost) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.dairyFree = dairyFree;
		this.cost = cost;
	}

	// Getters & Setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isDairyFree() {
		return dairyFree;
	}
	public void setDairyFree(boolean dairyFree) {
		this.dairyFree = dairyFree;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Drink [type=" + type + ", size=" + size + ", dairyFree=" + dairyFree + ", cost=" + cost + "]";
	}

}
