package actividadInd3;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		
		
		//Referirse a la linea 119 de la clase Tree.java
		System.out.println(tree.getHeight());
		
	}

}
