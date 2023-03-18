package Practice6;

public class Employee implements Person {
	
	private String name;
	private String email;
	private String department;
	
	Employee() {
		
	}
	
	Employee(String name, String email, String department) {
		this.name = name;
		this.email = email;
		this.department = department;
	}
	
	public String GetDescription() {
		String statement = "Works in the " + this.department + " department";
		return statement.toString();
	}
	
	public String GetName() {
		return this.name;
	}
	
	public String GetEmail() {
		return this.email;
	}
	
	public String GetDepartment() {
		return this.department;
	}

}
