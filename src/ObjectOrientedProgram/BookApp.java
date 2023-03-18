package ObjectOrientedProgram;
import java.util.Scanner;

public class BookApp {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		BookEntry[] books = new BookEntry[5];
		for (int count = 0; count < books.length; count++) {
			books[count] = new BookEntry("",0);
		}
		
		int ans = 0;
		
		while (true) {
			System.out.println("Welcome to the book management system!");
			System.out.println("1. add a book");
			System.out.println("2. delete a book");
			System.out.println("3. print all books");
			System.out.println("4. exit");
			System.out.print("Enter your choice: ");
			ans = input.nextInt();
			if (ans == 1) {
				System.out.print("Enter the book name: ");
				input.nextLine();
				String n = input.nextLine();
				System.out.print("Enter the book isbn: ");
				int i = input.nextInt();
				addBook(books, n, i);
			} else if (ans == 2) {
				System.out.print("Enter the book name: ");
				input.nextLine();
				String n = input.nextLine();
				deleteBook(books, n);
			} else if (ans == 3) {
				printAll(books);
			} else if (ans == 4) {
				break;
			} else {
				System.out.println("Invalid input");
			}

		}
		
		input.close();
		
	}
	
	public static void addBook(BookEntry[] books, String n, int i) {
		boolean found = false; // empty space not found initially
		for (int count = 0; count < books.length; count++) {
			if (books[count].getname().equals("")) {
				books[count].setname(n);
				books[count].setisbn(i);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You have no more space for this book.");
		}
	}
	
	public static void deleteBook(BookEntry[] books, String n) {
		boolean found = false; // book to delete not found initially
		for (int count = 0; count < books.length; count++) {
			if (books[count].getname().equals(n)) {
				books[count].setname("");
				books[count].setisbn(0);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this book.");
		}
	}
	
	public static void printAll(BookEntry[] books) {
		for (int count = 0; count < books.length; count++) {
			books[count].printbook();
		}
	}

}
