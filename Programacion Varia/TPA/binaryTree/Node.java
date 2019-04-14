package binaryTree;

/*
 * Author: Alexey Zhelezov
 * 
 * Generic type Node for Generic Type Binary Tree.
 * 
 * Implements the use of any value type that has access to the Comparable interface.
 */

public class Node<T extends Comparable<T>> {
	
	T data;
	Node<T> left, right;
	
	public Node(T data, Node<T> left, Node<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
