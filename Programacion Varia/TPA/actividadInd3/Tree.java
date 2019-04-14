package actividadInd3;

public class Tree {
	
	Node mainRoot;
	
	public Tree() {
		mainRoot = null;
	}
	
	public void insert(int data) {
		if(mainRoot == null)
			mainRoot = new Node(data, null, null);
		else
			insertRecursive(data, mainRoot);
	}
	
	private void insertRecursive(int data, Node currNode) {	
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
	
	public void printDLR() {
		DLRrecursive(mainRoot);
		System.out.println();
	}
	
	public void printLDR() {
		LDRrecursive(mainRoot);
		System.out.println();
	}
	
	public void printLRD() {
		LRDrecursive(mainRoot);
		System.out.println();
	}
	
	public int getCount() {
		if(mainRoot != null)
			return countRecursive(mainRoot);
		
		return 0;
	}
	
	public int getHeight() {
		return heightRecursive(mainRoot) - 1;
	}
	
	public void printTransversal() {
		transversalRecursive(mainRoot);
		System.out.println();
	}
	
	private void DLRrecursive(Node currNode) {
		if(currNode == null)
			return;
		
		System.out.print(currNode.data + " ");
		
		DLRrecursive(currNode.left);
		DLRrecursive(currNode.right);
		
	}
	
	private void LDRrecursive(Node currNode) {
		if(currNode == null)
			return;
		
		LDRrecursive(currNode.left);
		System.out.print(currNode.data + " ");
		LDRrecursive(currNode.right);
		
	}
	
	private void LRDrecursive(Node currNode) {
		if(currNode == null)
			return;
		
		LRDrecursive(currNode.left);
		LRDrecursive(currNode.right);
		System.out.print(currNode.data + " ");
		
	}
	
	//TODO calcular complejidad
	private int countRecursive(Node currNode) {
		int count = 1;
		
		if(currNode.left != null)
			count += countRecursive(currNode.left);
		
		if(currNode.right != null)
			count += countRecursive(currNode.right);
		
		return count;
		
	}
	
	//TODO calcular complejidad
	private int heightRecursive(Node currNode) {
		if(currNode == null) {
			return 0;
		}
		
		return Math.max(heightRecursive(currNode.left), heightRecursive(currNode.right)) + 1;
	}
	
	private void transversalRecursive(Node currNode) {
		if(currNode == null)
			return;
		
		System.out.print(currNode.data + ", ");
		
		if (currNode.left != null)
			//System.out.print(currNode.left.data + ", ");
			transversalRecursive(currNode.left);
		
		
		if(currNode.right != null)
			//System.out.print(currNode.right.data + ", ");
			transversalRecursive(currNode.right);

	}

}
