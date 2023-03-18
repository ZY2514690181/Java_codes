package Final;

//Use the code provided by professor

public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private StackX theStack;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int y=0; y<MAX_VERTS; y++) {
			for (int x=0; x<MAX_VERTS; x++) {
				adjMat[x][y] = 0;
			}
		}
		theStack = new StackX();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	public void DisplaySubGraphs() {
		int[] visitedList = new int[nVerts];
		for (int i=0; i<nVerts; i++) {
			visitedList[i] = 0;
		}
		System.out.print("One connected subgraph: ");
		visitedList = dfs(0,visitedList);
		while (! checkAllVisited(visitedList)) {
			for (int i=0; i<nVerts; i++) {
				if (visitedList[i] == 0) {
					System.out.print("Another connected subgraph: ");
					visitedList = dfs(i,visitedList);
					break;
				}
			}
		}
	}
	
	public boolean checkConnection() {
		int[] visitedList = new int[nVerts];
		for (int i=0; i<nVerts; i++) {
			visitedList[i] = 0;
		}
		visitedList = dfs(0,visitedList);
		if (checkAllVisited(visitedList)) {
			return true;
		}
		return false;
	}
	
	public boolean checkAllVisited(int[] visitedList) {
		for (int i=0; i<visitedList.length; i++) {
			if (visitedList[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void dfs(int start) {
		
		//int count = 1;
		vertexList[start].wasVisited = true;
		vertexList[start].friends_club_number = start;
		displayVertex(start);
		theStack.push(start);
		
		while (! theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].wasVisited = true;
				vertexList[v].friends_club_number = start;
				//count++;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for (int j=0; j<nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
		
	}
	
	public int[] dfs(int start, int[] visitedList) {
		
		vertexList[start].wasVisited = true;
		vertexList[start].friends_club_number = start;
		displayVertex(start);
		theStack.push(start);
		
		while (! theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].wasVisited = true;
				vertexList[v].friends_club_number = start;
				displayVertex(v);
				theStack.push(v);
			}
		}
		System.out.println();
		
		for (int i=0; i<nVerts; i++) {
			if (vertexList[i].wasVisited) {
				visitedList[i] = 1;
			}
		}
		
		for (int j=0; j<nVerts; j++) {
			vertexList[j].wasVisited = false;
		}
		
		return visitedList;
		
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j=0; j<nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
	
}
