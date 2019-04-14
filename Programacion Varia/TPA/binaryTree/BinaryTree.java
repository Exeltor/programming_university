package binaryTree;

public class BinaryTree<T> {

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
		
		if(data < currNode.data) {
			if(currNode.left == null) {
				currNode.left = new Node(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.left);
		} else if (data > currNode.data) {
			if(currNode.right == null) {
				currNode.right = new Node(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.right);
		}
		
	}

}
