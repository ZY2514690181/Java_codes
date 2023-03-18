package Lab8;

public class Linklist<T> {
	
	private Node first;
	
	public Linklist(){
		first = null;
	}
	
	public void insertFirst(T data) {
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
	}
	
	public void insertLast(T data) {
		Node newNode = new Node(data);
		if (first == null) {
			newNode.next = first;
			first = newNode;
			return;
		}
		Node current = first;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = null;
	}
	
	public void update(T key, T data) {
		// The parameter data is the data to replace key with
		Node current = first;
		while (current != null) {
			if (current.data == key) {
				current.data = data;
				System.out.println("The key is updated.");
				return;
			}
			current = current.next;
		}
		System.out.println("The key does not exist.");
	}
	
	public int size() {
		if (first == null) {
			System.out.println("The linked list is empty. Size is 0.");
			return 0;
		}
		int size = 0;
		Node current = first;
		while (current != null) {
			size++;
			current = current.next;
		}
		System.out.println("The size is "+size+".");
		return size;
	}
	
	public void remove(T key) {
		Node current = first;
		Node previous = first;
		while (current != null) {
			if (current.data == key) {
				if (current == first) {
					first = first.next;
				} else {
					previous.next = current.next;
				}
				System.out.println("The key is removed.");
				return;
			}
			previous = current;
			current = current.next;
		}
		System.out.println("The key does not exist.");
	}
	
	public void display() {
		if (first == null) {
			System.out.println("This is an empty list.");
			return;
		}
		Node current = first;
		System.out.println("Start displaying the list.");
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
		System.out.println("Finish displaying the list.");
	}
	
}
