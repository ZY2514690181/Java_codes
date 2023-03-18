package Final;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		
		LinkedList students = new LinkedList();
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter a student name or 0 to exit: ");
			String name = input.nextLine();
			if (name.equals("0")) {
				break;
			}
			System.out.print("Enter the student's grade: ");
			double grade = input.nextDouble();
			input.nextLine();
			students.insertFirst(name, grade);
			System.out.println("This student is added to the list.");
		}
		
		input.close();
		
		System.out.println("Checkpoint 1");
		
		System.out.println("Show the student list before sorting");
		students.displayAll();
		students = students.selectionSort();
		System.out.println("Show the student list after sorting");
		students.displayAll();
		
	}

}
