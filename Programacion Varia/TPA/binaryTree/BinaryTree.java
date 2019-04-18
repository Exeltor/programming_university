package binaryTree;

/*
 * Author: Alexey Zhelezov
 * 
 * Generic Type Binary Tree.
 * 
 * Makes use of the Comparable interface to compare data values which are inferred while instantiating the class.
 * Use with the Generic Type Node class included in the package.
 * 
 * Repeated values are not allowed.
 * 
 * Pre-order, In-Order and Post-Order prints are included.
 */

public class BinaryTree<T extends Comparable<T>> {

	Node<T> mainRoot;
	
	public BinaryTree() {
		mainRoot = null;
	}
	
	public void insert(T data) {
		if(mainRoot == null)
			mainRoot = new Node<T>(data, null, null);
		else
			insertRecursive(data, mainRoot);
	}
	
	private void insertRecursive(T data, Node<T> currNode) {	
		if(currNode.data == data) {
			System.out.println("ya existe");
			return;
		}
		
		if(data.compareTo(currNode.data) < 0) {
			if(currNode.left == null) {
				currNode.left = new Node<T>(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.left);
		} else if (data.compareTo(currNode.data) > 0) {
			if(currNode.right == null) {
				currNode.right = new Node<T>(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.right);
		}
		
	}
	
	public void printDLR() {
		recursiveDLR(mainRoot);
		System.out.println();
	}
	
	public void printLDR() {
		recursiveLDR(mainRoot);
		System.out.println();
	}
	
	public void printLRD() {
		recursiveLRD(mainRoot);
		System.out.println();
	}
	
	private void recursiveDLR(Node<T> currNode) {
		if(currNode == null)
			return;
		
		System.out.print(currNode.data + " ");
		
		recursiveDLR(currNode.left);
		recursiveDLR(currNode.right);
		
	}
	
	private void recursiveLDR(Node<T> currNode) {
		if(currNode == null)
			return;
		
		recursiveLDR(currNode.left);
		System.out.print(currNode.data + " ");
		recursiveLDR(currNode.right);
		
	}
	
	private void recursiveLRD(Node<T> currNode) {
		if(currNode == null)
			return;
		
		recursiveLRD(currNode.left);
		recursiveLRD(currNode.right);
		System.out.print(currNode.data + " ");
		
	}

}
