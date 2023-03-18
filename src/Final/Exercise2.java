package Final;

public class Exercise2 {

	public static void main(String[] args) {
		
		Graph graph1 = new Graph();
		
		graph1.addVertex('A'); // 0
		graph1.addVertex('B'); // 1
		graph1.addVertex('C'); // 2
		graph1.addVertex('D'); // 3
		graph1.addVertex('E'); // 4
		
		graph1.addEdge(0, 1); // AB
		graph1.addEdge(1, 2); // BC
		graph1.addEdge(0, 3); // AD
		graph1.addEdge(3, 4); // DE
		
		System.out.println("Check graph1");
		checkConnection(graph1);
		
		Graph graph2 = new Graph();
		
		graph2.addVertex('A'); // 0
		graph2.addVertex('B'); // 1
		graph2.addVertex('C'); // 2
		graph2.addVertex('D'); // 3
		graph2.addVertex('E'); // 4
		
		graph2.addEdge(0, 1); // AB
		graph2.addEdge(1, 2); // BC
		graph2.addEdge(0, 3); // AD
		// E is not connected
		
		System.out.println("Check graph2");
		checkConnection(graph2);
		
	}
	
	public static void checkConnection(Graph graph) {
		System.out.print("Show the first vertex and the ones connected to it: ");
		if (graph.checkConnection()) {
			System.out.println("graph is connected");
		} else {
			System.out.println("graph is disconnected");
		}
	}
	
}
