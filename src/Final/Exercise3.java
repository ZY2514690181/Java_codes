package Final;

import java.util.Scanner;

// Consult personal answer in Quiz3

public class Exercise3 {
	
	public static class Tree {
		
		private Student root;
		
		public Tree() {
			root = null;
		}
		
		public Student getRoot() {
			return root;
		}
		
		public void setRoot(String name, double grade) {
			root.name = name;
			root.grade = grade;
		}
		
		// code for option 2
		public void insert(String name, double grade) {
			// Put parameters into a new student
			Student newStudent = new Student(name, grade);
			// Search for the correct position to insert newStudent
			if (root == null) {
				root = newStudent;
				return;
			}
			Student current = root;
			Student parent;
			while (true) {
				parent = current;
				if (grade < current.grade) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newStudent;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newStudent;
						return;
					}
				}
			} // end of while loop
		}  // end insert()
		
		// code for option 3
		public void delete(String name) {
			double grade = findGrade(name);
			if (grade == -1) {
				System.out.println("The student is not found.");
			} else {
				delete(name, grade);
				System.out.println("The student is deleted.");
			}
		}
		
		// (assumes non-empty list)
		public boolean delete(String name, double grade) {
			Student current = root;
			Student parent = root;
			boolean isLeftChild = true; // shows whether current student is the left child of parent student
			// First find the student to delete
			while (current.grade != grade) {
				parent = current;
				if (grade < current.grade) {
					isLeftChild = true;
					current = current.leftChild;
				} else {
					isLeftChild = false;
					current = current.rightChild;
				}
				if (current == null) {
					// student not found
					System.out.println("The student with given grade is not found.");
					return false;
				}
			} // end of while
			if (! current.name.equals(name)) {
				System.out.println("The student with given grade is not found.");
				return false;
			}
			// When the student to delete has no children
			if (current.leftChild == null && current.rightChild == null) {
				if (current == root) {
					root = null;
				} else if (isLeftChild) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}
			}
			// When the student has left child as the only one child
			else if (current.rightChild == null) {
				if (current == root) {
					root = current.leftChild;
				} else if (isLeftChild) {
					parent.leftChild = current.leftChild;
				} else {
					parent.rightChild = current.leftChild;
				}
			}
			// When the student has right child as the only one child
			else if (current.leftChild == null) {
				if (current == root) {
					root = current.rightChild;
				} else if (isLeftChild) {
					parent.leftChild = current.rightChild;
				} else {
					parent.rightChild = current.rightChild;
				}
			}
			// When the student has two children
			else {
				// find successor
				Student successor = getSuccessor(current);
				// Put successor to the correct place
				if (current == root) {
					root = successor;
				} else if (isLeftChild) {
					parent.leftChild = successor;
				} else {
					parent.rightChild = successor;
				}
				// The deleted node's left child becomes the successor's
				successor.leftChild = current.leftChild;
			}
			return true;
		}  // end delete()
		
		private Student getSuccessor(Student delStudent) {
			Student successorParent = delStudent;
			Student successor = delStudent;
			Student current = delStudent.rightChild; // The successor is a student on the right branch
			// Find the student with the lowest grade
			while (current != null) {
				successorParent = successor;
				successor = current;
				current = current.leftChild;
			}
			// Link successorParent to successor's right child
			// Link the successor to delNode's right child
			if (successor != delStudent.rightChild) {
				successorParent.leftChild = successor.rightChild;
				successor.rightChild = delStudent.rightChild;
			}
			return successor;
		}
		
		public boolean find(String name, double grade) {
			// (assumes non-empty tree)
			Student current = root;
			while (current.grade != grade) {
				if (grade < current.grade) {
					current = current.leftChild;
				} else {
					current = current.rightChild;
				}
				if (current == null) {
					System.out.println("The student with given grade is not found.");
					return false;
				}
			}
			if (current.name.equals(name)) {
				System.out.println("The student with given grade is not found.");
				return false;
			}
			return true; // found it
		}  // end find()
		
		
		// Code for option 5
		public void traverse() {
			inOrder(root);
			System.out.println();
		}
		
		private void inOrder(Student localRoot) {
			if (localRoot != null) {
				inOrder(localRoot.leftChild);
				System.out.print("Name: "+localRoot.name+" Grade: "+localRoot.grade+" ");
				inOrder(localRoot.rightChild);
			}
		}
		
		// Code for option 6
		public void displayAllAbove(double threshold) {
			displayIfAbove(root, threshold);
			System.out.println();
		}
		
		private void displayIfAbove(Student localRoot, double threshold) {
			if (localRoot != null) {
				displayIfAbove(localRoot.leftChild, threshold);
				if (localRoot.grade > threshold) {
					System.out.print("Name: "+localRoot.name+" Grade: "+localRoot.grade+" ");
				}
				displayIfAbove(localRoot.rightChild, threshold);
			}
		}

		// code for option 4
		public double findGrade(String name) {
			return inOrderFindGrade(root, name);
		}
		
		private double inOrderFindGrade(Student localRoot, String name) {
			if (localRoot != null) {
				double leftGrade = inOrderFindGrade(localRoot.leftChild, name);
				if (leftGrade != -1) {
					return leftGrade;
				}
				if (localRoot.name.equals(name)) {
					return localRoot.grade;
				}
				double rightGrade = inOrderFindGrade(localRoot.rightChild, name);
				if (rightGrade != -1) {
					return rightGrade;
				}
				return -1;
			}
			return -1;
		}
		
	}

	public static void main(String[] args) {
		
		boolean BSTexists = false;
		
		Scanner input = new Scanner(System.in);
		
		Student[] arr = new Student[10];
		Tree BST = new Tree();
		
		while(true) {
			
			System.out.println();
			System.out.println("Menu");
			System.out.println("1. Create a BST (exit if selected for second time)");
			System.out.println("2. Insert a new student");
			System.out.println("3. Delete a student");
			System.out.println("4. Search for student and display the grade");
			System.out.println("5. Display students' grades sorted");
			System.out.println("6. Display all student grades above a value"); // above means >
			System.out.print("Enter your option: ");
			int ans = input.nextInt();
			input.nextLine();
			
			if (ans==1 && BSTexists) {
				break;
			} else if (ans!=1 && !BSTexists) {
				System.out.println("Please construct a BST first");
			} else if (ans==1) {
				System.out.println("Enter 10 students with different names and grades into an array.");
				for (int i=0; i<10; i++) {
					System.out.print("Enter a student's name: ");
					String name = input.nextLine();
					System.out.print("Enter the student's grade: ");
					double grade = input.nextDouble();
					input.nextLine();
					arr[i] = new Student(name, grade);
					System.out.println("You added a new student.");
				}
				for (int i=0; i<10; i++) {
					BST.insert(arr[i].name, arr[i].grade);
				}
				System.out.println("The data in the array are inserted to BST.");
				BSTexists = true;
			} else if (ans==2) {
				System.out.print("Enter a student's name: ");
				String name = input.nextLine();
				System.out.print("Enter the student's grade: ");
				double grade = input.nextDouble();
				input.nextLine();
				BST.insert(name, grade);
				System.out.println("You successfully insert the new student.");
			} else if (ans==3) {
				System.out.print("Enter a student's name: ");
				String name = input.nextLine();
				BST.delete(name);
			} else if (ans==4) {
				System.out.print("Enter a student's name: ");
				String name = input.nextLine();
				double grade = BST.findGrade(name);
				if (grade == -1) {
					System.out.println("The student is not found.");
				} else {
					System.out.println("The student has a grade of "+grade+".");
				}
			} else if (ans==5) {
				BST.traverse();
			} else if (ans==6) {
				System.out.print("Enter a value: ");
				double threshold = input.nextDouble();
				input.nextLine();
				System.out.println("Start displaying");
				BST.displayAllAbove(threshold);
				System.out.println("Finish displaying");
			} else {
				System.out.println("Invalid input. Please enter an integer between 1 and 6.");
			}
		}
		
		input.close();
		
	}

}
