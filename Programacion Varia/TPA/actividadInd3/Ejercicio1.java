package actividadInd3;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(5);
		
		//Referirse a la linea 105 de la clase Tree.java
		System.out.println(tree.getCount());
		
	}

}