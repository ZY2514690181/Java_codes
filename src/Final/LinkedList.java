package Final;

// Use the code for Quiz2 and selection sort

public class LinkedList {
	
	private StudentLink first;
	
	public LinkedList() {
		first = null;
	}
	
	public void insertFirst(String name, double grade) {
		StudentLink newStudentLink = new StudentLink(name, grade);
		newStudentLink.next = first;
		first = newStudentLink;
	}
	
	public int size() {
		if (first == null) {
			return 0;
		}
		int count = 1;
		StudentLink current = first;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	public StudentLink delete(String name) {
		StudentLink current = first;
		StudentLink previous = first;
		while (current != null) {
			if (current.name.equals(name)) {
				if (current == first) {
					first = first.next;
				} else {
					previous.next = current.next;
				}
				return current;
			}
			previous = current;
			current = current.next;
		}
		return null;
	}
	
	public LinkedList selectionSort() {
		LinkedList newList = new LinkedList();
		StudentLink max;
		StudentLink current;
		int size = size();
		for (int i=0; i<size; i++) {
			current = first;
			max = first;
			while (current != null) {
				if (current.grade > max.grade) {
					max = current;
				}
				current = current.next;
			}
			delete(max.name);
			newList.insertFirst(max.name, max.grade);
		}
		return newList;
	}
	
	public void displayAll() {
		StudentLink current = first;
		while (current != null) {
			System.out.println("Name: "+current.name+" Grade: "+current.grade+" ");
			current = current.next;
		}
	}
	
}
