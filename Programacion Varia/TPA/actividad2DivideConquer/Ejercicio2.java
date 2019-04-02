package actividad2DivideConquer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7};
		int[] arr2 = {2,4,6,8};
		int[] both = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .toArray();
		
		int[] bothSorted = sort(both);
		int median = bothSorted[(bothSorted.length + 1) / 2];
		System.out.println(median);
	}
	
	public static int[] sort(int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}

		int middle = arr.length / 2;
		
		int[] leftArr = new int[middle];
		int[] rightArr;
		int[] result = new int[arr.length];

		if(arr.length % 2 == 0) {
			rightArr = new int[middle];
		} else {
			rightArr = new int[middle+1];
		}

		for(int i = 0; i < middle; i++) {
			leftArr[i] = arr[i];
		}
		
		for(int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i];
		}

		leftArr = sort(leftArr);
		rightArr = sort(rightArr);

		result = merge(leftArr, rightArr);

		return result;
	}
	
	public static int[] merge(int[] leftArr, int[] rightArr) {
		int[] result = new int[leftArr.length + rightArr.length];

		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;

		while(leftPointer < leftArr.length || rightPointer < rightArr.length) {

			if(leftPointer < leftArr.length && rightPointer < rightArr.length) {
				if(leftArr[leftPointer] < rightArr[rightPointer]) {
					result[resultPointer++] = leftArr[leftPointer++];
				} else {
					result[resultPointer++] = rightArr[rightPointer++];
				}

			} else if (leftPointer < leftArr.length){
				result[resultPointer++] = leftArr[leftPointer++];
			} else if (rightPointer < rightArr.length) {
				result[resultPointer++] = rightArr[rightPointer++];
			}
		}

		return result;
	}

}
