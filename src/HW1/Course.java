package HW1;

import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
	
	private String name;
	private String id;
	private int numRegmax; // max num of registered students
	private int numReg; // current num of registered students
	private ArrayList<String> listReg; // list of registered students
	private String instructor;
	private int section; // section num
	private String location;
	
	public Course(String name, String id, int numRegmax, int numReg, ArrayList<String> listReg, String instructor, int section, String location) {
		this.name = name;
		this.id = id;
		this.numRegmax = numRegmax;
		this.numReg = numReg;
		this.listReg = listReg;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
	}
	
	// getters
	public String getname() {
		return name;
	}
	public String getid() {
		return id;
	}
	public int getnumRegmax() {
		return numRegmax;
	}
	public int getnumReg() {
		return numReg;
	}
	public ArrayList<String> getlistReg() {
		return listReg;
	}
	public String getinstructor() {
		return instructor;
	}
	public int getsection() {
		return section;
	}
	public String getlocation() {
		return location;
	}
	
	// setters
	public void setname(String name) {
		this.name = name;
	}
	public void setid(String id) {
		this.id = id;
	}
	public void setnumRegmax(int numRegmax) {
		this.numRegmax = numRegmax;
	}
	public void setnumReg(int numReg) {
		this.numReg = numReg;
	}
	public void setlistReg(ArrayList<String> listReg) {
		this.listReg = listReg;
	}
	public void setinstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setsection(int section) {
		this.section = section;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	
	// others
	
	public void printcourse() {
		System.out.println("Course name: "+name);
		System.out.println("Course id: "+id);
		System.out.println("Maximum students: "+numRegmax);
		System.out.println("Current students: "+numReg);
		if (listReg.isEmpty()) {
			System.out.println("No student enrolled");
		} else {
			System.out.print("List of students enrolled: ");
			for (int i=0; i<listReg.size(); i++) {
				System.out.print(listReg.get(i)); // Display usernames
				if (i<listReg.size()-1) System.out.print(", ");
			}
			System.out.println();
		}
		System.out.println("Course instructor: "+instructor);
		System.out.println("Course section: "+section);
		System.out.println("Course location: "+location);
	}
	
	public void printcourse2() {
		System.out.println("Course name: "+name);
		System.out.println("Course id: "+id);
		System.out.println("Maximum students: "+numRegmax);
		System.out.println("Current students: "+numReg);
	}
	
	public void printcourse3() {
		System.out.println("Course name: "+name);
		System.out.println("Course id: "+id);
		System.out.println("Maximum students: "+numRegmax);
		System.out.println("Current students: "+numReg);
		System.out.println("Course instructor: "+instructor);
		System.out.println("Course section: "+section);
		System.out.println("Course location: "+location);
	}
	
	public int compareTo(Course courseCompared) {
		return courseCompared.getnumReg() - this.getnumReg();
	}

}
