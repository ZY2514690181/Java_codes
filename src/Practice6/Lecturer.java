package Practice6;

public class Lecturer implements Person {
	
	private String name;
	private String email;
	private String subject;
	
	Lecturer(){
		
	}
	
	Lecturer (String name, String email, String subject) {
		this.name = name;
		this.email = email;
		this.subject = subject;
	}
	
	public String GetDescription() {
		StringBuilder statement = new StringBuilder();
		statement.append("Teacher ");
		statement.append(this.subject);
		return statement.toString();
	}
	
	public String GetEmail() {
		return this.email;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public String GetSubject() {
		return this.subject;
	}

}
