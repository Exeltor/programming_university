package actividad2DivideConquer;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		int[] arr = {10, 7, 8, 9, 1, 5}; 
  
        sort(arr, 0, arr.length-1); 
        
        printArray(arr);
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); 
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	private static void sort(int[] arr, int low, int high) {
		if (low < high) {
			
			int pivot = partition(arr, low, high);

			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
		}
	}
	
	
	//Metodo de utilidad(no contar para complejidad)
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
	}
	
	

}
