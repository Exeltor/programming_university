package actividadInd3;

import java.util.ArrayList;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		charTree tree = new charTree();
		
		//añado los nodos de forma manual para replicar el arbol del enunciado
		
		tree.mainRoot = new charNode('b', null, null);
		tree.mainRoot.left = new charNode('u', null, null);
		tree.mainRoot.left.left = new charNode('e', null, null);
		tree.mainRoot.left.left.left = new charNode('n', null, null);
		tree.mainRoot.left.left.left.left = new charNode('o', null, null);
		tree.mainRoot.left.left.left.right = new charNode('a', null, null);
		tree.mainRoot.left.left.left.right.right = new charNode('s', null, null);
		tree.mainRoot.left.right = new charNode('r', null, null);
		tree.mainRoot.left.right.right = new charNode('r', null, null);
		tree.mainRoot.left.right.right.right = new charNode('o', null, null);
		tree.mainRoot.left.right.right.right.left = new charNode('s', null, null);
		tree.mainRoot.left.right.right.left = new charNode('a', null, null);
		tree.mainRoot.right = new charNode('i', null, null);
		tree.mainRoot.right.right = new charNode('l', null, null);
		tree.mainRoot.right.left = new charNode('e', null, null);
		tree.mainRoot.right.left.left = new charNode('n', null, null);
		tree.mainRoot.right.right.left = new charNode('b', null, null);
		tree.mainRoot.right.right.left.left = new charNode('a', null, null);
		tree.mainRoot.right.right.left.left.left = new charNode('o', null, null);
		
		tree.printAllPaths();
		
		
	}

}

class charTree {
	charNode mainRoot;
	
	public charTree() {
		mainRoot = null;
	}
	
	public void insert(char data) {
    if(mainRoot == null)
    	mainRoot = new charNode(data, null, null);
    else
    	insertRecursive(data, mainRoot);
	}
	
	private void insertRecursive(char data, charNode currNode) {	
		if(currNode.data == data) {
			System.out.println("ya existe");
			return;
		}
		
		if(data < currNode.data) {
			if(currNode.left == null) {
				currNode.left = new charNode(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.left);
		} else if (data > currNode.data) {
			if(currNode.right == null) {
				currNode.right = new charNode(data, null, null);
				return;
			}
			
			insertRecursive(data, currNode.right);
		}
		
	}
	
	public void printAllPaths() {
		ArrayList<ArrayList<Character>> allPaths = new ArrayList<>();
		ArrayList<Character> currPath = new ArrayList<>();
		
		pathsRecursive(mainRoot, currPath, allPaths);
		
		for(int i = 0; i < allPaths.size(); i++)
			System.out.println(allPaths.get(i));
		
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
	
	private void DLRrecursive(charNode currNode) {
		if(currNode == null)
			return;
		
		System.out.print(currNode.data + " ");
		
		DLRrecursive(currNode.left);
		DLRrecursive(currNode.right);
		
	}
	
	private void LDRrecursive(charNode currNode) {
		if(currNode == null)
			return;
		
		LDRrecursive(currNode.left);
		System.out.print(currNode.data + " ");
		LDRrecursive(currNode.right);
		
	}
	
	private void LRDrecursive(charNode currNode) {
		if(currNode == null)
			return;
		
		LRDrecursive(currNode.left);
		LRDrecursive(currNode.right);
		System.out.print(currNode.data + " ");
		
	}
	
	private void pathsRecursive(charNode currNode, ArrayList<Character> currPath, ArrayList<ArrayList<Character>> allPaths) {
		if(currNode == null)
			return;
		
		currPath.add(currNode.data);
		
		if(currNode.left == null && currNode.right == null)
			allPaths.add(currPath);	
		else {
			pathsRecursive(currNode.left, new ArrayList<Character>(currPath), allPaths);
			pathsRecursive(currNode.right, new ArrayList<Character>(currPath), allPaths);
		}
	}
	
}

class charNode {
	
	char data;
	charNode left, right;
	
	public charNode(char data, charNode left, charNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
