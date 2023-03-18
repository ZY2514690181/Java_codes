package HW1;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		
		try {
			// try to deserialize
			// Consult https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
			FileInputStream fis1 = new FileInputStream("Students.ser");
			ObjectInputStream ois1 = new ObjectInputStream(fis1);
			students = (ArrayList) ois1.readObject();
		    ois1.close();
		    fis1.close();
		    System.out.println("Students deserialized");
		    FileInputStream fis2 = new FileInputStream("Courses.ser");
			ObjectInputStream ois2 = new ObjectInputStream(fis2);
			courses = (ArrayList) ois2.readObject();
		    ois2.close();
		    fis2.close();
		    System.out.println("Courses deserialized");
		}
		catch(IOException ioe) {
			// This part runs if you are loading the main for the first time.
			System.out.println("Thank you for using my program!");
			// To the grader: the path below should be modified accordingly.
			String fileName = "/Users/zhangyuan/eclipse-workspace/CS102/src/HW1/MyUniversityCourses.csv";
			File file = new File(fileName);
			
			// Consult https://www.baeldung.com/java-csv-file-array
			// Consult https://howtodoinjava.com/java/string/java-split-csv-string-to-list/
			// Consult https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array
			List<List<String>> lines = new ArrayList<>();
	        Scanner inputStream;
	        inputStream = new Scanner(file);

	        while(inputStream.hasNext()){
	            String line= inputStream.nextLine();
	            String[] values = line.split(",");
	            // this adds the currently parsed line to the 2-dimensional string array
	            lines.add(Arrays.asList(values));
	        }

	        inputStream.close();

	        int lineNo = 1;
	        for(List<String> line: lines) {
	            int columnNo = 1;
	            String name = "";
	            String id = "";
	            int numRegmax = 0;
	            int numReg = 0;
	            ArrayList<String> listReg = new ArrayList<String>();
	            String instructor = "";
	            int section = 0;
	            String location = "";
	            for (String value: line) {
	                //System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
	                if (lineNo > 1) {
	                	if (columnNo == 1) {
	                		name = value;
	                	}
	                	else if (columnNo == 2) {
	                		id = value;
	                	}
	                	else if (columnNo == 3) {
	                		numRegmax = Integer.parseInt(value);
	                	}
	                	else if (columnNo == 4) {
	                		numReg = Integer.parseInt(value);
	                	}
	                	else if (columnNo == 5) {
	                		/*String[] listRegDraft = value.split(";");
	                		if (value.equals("NULL")) {
	                			// Nothing needs to be done.
	                		} else {
	                			for (int i=0; i<listRegDraft.length; i++) {
	                				listReg.add(listRegDraft[i]);
	                			} // end of for loop
	                		}*/
	                	} // end of if == 5
	                	else if (columnNo == 6) {
	                		instructor = value;
	                	}
	                	else if (columnNo == 7) {
	                		section = Integer.parseInt(value);
	                	}
	                	else if (columnNo == 8) {
	                		location = value;
	                	}
	                } // end of if
	            	columnNo++;
	            } // end of for loop
	            if (lineNo > 1) {
	            	Course newcourse = new Course(name, id, numRegmax, numReg, listReg, instructor, section, location);
	            	courses.add(newcourse);
	            }
	            lineNo++;
	        } // end of for(List<String> line: lines)
			
		} // end of catch IOexception
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		    return;
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Are you an Admin? Enter 'yes' if so. Enter anything else if not.");
		String ans1 = input.nextLine();
		if (ans1.equals("yes")) {
			System.out.println("Enter username: ");
			String ans2 = input.nextLine();
			System.out.println("Enter password: ");
			String ans3 = input.nextLine();
			if (! ans2.equals("Admin")) {
				System.out.println("Admin does not exist!");
				input.close();
				return;
			} else if (! ans3.equals("Admin001")) {
				System.out.println("Incorrect password!");
				input.close();
				return;
			}
			System.out.println("Welcome, Admin!");
			Admin Admin1 = new Admin(ans2, ans3, "", ""); // empty firstname and lastname (not in homework requirement)
			int ans4;
			while (true) {
				System.out.println();
				System.out.println("Courses Management");
				System.out.println("1. Create a new course");
				System.out.println("2. Delete a course");
				System.out.println("3. Edit a course");
				System.out.println("4. Display information for a given course");
				System.out.println("5. Register a student");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				ans4 = input.nextInt();
				input.nextLine();
				if (ans4 == 1) {
					System.out.println("Course name: ");
					String ans5 = input.nextLine();
					System.out.println("Course id: ");
					String ans6 = input.nextLine();
					System.out.println("Maximum students: ");
					int ans7 = input.nextInt();
					input.nextLine();
					// A new course has no enrolled students.
					int ans8 = 0;
					ArrayList<String> ans9 = new ArrayList<String>();
					System.out.println("Course instructor: ");
					String ans10 = input.nextLine();
					System.out.println("Course section number: ");
					int ans11 = input.nextInt();
					input.nextLine();
					System.out.println("Course location: ");
					String ans12 = input.nextLine();
					Admin1.addcourse(courses, ans5, ans6, ans7, ans8, ans9, ans10, ans11, ans12);
				}
				else if (ans4 == 2) {
					System.out.println("Enter the course name: ");
					String ans13 = input.nextLine();
					System.out.println("Enter the course section: ");
					int ans13_1 = input.nextInt();
					input.nextLine();
					Admin1.deletecourse(courses, ans13, ans13_1);
				}
				else if (ans4 == 3) {
					System.out.println("Enter the course name: ");
					String ans14 = input.nextLine();
					System.out.println("Enter the course section: ");
					int ans14_1 = input.nextInt();
					input.nextLine();
					System.out.println("Start editing. Enter '0' if you wish no change.");
					System.out.println("Maximum students: ");
					int ans15 = input.nextInt();
					input.nextLine();
					System.out.println("Course instructor: ");
					String ans16 = input.nextLine();
					System.out.println("Course section number: "); // DO NOT enter a section number that causes duplication
					int ans17 = input.nextInt();
					input.nextLine();
					System.out.println("Course location: ");
					String ans18 = input.nextLine();
					boolean ans19 = Admin1.editcourse(courses, ans14, ans14_1, ans15, ans16, ans17, ans18);
					if (ans19) {
						String ans20 = "0";
						do {
							Admin1.editcourse_add_student(courses, students, ans14, ans14_1, ans20);
							System.out.println("Enter the username of the student who will be added to this course or enter 0 to skip: ");
							ans20 = input.nextLine();
						} while (! ans20.equals("0"));
						String ans21 = "0";
						do {
							Admin1.editcourse_delete_student(courses, students, ans14, ans14_1, ans21);
							System.out.println("Enter the username of the student who will be removed from this course or enter 0 to skip: ");
							ans21 = input.nextLine();
						} while (! ans21.equals("0"));
					}
				}
				else if (ans4 == 4) {
					System.out.println("Enter the course id: ");
					String ans22 = input.nextLine();
					System.out.println("Enter the course section: ");
					int ans22_1 = input.nextInt();
					input.nextLine();
					Admin1.displaycourse(courses, ans22, ans22_1);
				}
				else if (ans4 == 5) {
					System.out.println("Enter username: ");
					String ans23 = input.nextLine();
					System.out.println("Enter password: ");
					String ans24 = input.nextLine();
					System.out.println("Enter firstname: ");
					String ans25 = input.nextLine();
					System.out.println("Enter lastname: ");
					String ans26 = input.nextLine();
					Student newstudent = new Student(ans23, ans24, ans25, ans26);
					students.add(newstudent);
					System.out.println("This student is added.");
				}
				else if (ans4 == 6) {
					System.out.println("Finish with the management");
					break;
				}
				else {
					System.out.println("Invalid input");
				}
				
			} // end of while loop
			
			int ans27;
			while (true) {
				System.out.println();
				System.out.println("Reports");
				System.out.println("1. View all courses");
				System.out.println("2. View all courses that are full");
				System.out.println("3. Write to a file the list of courses that are full");
				System.out.println("4. View the names of the students being registered in a specific course");
				System.out.println("5. View the list of courses that a given student is being registered on");
				System.out.println("6. Sort courses based on the current number of student registers");
				System.out.println("7. Exit");
				System.out.print("Enter your choice: ");
				ans27 = input.nextInt();
				input.nextLine();
				
				if (ans27==1) {
					Admin1.displaycourse(courses);
				} else if (ans27==2) {
					Admin1.AdminReport2(courses);
				} else if (ans27==3) {
					// Write only the names of these courses. Other information is not important.
					Admin1.AdminReport3(courses, Admin1.AdminReport2(courses));
				} else if (ans27==4) {
					System.out.println("Enter the course name: ");
					String ans28 = input.nextLine();
					System.out.println("Enter the course section: ");
					int ans28_1 = input.nextInt();
					input.nextLine();
					Admin1.AdminReport4(courses, students, ans28, ans28_1);
				} else if (ans27==5) {
					System.out.println("Enter the student's firstname: ");
					String ans29 = input.nextLine();
					System.out.println("Enter the student's lastname: ");
					String ans30 = input.nextLine();
					Admin1.ViewRegisteredCourses(courses, students, ans29, ans30);
				} else if (ans27==6) {
					Admin1.AdminReport6(courses);
				} else if (ans27==7) {
					System.out.println("Finish with the reports");
					break;
				} else {
					System.out.println("Invalid input");
				}
			} // end of while loop

		}
		
		else {
			// This part runs if the response to "Admin or not" is no
			System.out.println("Enter username: ");
			String ans2 = input.nextLine();
			int indexStudent = -1;
			for (int i=0; i<students.size(); i++) {
				if (students.get(i).getUsername().equals(ans2)) {
					indexStudent = i;
					break;
				}
			}
			if (indexStudent == -1) {
				System.out.println("Account does not exist!");
				input.close();
				return;
			}
			System.out.println("Enter password: ");
			String ans3 = input.nextLine();
			if (! ans3.equals(students.get(indexStudent).getPassword())) {
				System.out.println("Incorrect password!");
				input.close();
				return;
			}
			Student student1 = new Student(ans2, ans3, students.get(indexStudent).getFirstname(), students.get(indexStudent).getLastname());
			System.out.println("Welcome, "+student1.getFirstname()+" "+student1.getLastname()+"!");
			int ans4;
			while (true) {
				System.out.println();
				System.out.println("Courses Management");
				System.out.println("1. View all courses");
				System.out.println("2. View all courses that are not full");
				System.out.println("3. Register on a course");
				System.out.println("4. Withdraw from a course");
				System.out.println("5. View all courses that you are registered in");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				ans4 = input.nextInt();
				input.nextLine();
				if (ans4 == 1) {
					student1.displaycourse(courses);
				} else if (ans4 == 2){
					student1.StudentManage2(courses);
				} else if (ans4 == 3){
					System.out.println("Enter the course name: ");
					String ans5 = input.nextLine();
					System.out.println("Enter the course section: ");
					int ans6 = input.nextInt();
					input.nextLine();
					System.out.println("Enter your full name: ");
					String ans7 = input.nextLine();
					student1.StudentManage3(courses, ans5, ans6, ans7, ans2);
				} else if (ans4 == 4){
					// The student is assumed not to join courses with the same name but different sections
					System.out.println("Enter the course name: ");
					String ans8 = input.nextLine();
					System.out.println("Enter your full name: ");
					String ans9 = input.nextLine();
					student1.StudentManage4(courses, ans8, ans9, ans2);
				} else if (ans4 == 5){
					student1.ViewRegisteredCourses(courses, students, ans2);
				} else if (ans4 == 6){
					System.out.println("Finish with the management");
					break;
				} else {
					System.out.println("Invalid input");
				}
			} // end of while
			
		} // end of else
		
		input.close();
		
		try {
			
			FileOutputStream fos1 = new FileOutputStream("students.ser");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(students);
			oos1.close();
			fos1.close();
			System.out.println("Students serialization complete");
			
			FileOutputStream fos2 = new FileOutputStream("courses.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(courses);
			oos2.close();
			fos2.close();
			System.out.println("Courses serialization complete");

			
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // end of main

} // end of class
