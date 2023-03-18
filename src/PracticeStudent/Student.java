package PracticeStudent;

public class Student {
	
	private String name;
	private int ID;
	private double grade;
	
	public Student (String name, int ID, double grade) {
		this.name = name;
		this.ID = ID;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void printAll() {
		System.out.println("Name: "+name+", ID: "+ID+", Grade: "+grade);
	}

}
