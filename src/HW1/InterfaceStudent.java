package HW1;

import java.util.ArrayList;

public interface InterfaceStudent {
	
	// StudentManage1
	public void displaycourse(ArrayList<Course> courses);
	public void StudentManage2(ArrayList<Course> courses);
	public void StudentManage3(ArrayList<Course> courses, String name, int section, String fullname, String username);
	public void StudentManage4(ArrayList<Course> courses, String name, String fullname, String username);
	// StudentManage5
	public void ViewRegisteredCourses(ArrayList<Course> courses, ArrayList<Student> students, String username);
}
