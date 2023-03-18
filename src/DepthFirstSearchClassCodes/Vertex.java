package DepthFirstSearchClassCodes;

public class Vertex {
	
	public char label;
	public boolean wasVisited;
	public int friends_club_number;
	
	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
		friends_club_number = -1;
	}

}
