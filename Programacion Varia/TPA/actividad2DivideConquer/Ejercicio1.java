package actividad2DivideConquer;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		
		System.out.println(compare(arr1, arr2));
	}
	
	public static boolean compare(int[] arr1, int[] arr2) {
		if(arr1.length != arr2.length) {
			return false;
		}
		
		if(arr1.length <= 1)
			return compareNum(arr1[0], arr2[0]);
		
		
		int[] leftArr1, leftArr2, rightArr1, rightArr2;
		
		int middle = arr1.length/2;
		
		leftArr1 = new int[middle];
		leftArr2 = new int[middle];
		
		if(arr1.length % 2 != 0) {
			rightArr1 = new int[middle + 1];
			rightArr2 = new int[middle + 1];
		} else {
			rightArr1 = new int[middle];
			rightArr2 = new int[middle];
		}
		
		for(int i = 0; i < middle; i++) {
			leftArr1[i] = arr1[i];
			leftArr2[i] = arr2[i];
		}
		
		for(int i = 0; i < rightArr1.length; i++) {
			rightArr1[i] = arr1[middle + i];
			rightArr2[i] = arr2[middle + i];
		}
		
		boolean left= compare(leftArr1, leftArr2);
		boolean right = compare(rightArr1, rightArr2);
		
		if(left && right) {
			return true;
		}
		
		return false;
		
		
	}
	
	public static boolean compareNum(int num1, int num2) {
		return num1 == num2;
	}


}
