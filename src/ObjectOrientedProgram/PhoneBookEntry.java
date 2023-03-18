package ObjectOrientedProgram;

public class PhoneBookEntry {
	
	// member variables
	
	private String lastName;
	private String firstName;
	private int number;
	
	// constructor: it is a method that will allow you to
	// create instances (objects)
	
	public PhoneBookEntry(String fn, String ln, int num)
	{
		firstName = fn;
		lastName = ln;
		number = num;
	}
	
	// Getters and setters (these methods that will allow you to
	// set or get the member variables.)
	
	public String getLastName() {
		
		return lastName;
	}
	
	public String getfirstName() {
		
		return firstName;
	}
	
	public int getnumber() {
		
		return number;
	}
	
	public void setFirstName(String L)
	{
		firstName = L;
	}

	public void setLastName(String L)
	{
		lastName = L;
	}
	
	public void setNumber(int n)
	{
		number = n;
	}
	
	// other methods

}
