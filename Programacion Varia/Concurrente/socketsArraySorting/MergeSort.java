package socketsArraySorting;

public class MergeSort {
	
	public int[] sort(int[] arr) {
		//Si el array introducido tiene una longitud menor o igual a 1 elemento, esta ordenado
		//y lo podemos devolver sin modificaciones.
		if(arr.length <= 1) {
			return arr;
		}
		
		//Calculamos el punto medio de division del array, utilizando su longitud
		int middle = arr.length / 2;
		
		//Definimos los arrays auxiliares que van a ser usados.
		//Podemos asignar el tamaño del array izquierdo en este paso, ya que este siempre sera
		//de un tamaño medio del array principal introducido.
		int[] leftArr = new int[middle];
		int[] rightArr;
		int[] result = new int[arr.length];
		
		//Para asignar el tamaño al array de la derecha, comprobaremos si el numero de elementos
		//en el array introducido es par o impar, en caso de ser par, podemos asignar el tamaño
		//a ser el mismo que el lado izquiedo. En caso contrario, lo asignamos a alojar
		//un elemento mas que el array izquierdo.
		if(arr.length % 2 == 0) {
			rightArr = new int[middle];
		} else {
			rightArr = new int[middle+1];
		}
		
		//Rellenamos el array izquierdo, utilizando un puntero desde 0 hasta la posicion media.
		for(int i = 0; i < middle; i++) {
			leftArr[i] = arr[i];
		}
		
		//Rellenamos el array derecho, utilizando un puntero desde 0 hasta el tamaño de array
		//derecho. En este caso, para no introducir elementos repetidos del array principal,
		//usaremos "middle + 1" para extraer el elemendo deseado.
		for(int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i];
		}
		
		//Asignamos el array izquierdo y derecho al resultado de llamar este propio metodo de
		//nuevo, hasta que el tamaño de ambos sea de 1 y se de el caso base de devolver el 
		//propio array sin modificaciones.
		leftArr = sort(leftArr);
		rightArr = sort(rightArr);
		
		//Una vez llegado al caso base, el resultado se obtiene mediante la mezcla de los dos
		//arrays derecho e izquierdo.
		result = merge(leftArr, rightArr);
		
		//Devolvemos el array obtenido, en este caso, sera un array de paso a ser dividido una
		//vez mas, ya que este caso no es el caso base.
		return result;
	}
	
	public int[] merge(int[] leftArr, int[] rightArr) {
		//Inicializamos el array resultado, que sera del tamaño de la suma de los tamaños
		//de los arrays derecho e izquierdo
		int[] result = new int[leftArr.length + rightArr.length];
		
		//Inicializamos los punteros auxiliares para navegar los arrays.
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		//Este codigo se ejecuta en bucle mientras existan datos en alguno de los 2 arrays.
		while(leftPointer < leftArr.length || rightPointer < rightArr.length) {
			
			//Comprobamos si ambos arrays tienen elementos que no hayan sido accedidos por el 
			//puntero.
			if(leftPointer < leftArr.length && rightPointer < rightArr.length) {
				if(leftArr[leftPointer] < rightArr[rightPointer]) {
					result[resultPointer++] = leftArr[leftPointer++];
				} else {
					result[resultPointer++] = rightArr[rightPointer++];
				}
				
			//En el caso de que existan elementos restantes en alguno de los lados, estos se
			//añaden al array resultado.
			} else if (leftPointer < leftArr.length){
				result[resultPointer++] = leftArr[leftPointer++];
			} else if (rightPointer < rightArr.length) {
				result[resultPointer++] = rightArr[rightPointer++];
			}
		}
		
		//Devolvemos el resultado, el cual sera ya un array mezclado y ordenado correctamente.
		return result;
	}

}
