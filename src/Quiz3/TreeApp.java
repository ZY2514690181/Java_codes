package Quiz3;


//This code was adopted from Data Structures and Algorithms in Java / Edition 2 by Robert Lafore
// tree.java
// demonstrates binary search tree

//QUIZ 3 QUESTION: provide the implementation of the methods below + TEST all your methods in the main by using the menu in the main (see main method)


import java.io.*;
import java.util.*; // for Stack class

////////////////////////////////////////////////////////////////
class Node {
	public int iData;              // data item (key)
	public double dData;           // data item
	public Node leftChild;         // this node's left child
	public Node rightChild;        // this node's right child
}  // end class Node

////////////////////////////////////////////////////////////////
class Tree {
	
	private Node root;             // first node of tree

// -------------------------------------------------------------
	public Tree() {
		root = null;
	} // no nodes in tree yet
	
// -------------------------------------------------------------
	// find node with given key
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(int id, double dd) {
		root.iData = id;
		root.dData = dd;
	}
	
	public Node find(int key) {
		// (assumes non-empty tree)
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current; // found it
	}  // end find()
	
// -------------------------------------------------------------
	//this method inserts a node of (id and dd) into the tree. (We are consider a BINARY SEARCH TREE by iData)
	public void insert(int id, double dd) {
		// Put parameters into a new node
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		// Search for the correct position to insert newNode
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent;
		while (true) {
			parent = current;
			if (id < current.iData) {
				current = current.leftChild;
				if (current == null) {
					parent.leftChild = newNode;
					return;
				}
			} else {
				current = current.rightChild;
				if (current == null) {
					parent.rightChild = newNode;
					return;
				}
			}
		} // end of while loop
	}  // end insert()
	
//////////////////////////////////////////////////////
	
	//this method is full implemented see below
	public void traverse(int traverseType) {
		switch(traverseType) {
		case 1: System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 2: System.out.print("\nInorder traversal:  ");
			inOrder(root);
			break;
		case 3: System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}
	
// -------------------------------------------------------------
	private void preOrder(Node localRoot) {
		//implement preOrder traversal
		if (localRoot != null) {
			// print localRoot first, then left child, then right child
			System.out.print(localRoot.iData+" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

// -------------------------------------------------------------
	private void inOrder(Node localRoot) {
		//implement in Order traversal
		if (localRoot != null) {
			// print left child first, then local root, then right child
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	
// -------------------------------------------------------------
	private void postOrder(Node localRoot) {
		//implement postOrder traversal
		if (localRoot != null) {
			// print left child first, then right child, then local root
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData+" ");
		}
	}

///////////////////////////////////////////////////////////////
	void isBST(Node localRoot) {
		//this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTraverseIntoArrayList(arr, localRoot);
		for (int i=0; i<arr.size()-1; i++) {
			if (arr.get(i)>arr.get(i+1)) {
				System.out.println("The tree is not a BST.");
				return;
			}
		}
		System.out.println("The tree is a BST.");
	}
	
	void inOrderTraverseIntoArrayList(ArrayList<Integer> arr, Node localRoot) {
		if (localRoot != null) {
			inOrderTraverseIntoArrayList(arr, localRoot.leftChild);
			arr.add(localRoot.iData);
			inOrderTraverseIntoArrayList(arr, localRoot.rightChild);
		}
	}

// -------------------------------------------------------------
	// delete node with given key (iData) (if there are multiple nodes match key with iData you have to delete all of them.
	// (assumes non-empty list)
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true; // shows whether current node is the left child of parent node
		// First find the node to delete
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				// Node not found
				System.out.println("The node is not found.");
				return false;
			}
		} // end of while
		// When the node to delete has no children
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
		// When the node has left child as the only one child
		else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		}
		// When the node has right child as the only one child
		else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		}
		// When the node has two children
		else {
			// find successor
			Node successor = getSuccessor(current);
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
	
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // The successor is a node on the right branch
		// Find the node with the smallest iData
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		// Link successorParent to successor's right child
		// Link the successor to delNode's right child
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

// -------------------------------------------------------------
	// this method will display the nodes at each level in the tree. (The method should print the nodes (id) as: Level1:.... - Level2:... 
	public void displayTreeLevels() {
		ArrayList<Node> level1Nodes = new ArrayList<Node>();
		level1Nodes.add(root);
		displayLevel(1, level1Nodes);
	}  // end displayTreeLevels()
	
	public void displayLevel(int level, ArrayList<Node> localNodes) {
		if (localNodes.size() == 0) {
			return;
		}
		ArrayList<Node> nextNodes = new ArrayList<Node>();
		System.out.print("id of nodes at level "+level+": ");
		for (int i=0; i<localNodes.size(); i++) {
			System.out.print(localNodes.get(i).iData+" ");
			if (localNodes.get(i).leftChild != null) {
				nextNodes.add(localNodes.get(i).leftChild);
			}
			if (localNodes.get(i).rightChild != null) {
				nextNodes.add(localNodes.get(i).rightChild);
			}
		}
		System.out.println();
		displayLevel(level+1, nextNodes);
	}

// -------------------------------------------------------------
	//given a node who idata is id and dd is ddata display it childen in the following way:
	public void displaymyChilds(int id, double dd) {
		//Left child: idata:  dData: 
		//Right child: idata:  dData: 
		
		//if the node does not have children you display message that the nodes Do not have children.
		// or if one of the child is null, then you display a message stating that.
		
		if (root == null) {
			System.out.println("The tree is empty. This node does not exist!");
			return;
		}
		Node current = root;
		while (current.iData != id || current.dData != dd) {
			if (id < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				System.out.println("This node does not exist!");
				return;
			}
		}
		if (current.leftChild == null && current.rightChild == null) {
			System.out.println("The node does not have children.");
		} else {
			if (current.leftChild == null) {
				System.out.println("The left child is null.");
			} else {
				System.out.println("Left child: iData: "+current.leftChild.iData+" dData: "+current.leftChild.dData);
			}
			if (current.rightChild == null) {
				System.out.println("The right child is null.");
			} else {
				System.out.println("Right child: iData: "+current.rightChild.iData+" dData: "+current.rightChild.dData);
			}
		}		
		
	}
	
// -------------------------------------------------------------
	//this method will display all the leaves (iData and dData) of all the leaves)
	public void displayLeaves() {
		System.out.println("Show all the leaves:");
		// Check leaves in every level
		ArrayList<Node> level1Nodes = new ArrayList<Node>();
		level1Nodes.add(root);
		displayLeavesLevel(level1Nodes);
		System.out.println();
	}
	
	public void displayLeavesLevel(ArrayList<Node> localNodes) {
		if (localNodes.size() == 0) {
			return;
		}
		ArrayList<Node> nextNodes = new ArrayList<Node>(); // Display the leaves at current level and store the rest here
		for (int i=0; i<localNodes.size(); i++) {
			if (localNodes.get(i).leftChild == null && localNodes.get(i).rightChild == null) {
				// This is a leaf
				System.out.print("iData: "+localNodes.get(i).iData+" dData: "+localNodes.get(i).dData+" ");
			} else {
				// This is not a leaf. Its children are stored in nextNodes.
				if (localNodes.get(i).leftChild != null) {
					nextNodes.add(localNodes.get(i).leftChild);
				}
				if (localNodes.get(i).rightChild != null) {
					nextNodes.add(localNodes.get(i).rightChild);
				}
			}
		}
		displayLeavesLevel(nextNodes);
	}
	
// -------------------------------------------------------------
	
} // end class Tree

////////////////////////////////////////////////////////////////
class TreeApp {
	public static void main(String[] args) throws IOException {
		//You can modify this code of the main as much as you want - as longs as  ALL the methods above are being tested and called.
		int ans;
		Tree theTree = new Tree();
		//... you change these inputs to build the tree, and/or can add other inputs to test the program.
		//The tree is ordered by iData.
		
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		//theTree.setRoot(76, 1.5); // Use this line to check if method 2 works
		
		Scanner input = new Scanner(System.in);
		System.out.println("Program starts running.");
		while (true) {
			System.out.println();
			System.out.println("Menu");
			System.out.println("1. Traverse");
			System.out.println("2. isBST");
			System.out.println("3. Delete");
			System.out.println("4. Display Tree by Levels");
			System.out.println("5. Display my Childs");
			System.out.println("6. Insert a New Node");
			System.out.println("7. Display All the Leaves");
			System.out.println("8. Exit");
			
			System.out.println("Enter your choice:"); // Assume a number is entered
			ans = input.nextInt();
			if (ans==1) {
				System.out.println("Please select the traversal type");
				System.out.println("1. PreOrder 2. InOrder 3. PostOrder");
				System.out.println("Enter your choice:"); // Assume a number is entered
				int ans1 = input.nextInt();
				if (ans1!=1 && ans1!=2 && ans1!=3) {
					System.out.println("Invalid input");
				} else {
					theTree.traverse(ans1);
				}
			} else if (ans==2) {
				theTree.isBST(theTree.getRoot());
			} else if (ans==3) {
				System.out.println("Enter the key:"); // Assume an integer is entered
				int ans2 = input.nextInt();
				theTree.delete(ans2);
			} else if (ans==4) {
				theTree.displayTreeLevels();
			} else if (ans==5) {
				System.out.println("Enter the iData:"); // Assume an integer is entered
				int ans3 = input.nextInt();
				System.out.println("Enter the dData:"); // Assume a double is entered
				double ans4 = input.nextDouble();
				theTree.displaymyChilds(ans3, ans4);
			} else if (ans==6) {
				System.out.println("Enter the iData:"); // Assume an integer is entered
				int ans5 = input.nextInt();
				System.out.println("Enter the dData:"); // Assume a double is entered
				double ans6 = input.nextDouble();
				theTree.insert(ans5, ans6);
			} else if (ans==7) {
				theTree.displayLeaves();
			} else if (ans==8) {
				break;
			} else {
				System.out.println("Invalid input");
			}
		}
		input.close();
		System.out.println("Program ends");
	}	
// -------------------------------------------------------------
}  // end class TreeApp
////////////////////////////////////////////////////////////////

// Assume nodes have different iDatas.