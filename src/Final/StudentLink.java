package Final;

// Assume students have different names

public class StudentLink {
	
	public String name;
	public double grade;
	public StudentLink next;
	public StudentLink previous;
	
	public StudentLink(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}
	
}
