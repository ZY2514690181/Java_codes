package Lab8;

public class Node<T> {
	public T data;
	public Node next;
	public Node(T data) {
		this.data = data;
	}
	public void displayNode() {
		System.out.print("Node data : "+data+"    ");
	}
}
