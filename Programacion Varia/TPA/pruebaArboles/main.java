package pruebaArboles;

public class main {
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(7);
		tree.insert(6);
		
		tree.printTransversal();
	}

}
