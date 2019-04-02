package pruebaArboles;

public class Node {
	
	int data;
	Node left, right;
	
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}

}
