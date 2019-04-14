package binaryTree;

public class Node<T> {
	
	T data;
	Node<T> left, right;
	
	public Node(T data, Node<T> left, Node<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
