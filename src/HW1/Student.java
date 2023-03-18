package HW1;

import java.util.ArrayList;
import java.io.Serializable;

public class Student extends User implements Serializable, InterfaceStudent {
	
	public Student (String username, String password, String firstname, String lastname) {
		super (username, password, firstname, lastname);
	}
	
	// StudentManage1
	public void displaycourse(ArrayList<Course> courses) {
		for (int i=0; i<courses.size(); i++) {
			courses.get(i).printcourse3();
		}
	}
	
	public void StudentManage2(ArrayList<Course> courses) {
		ArrayList<Course> opencourses = new ArrayList<Course>();
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getnumRegmax() > courses.get(i).getnumReg()) {
				opencourses.add(courses.get(i));
				System.out.println(courses.get(i).getname()+" Section "+courses.get(i).getsection()+"    ");
			}
		}
		if (opencourses.isEmpty()) {
			System.out.println("All the courses are full!");
		}
	}
	
	public void StudentManage3(ArrayList<Course> courses, String name, int section, String fullname, String username) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == section) {
				if (courses.get(i).getnumRegmax() == courses.get(i).getnumReg()) {
					System.out.println("The course is full. You cannot register for it.");
				} else {
					if (courses.get(i).getlistReg().contains(username)) {
						System.out.println("You are already in the course.");
					} else {
						courses.get(i).getlistReg().add(username);
						courses.get(i).setnumReg(courses.get(i).getnumReg()+1);
						System.out.println("You are added to the course.");
					}
				}
				found = true;
				break;
			}
		} // end of for loop
		if (! found) System.out.println("This course does not exist.");
	}
	
	public void StudentManage4(ArrayList<Course> courses, String name, String fullname, String username) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name)) {
				if (courses.get(i).getlistReg().contains(username)) {
					courses.get(i).getlistReg().remove(username);
					courses.get(i).setnumReg(courses.get(i).getnumReg()-1);
					System.out.println("You are removed from this course.");
					found = true;
					break;
				}
			}
		} // end of for loop
		if (! found) System.out.println("You are not in the course.");
		
	}
	
	// StudentManage5
	public void ViewRegisteredCourses(ArrayList<Course> courses, ArrayList<Student> students, String username) {
		ArrayList<Course> coursesStudentIn = new ArrayList<Course>();
		for (int j=0; j<courses.size(); j++) {
			if (courses.get(j).getlistReg().contains(username)) {
				coursesStudentIn.add(courses.get(j));
			}
		}
		if (coursesStudentIn.isEmpty()) {
			System.out.println("You have registered for no course.");
		} else {
			System.out.println("The following are your courses");
			for (int j=0; j<coursesStudentIn.size(); j++) {
				// Display only the course names and sections. Other information about these courses is not needed.
				System.out.print(coursesStudentIn.get(j).getname()+" Section "+coursesStudentIn.get(j).getsection()+"    ");
				System.out.println();
			}
		}
	}
	
}
