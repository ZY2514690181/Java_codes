package Lab8;

public class LinklistApp {

	public static void main(String[] args) {
		Linklist theList = new Linklist();
		theList.size();
		theList.insertFirst("Bob");
		theList.insertFirst("Alice");
		theList.size();
		theList.insertLast("Charlie");
		theList.insertLast("David");
		theList.display();
		theList.size();
		theList.remove("David");
		theList.display();
		theList.size();
		theList.update("David", "David & his pet");
		theList.update("Charlie", "Charlie & his pet");
		theList.display();
		theList.size();
	}

}
