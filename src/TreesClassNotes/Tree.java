package TreesClassNotes;

// See more methods in Quiz3.
// This is for binary search tree.

public class Tree {
	
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node find(int key) {
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
		return current;
	}
	
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) {
					// go left
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} // end of if go left
				else {
					// go right
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				} // end of else go right
			} // end of while
		} // end of not root
	} // end of insert()
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				// go left
				isLeftChild = true;
				current = current.leftChild;
			} else {
				// go right
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		} // end of while loop
		// The node to delete is found.
		
		if (current.leftChild == null && current.rightChild == null) {
			// if the node has no children, simply delete it.
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.rightChild == null) {
			// if the node has no right child, replace with left subtree
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (current.rightChild == null) {
			// if the node has no left child, replace with right subtree
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {
			// the node has two children, so replace with inorder successor
			// get successor of the node to delete
			Node successor = getSuccessor(current);
			// Connect parent of current to successor instead
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			// Connect successor to current's left child
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

}
