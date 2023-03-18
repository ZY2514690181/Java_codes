package Final;

public class Student {
	
	String name; // assume students have different names
	double grade; // assume grade is at least 0 and different for different students
	Student leftChild;
	Student rightChild;
	
	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}
}
