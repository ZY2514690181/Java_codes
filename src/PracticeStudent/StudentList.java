package PracticeStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
	
	ArrayList<Student> studentList = new ArrayList<>();
	
	public void addStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = input.nextLine();
		System.out.println("Enter ID: ");
		int ID = input.nextInt();
		System.out.println("Enter grade: ");
		double grade = input.nextDouble();
		Student a = new Student(name, ID, grade);
		studentList.add(a);
	}
	
	public void removeStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = input.nextLine();
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equals(name)) {
				studentList.remove(i);
			}
		}
	}

}
