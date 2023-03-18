package Practice6;

public class Student implements Person {
	
	private String grade;
	private String email;
	private String name;
	
	Student(){
		
	}
	
	Student (String name, String email, String grade){
		this.name = name;
		this.email = email;
		this.grade = grade;
	}
	
	public String GetDescription() {
		
		StringBuilder statement = new StringBuilder();
		statement.append("A ");
		statement.append(this.grade);
		statement.append(" grade student");
		
		return statement.toString();
	}
	
	public String GetGrade() {
		return this.grade;
	}
	
	public String GetEmail() {
		return this.email;
	}
	
	public String GetName() {
		return this.name;
	}

}
