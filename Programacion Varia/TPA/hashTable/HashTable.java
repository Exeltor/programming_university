package hashTable;

import java.util.Arrays;

public class HashTable {
	
	public int[] table = new int[7];
	int modTableSize = table.length-1;
	int elements;
	
	public HashTable() {
		Arrays.fill(table, -1);
		elements = 0;
	}
	
	public int hashFunc(int data) {
		int index = data % modTableSize;
		
		return index;
	}
	
	public void insert(int data) {
		if(isFull())
			migrate();
		
		int index = hashFunc(data);
		
		if(table[index] == -1)
			table[index] = data;
		else
			quadraticInsert(data, index);
		
	}
	
	public int get(int data) {
		
	}
	
	private boolean isFull() {
		double fraction = elements / table.length;
		
		if(fraction * 100 > 75) {
			return true;
		}
		
		return false;
	}
	
	private void changeHash(int newTableLength) {
		
	}
	
	private void migrate() {
		
	}
	
	private int nextPrime() {
		
	}
	
	private void quadraticInsert(int data, int initIndex) {
		boolean inserted = false;
		int counter = 1;
		
		while(!inserted) {
			int nextIndex = initIndex + (int)Math.pow(counter, 2);
			
			if(table[nextIndex] == -1) {
				table[nextIndex] = data;
				inserted = true;
			} else {
				counter++;
			}
		}
	}
	
	

}
