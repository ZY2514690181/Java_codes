package HW1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Admin extends User implements InterfaceAdmin {
	
	public Admin (String username, String password, String firstname, String lastname) {
		super (username, password, firstname, lastname);
	}
	
	// Course management methods
	
	public void addcourse(ArrayList<Course> courses, String name, String id, int numRegmax, int numReg, ArrayList<String> listReg, String instructor, int section, String location) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == section) {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("There is already a course with the same name and the same section. You cannot add this one.");
		} else {
			Course newcourse = new Course(name, id, numRegmax, numReg, listReg, instructor, section, location);
			courses.add(newcourse);
			System.out.println("This course is added.");
		}
		
	}
	
	public void deletecourse(ArrayList<Course> courses, String name, int section) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == section) {
				courses.remove(i);
				System.out.println("This course is deleted.");
				found = true;
				break;
			}
		} // end of for loop
		if (! found) System.out.println("This course does not exist.");
	}
	
	public boolean editcourse(ArrayList<Course> courses, String name, int sectionInitial, int numRegmax, String instructor, int section, String location) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == sectionInitial) {
				if (numRegmax != 0) {
					if (numRegmax < courses.get(i).getnumReg()) {
						System.out.println("Your attempt to change maximum students failed. The number cannot go below current students.");
					} else {
						courses.get(i).setnumRegmax(numRegmax);
					}
				}
				if (! instructor.equals("0")) courses.get(i).setinstructor(instructor);
				if (section != 0) courses.get(i).setsection(section);
				if (! location.equals("0")) courses.get(i).setlocation(location);
				System.out.println("This course is modified.");
				found = true;
				break;
			}
		} // end of for loop
		if (! found) System.out.println("This course does not exist.");
		return found;
	}
	
	public void editcourse_add_student(ArrayList<Course> courses, ArrayList<Student> students, String name, int section, String username) {
		if (username.equals("0")) return;
		boolean found = false;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getUsername().equals(username)) {
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("This student does not exist!");
			return;
		}
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == section) {
				System.out.println("Trying to add this student ...");
				if (courses.get(i).getnumRegmax() == courses.get(i).getnumReg()) {
					System.out.println("The course is full. You cannot add more students.");
				} else {
					if (courses.get(i).getlistReg().contains(username)) {
						System.out.println("This student is already in the course.");
					} else {
						courses.get(i).getlistReg().add(username);
						courses.get(i).setnumReg(courses.get(i).getnumReg()+1);
						System.out.println("This student is added to the course.");
					}
				}
				break;
			}
		} // end of for loop
	}
	
	public void editcourse_delete_student(ArrayList<Course> courses, ArrayList<Student> students, String name, int section, String username) {
		if (username.equals("0")) return;
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection() == section) {
				if (courses.get(i).getlistReg().contains(username)) {
					courses.get(i).getlistReg().remove(username);
					courses.get(i).setnumReg(courses.get(i).getnumReg()-1);
					System.out.println("This student is removed.");
					found = true;
					break;
				}
			}
		} // end of for loop
		if (! found) System.out.println("This student is not in the course.");
	}
	
	public void displaycourse(ArrayList<Course> courses, String id, int section) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getid().equals(id) && courses.get(i).getsection() == section) {
				courses.get(i).printcourse();
				System.out.println("Finish displaying information.");
				found = true;
				break;
			}
		} // end of for loop
		if (! found) System.out.println("This course does not exist.");
	}
	
	// Reports method
	
	// AdminReport1
	public void displaycourse(ArrayList<Course> courses) {
		for (int i=0; i<courses.size(); i++) {
			courses.get(i).printcourse2();
		}
	}
	
	public ArrayList<Course> AdminReport2(ArrayList<Course> courses) {
		ArrayList<Course> fullcourses = new ArrayList<Course>();
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getnumRegmax() == courses.get(i).getnumReg()) {
				fullcourses.add(courses.get(i));
				System.out.println(courses.get(i).getname()+" Section "+courses.get(i).getsection()+"    ");
			}
		}
		if (fullcourses.isEmpty()) {
			System.out.println("There is no full course.");
		}
		return fullcourses;
	}
	
	public void AdminReport3(ArrayList<Course> courses, ArrayList<Course> fullcourses) {
		try {
			// Consult https://www.w3schools.com/java/java_files_create.asp
		    FileWriter myWriter = new FileWriter("Full courses.txt");
		    for (int i=0; i<fullcourses.size(); i++) {
		    	myWriter.write(fullcourses.get(i).getname()+" Section "+courses.get(i).getsection()+"    ");
		    }
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	public void AdminReport4(ArrayList<Course> courses, ArrayList<Student> students, String name, int section) {
		boolean found = false;
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).getname().equals(name) && courses.get(i).getsection()==section) {
				ArrayList<String> listReg = courses.get(i).getlistReg();
				ArrayList<Student> listRegStudent = new ArrayList<Student>();
				for (int j=0; j<listReg.size(); j++) {
					for (int k=0; k<students.size(); k++) {
						if (listReg.get(j).equals(students.get(k).getUsername())) {
							listRegStudent.add(students.get(k));
						}
					}
				}
				System.out.println("The students registered for this course: ");
				for (int j=0; j<listRegStudent.size(); j++) {
					System.out.print(listRegStudent.get(j).getFirstname()+" "+listRegStudent.get(j).getLastname()+"    ");
				}
				System.out.println();
				found = true;
				break;
			}
		} // end of for loop
		if (! found) System.out.println("This course does not exist.");
	}
	
	// AdminReport5
	public void ViewRegisteredCourses(ArrayList<Course> courses, ArrayList<Student> students, String firstname, String lastname) {
		boolean found = false;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getFirstname().equals(firstname) && students.get(i).getLastname().equals(lastname)) {
				ArrayList<Course> coursesStudentIn = new ArrayList<Course>();
				for (int j=0; j<courses.size(); j++) {
					if (courses.get(j).getlistReg().contains(students.get(i).getUsername())) {
						coursesStudentIn.add(courses.get(j));
					}
				}
				if (coursesStudentIn.isEmpty()) {
					System.out.println("This student registers for no course.");
				} else {
					System.out.println("The following are this student's courses");
					for (int j=0; j<coursesStudentIn.size(); j++) {
						// Display only the course names and sections. Other information about these courses is not needed.
						System.out.print(coursesStudentIn.get(j).getname()+" Section "+coursesStudentIn.get(j).getsection()+"    ");
						System.out.println();
					}
				}
				found = true;
				break;
			}
		}
		if (! found) System.out.println("This student is not found.");
	}
	
	public void AdminReport6(ArrayList<Course> courses) {
		Collections.sort(courses);
		System.out.println("Successfully sorted. Use 'View all courses' to check.");
	}

}
