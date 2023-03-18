package ObjectOrientedProgram;

public class BookEntry {
	
	// member variables
	
	private String name;
	private int isbn;
	
	// constructor
	
	public BookEntry(String n, int i) {
		name = n;
		isbn = i;
	}
	
	// getters and setters
	
	public String getname() {
		return name;
	}
	
	public int getisbn() {
		return isbn;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setisbn(int isbn) {
		this.isbn = isbn;
	}
	
	public void printbook() {
		System.out.println("Book name: "+name+"  Book isbn: "+isbn);
	}

}
