package Final;
// Use the code provided by professor

import java.util.ArrayList;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node find(int key) {
		Node current = root;
		while (current.data != key) {
			if (key < current.data) {
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
	
	public void insert(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (data < current.data) {
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
		
		while (current.data != key) {
			parent = current;
			if (key < current.data) {
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
	
	public int[] traverseInOrder(int length) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		inOrder(root, arrlist);
		int[] arr = new int[arrlist.size()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = arrlist.get(i);
		}
		return arr;
	}
	
	private void inOrder(Node localRoot, ArrayList<Integer> arr) {
		//implement in Order traversal
		if (localRoot != null) {
			// print left child first, then local root, then right child
			inOrder(localRoot.leftChild, arr);
			arr.add(localRoot.data);
			inOrder(localRoot.rightChild, arr);
		}
	}

}
