package HW1;

import java.util.ArrayList;

public interface InterfaceAdmin {
	
	public void addcourse(ArrayList<Course> courses, String name, String id, int numRegmax, int numReg, ArrayList<String> listReg, String instructor, int section, String location);
	public void deletecourse(ArrayList<Course> courses, String name, int section);
	public boolean editcourse(ArrayList<Course> courses, String name, int sectionInitial, int numRegmax, String instructor, int section, String location);
	public void editcourse_add_student(ArrayList<Course> courses, ArrayList<Student> students, String name, int section, String username);
	public void editcourse_delete_student(ArrayList<Course> courses, ArrayList<Student> students, String name, int section, String username);
	public void displaycourse(ArrayList<Course> courses, String id, int section);
	public void displaycourse(ArrayList<Course> courses);
	public ArrayList<Course> AdminReport2(ArrayList<Course> courses);
	public void AdminReport3(ArrayList<Course> courses, ArrayList<Course> fullcourses);
	public void AdminReport4(ArrayList<Course> courses, ArrayList<Student> students, String name, int section);
	public void ViewRegisteredCourses(ArrayList<Course> courses, ArrayList<Student> students, String firstname, String lastname);
	public void AdminReport6(ArrayList<Course> courses);

}
